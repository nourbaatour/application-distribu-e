import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getClients();
        return ResponseEntity.ok(clients);
    }
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") int id, @RequestBody Client client){
        return new ResponseEntity<>(clientService.updateClient(id, client),
                HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
    }
}
