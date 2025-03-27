package org.example.services;

import org.example.entities.Fornecedor;
import org.example.repositories.FornecedorRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> findAll(){

        return repository.findAll();
    }

    public Fornecedor findById(Long id){
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public  Fornecedor insert(Fornecedor fornecedor) {

        return repository.save(fornecedor);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

    public boolean update(Long id, Fornecedor fornecedor){

        Optional<Fornecedor> optional = repository.findById(id);
        if (optional.isPresent()){

            Fornecedor fornecedor1 = optional.get();
            fornecedor1.setRazaoSocial(fornecedor.getRazaoSocial());
            fornecedor1.setNomeFantasia(fornecedor.getNomeFantasia());
            fornecedor1.setCnpj(fornecedor.getCnpj());
            fornecedor1.setStatusFornecedor(fornecedor.getStatusFornecedor());
            repository.save(fornecedor1);
            return true;
        }
        return  false;
    }

}
