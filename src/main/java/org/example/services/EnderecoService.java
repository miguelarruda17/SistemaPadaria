package org.example.services;

import org.example.entities.Cliente;
import org.example.entities.Endereco;
import org.example.repositories.EnderecoRepository;
import org.example.services.exeptions.ObjectNotFoundException;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll(){

        return repository.findAll();
    }

    public Endereco findById(Long id){
        Optional<Endereco> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public  Endereco insert(Endereco endereco) {

        return repository.save(endereco);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

    public boolean update(Long id, Endereco endereco){

        Optional<Endereco> optional = repository.findById(id);
        if (optional.isPresent()){

            Endereco endereco1 = optional.get();
            endereco1.setLogradouro(endereco.getLogradouro());
            endereco1.setNumero(endereco.getNumero());
            endereco1.setComplemento(endereco.getComplemento());
            endereco1.setCep(endereco.getCep());
            endereco1.setBairro(endereco.getBairro());
            endereco1.setCidade(endereco.getCidade());
            endereco1.setEstado(endereco.getEstado());
            repository.save(endereco1);
            return true;
        }
        return  false;
    }

}
