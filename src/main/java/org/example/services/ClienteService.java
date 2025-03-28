package org.example.services;

import org.example.dto.ClienteDTO;
import org.example.dto.FornecedorDTO;
import org.example.entities.*;
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

    public List<Cliente> findAll() {

        return repository.findAll();
    }

    public Cliente findById(Long id) {

        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id +
                        ", Tipo: " + Produto.class.getName()));

    }

    public Cliente insert(Cliente cliente) {

        return repository.save(cliente);

    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

    public Cliente update(Long id, ClienteDTO objDto) {

        try {

            //======================================================//

            Cliente entity = findById(id);

            entity.setNome(objDto.getNome());
            entity.setCpfCliente(objDto.getCpfCliente());
            entity.setDataNascimento(objDto.getDataNascimento());
            entity.setStatusCliente(objDto.getStatusCliente());

            //=====================================================//

            Contato contato = entity.getContato().get(0);

            contato.setEmail(objDto.getEmail());
            contato.setCelular(objDto.getCelular());
            contato.setTelefone(objDto.getTelefone());

            //=====================================================//

            Endereco endereco = entity.getEndereco().get(0);

            endereco.setLogradouro(objDto.getLogradouro());
            endereco.setNumero(objDto.getNumero());
            endereco.setComplemento(objDto.getComplemento());
            endereco.setBairro(objDto.getBairro());
            endereco.setCidade(objDto.getCidade());
            endereco.setEstado(objDto.getEstado());
            endereco.setCep(objDto.getCep());

            //======================================================//

            return repository.save(entity);

        } catch (ObjectNotFoundException ex){


            // Tratamento de erro quando a entidade não for encontrada
            throw new ResourceNotFoundException("Cliente não encontrado com o id " + id);

        }
    }

}