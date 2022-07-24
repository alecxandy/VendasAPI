package APIvendas.API.de.vendas.controller;

import APIvendas.API.de.vendas.entity.Cliente;
import APIvendas.API.de.vendas.entity.Produto;
import APIvendas.API.de.vendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Produto produto) {
        produtoRepository.findById(id).map(
                p -> {
                    produto.setId(p.getId());
                    produtoRepository.save(produto);
                    return produto;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.findById(id).map(
                p -> {
                    produtoRepository.deleteById(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }


    @GetMapping("/search")
    public ResponseEntity<List<Produto>> find(Produto filtro) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example<Produto> example = Example.of(filtro, exampleMatcher);
        List<Produto> clienteList = produtoRepository.findAll(example);
        return ResponseEntity.ok().body(clienteList);
    }

}
