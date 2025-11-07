package br.com.britolmbs.farmaoeste.controller;

import br.com.britolmbs.farmaoeste.custom_messages.ErrorMessage;
import br.com.britolmbs.farmaoeste.entity.Produto;
import br.com.britolmbs.farmaoeste.useCases.CadatroProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> create(@RequestBody Produto produto){
        try{
            var result = cadatroProdutoUseCase.execute(produto);
            return ResponseEntity.ok(result);
    }catch (IllegalArgumentException e){
            var errorMessage = new ErrorMessage(e.getMessage(), "IVALID_PARAMS");
            return ResponseEntity.status(400).body(errorMessage);
        }
    }
}
