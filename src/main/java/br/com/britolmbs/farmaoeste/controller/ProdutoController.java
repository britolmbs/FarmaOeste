package br.com.britolmbs.farmaoeste.controller;

import br.com.britolmbs.farmaoeste.custom_messages.ErrorMessage;
import br.com.britolmbs.farmaoeste.entity.Produto;
import br.com.britolmbs.farmaoeste.useCases.BuscarProdutoUseCase;
import br.com.britolmbs.farmaoeste.useCases.CadatroProdutoUseCase;
import br.com.britolmbs.farmaoeste.useCases.DeletarProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RequestMapping("/produto")
@RestController
public class ProdutoController {

    @Autowired
    CadatroProdutoUseCase cadatroProdutoUseCase;

    @Autowired
    BuscarProdutoUseCase buscarProdutoUseCase;

    @Autowired
    DeletarProdutoUseCase deletarProdutoUseCase;

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

    @GetMapping("/{nome}")
    public List<Produto> findBynomeAndId(@PathVariable String nome, @RequestParam(required = false) UUID id) {
        return buscarProdutoUseCase.execute(nome, id);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarProduto(@RequestParam String nome) {
        deletarProdutoUseCase.execute(nome);
        return ResponseEntity.ok().build();
    }
}
