package com.bn.produtos.controller;

import com.bn.produtos.entity.ProdutoModel;
import com.bn.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping ("/api/produtos")
public class RestController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> listarProdutos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public ProdutoModel criar(@RequestBody ProdutoModel ProdutoModel){
        return produtoService.criar(ProdutoModel);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel Produto){
        return produtoService.atualizar(id, Produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        produtoService.deletar(id);
    }

}