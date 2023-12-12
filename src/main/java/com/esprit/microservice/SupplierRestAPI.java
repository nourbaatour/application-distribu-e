package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierRestAPI implements ErrorController{
	 @Autowired
	    private SupplierService supplierService;

	    @PostMapping("/add")
	    @ResponseBody
	    public Supplier addSupplier(@RequestBody Supplier supplier) {
	        return this.supplierService.addSupplier(supplier);
	    }

	    @PutMapping("/update/{id}")
	    @ResponseBody
	    public Supplier updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
	        return this.supplierService.updateSupplier(id, supplier);
	    }

	    @DeleteMapping("/{id}")
	    @ResponseBody
	    public String deleteSupplier(@PathVariable("id") int id) {
	        return this.supplierService.deleteSupplier(id);
	    }

	    @GetMapping("/{id}")
	    @ResponseBody
	    public Supplier getSupplierById(@PathVariable("id") int id) {
	        return this.supplierService.getSupplierById(id);
	    }

	    @GetMapping
	    @ResponseBody
	    public List<Supplier> getSuppliers() {
	        return this.supplierService.getSuppliers();
	    }


	   
	    
}
