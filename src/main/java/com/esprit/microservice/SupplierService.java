package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(int id, Supplier newSupplier) {
        if (supplierRepository.findById(id).isPresent()) {
            Supplier existingSupplier = supplierRepository.findById(id).get();
            existingSupplier.setName(newSupplier.getName()); 
            existingSupplier.setLocation(newSupplier.getLocation());
            existingSupplier.setEmail(newSupplier.getEmail()); 
            return supplierRepository.save(existingSupplier);
        } else {
            return null;
        }
    }

    public String deleteSupplier(int id) {
        if (supplierRepository.findById(id).isPresent()) {
            supplierRepository.deleteById(id);
            return "Supplier supprimé";
        } else {
            return "Supplier non supprimé";
        }
    }
    
    public Supplier getSupplierById(int supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }
    public List<Supplier> getSuppliers() {
        return (List<Supplier>) supplierRepository.findAll();
    }
}
