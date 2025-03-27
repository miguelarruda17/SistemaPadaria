package org.example.services;

import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Produto;
import org.example.repositories.ClienteRepository;
import org.example.services.exeptions.ObjectNotFoundException;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoService enderecoService;

    public List<Cliente> findAll(){

        return repository.findAll();
    }

    public Cliente findById(Long id) {

        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id +
                        ", Tipo: " + Produto.class.getName()));

    }

    public Cliente insert(Cliente obj) {

        obj.setIdCliente(null);
        obj.setEndereco(enderecoService.findById(obj.getEndereco().getIdEndereco()));
        obj = repository.save(obj);
        return obj;

    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

    public boolean update(Long id, Cliente cliente){

        Optional<Cliente> optional = repository.findById(id);
        if (optional.isPresent()){

            Cliente cliente1 = optional.get();
            cliente1.setNome(cliente.getNome());
            cliente1.setCpfCliente(cliente.getCpfCliente());
            cliente1.setDataNascimento(cliente.getDataNascimento());
            cliente1.setStatusCliente(cliente.getStatusCliente());
            repository.save(cliente1);
            return true;
        }
        return  false;
    }

}
