package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierRestAPI implements ErrorController{
 
	@Autowired
	private SupplierService supplierService;

	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
	    return new ResponseEntity<>(supplierService.addSupplier(supplier), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Supplier> updateSupplier(@PathVariable(value = "id") int id,
	                                              @RequestBody Supplier supplier) {
	    return new ResponseEntity<>(supplierService.updateSupplier(id, supplier), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteSupplier(@PathVariable(value = "id") int id) {
	    return new ResponseEntity<>(supplierService.deleteSupplier(id), HttpStatus.OK);
	}

}
