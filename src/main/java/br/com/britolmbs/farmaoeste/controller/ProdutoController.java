package br.com.britolmbs.farmaoeste.controller;

import br.com.britolmbs.farmaoeste.entity.Produto;
import br.com.britolmbs.farmaoeste.useCases.CadatroProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/produto")
@RestController
public class ProdutoController {

    @Autowired
    CadatroProdutoUseCase cadatroProdutoUseCase;

    @PostMapping("/create")
    public Produto create(@RequestBody Produto produto){
        return cadatroProdutoUseCase.execute(produto);
    }
}
