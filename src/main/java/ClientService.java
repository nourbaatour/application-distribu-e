import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public  Client addClient(Client client){
        return clientRepository.save(client);
    }


    public Client updateClient(long id, Client newClient) {
        if (clientRepository.findById(id).isPresent()) {
            Client existingClient = clientRepository.findById(id).get();
            existingClient.setName(newClient.getName());
            existingClient.setSurname(newClient.getSurname());
            existingClient.setSex(newClient.getSex());
            existingClient.setLocation(newClient.getLocation());
            existingClient.setEmail(newClient.getEmail());
            existingClient.setEntreprise(newClient.getEntreprise());
            existingClient.setDob(newClient.getDob());
            existingClient.setTel(newClient.getTel());
            existingClient.setPostcard(newClient.getPostcard());

            return clientRepository.save(existingClient);
        } else
            return null;
    }

    public String deleteClient(long id) {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
            return "client supprimé";
        } else
            return "client non supprimé";
    }

    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client getClientById(long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }


}
