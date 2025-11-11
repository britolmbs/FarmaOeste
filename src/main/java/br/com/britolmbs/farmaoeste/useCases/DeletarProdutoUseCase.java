package br.com.britolmbs.farmaoeste.useCases;

import br.com.britolmbs.farmaoeste.entity.Produto;
import br.com.britolmbs.farmaoeste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeletarProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto execute(String nome) {
        if (nome == null || nome.isEmpty()) {
            return null;
        }
        List<Produto> produto = produtoRepository.findByNome(nome);
        if (produto == null) {
            return null;
        }
        produtoRepository.delete((Produto) produto);
        return (Produto) produto;
    }
}
