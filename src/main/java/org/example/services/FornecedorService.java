package org.example.services;

import org.example.dto.FornecedorDTO;
import org.example.entities.Contato;
import org.example.entities.Fornecedor;
import org.example.repositories.FornecedorRepository;
import org.example.services.exeptions.ObjectNotFoundException;
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

    public Fornecedor update(Long id, FornecedorDTO objDto){

        try {

            Fornecedor entity = findById(id);

            entity.setRazaoSocial(objDto.getRazaoSocial());
            entity.setNomeFantasia(objDto.getNomeFantasia());
            entity.setCnpj(objDto.getCnpj());
            entity.setStatusFornecedor(objDto.getStatusFornecedor());

            //=====================================================//

            Contato contato = entity.getContatos().get(0);

            contato.setEmail(objDto.getEmail());
            contato.setCelular(objDto.getCelular());
            contato.setTelefone(objDto.getTelefone());

            //=====================================================//

            return repository.save(entity);

        }catch (ObjectNotFoundException ex){


            // Tratamento de erro quando a entidade não for encontrada
            throw new ResourceNotFoundException("Cliente não encontrado com o id " + id);

        }
    }

}
