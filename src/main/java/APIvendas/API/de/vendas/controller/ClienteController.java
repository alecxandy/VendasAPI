package APIvendas.API.de.vendas.controller;

import APIvendas.API.de.vendas.domain.Cliente;
import APIvendas.API.de.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @GetMapping("{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado"));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteRepository.findById(id)
                .map(cliente -> clienteRepository.delete(cliente))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delete sucess"));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> Update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteRepository.findById(id).map(clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            clienteRepository.save(cliente);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> listAll() {
        return ResponseEntity.ok().body(clienteRepository.findAll());
    }


    @GetMapping("/search")
    public ResponseEntity<List<Cliente>> find(Cliente filtro) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example<Cliente> example = Example.of(filtro, exampleMatcher);
        List<Cliente> clienteList = clienteRepository.findAll(example);
        return ResponseEntity.ok().body(clienteList);
    }

}
