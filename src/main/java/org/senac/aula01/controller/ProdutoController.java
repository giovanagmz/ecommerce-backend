package org.senac.aula01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.senac.aula01.model.Produto;
import org.senac.aula01.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> get(
        @RequestParam(required = false, defaultValue = "nome") String order,
        @RequestParam(required = false) String filter
    ) {
        Sort s = Sort.by(order);
        if (filter == null) {
            return repository.findAll(s);
        }
        return repository.findByNomeContains(filter, s);
    }    

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return repository.save(produto);
    }
    
}
