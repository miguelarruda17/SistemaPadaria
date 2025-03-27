package org.example.resources;

import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
import org.example.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {

        List<Endereco> endereco = service.findAll();
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/{id}")
    public Endereco findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco) {

        Endereco created = service.insert(endereco);
        return  ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Endereco endereco) {

        if (service.update(id, endereco)) {

            return ResponseEntity.ok().build();

        }else {

            return ResponseEntity.notFound().build();
        }
    }

}
