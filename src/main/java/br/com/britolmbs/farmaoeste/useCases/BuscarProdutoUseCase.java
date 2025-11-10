package br.com.britolmbs.farmaoeste.useCases;

import br.com.britolmbs.farmaoeste.entity.Produto;
import br.com.britolmbs.farmaoeste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuscarProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> execute(String nome, UUID id) {
        List<Produto> produtos;
        if (id != null) {
            produtos = produtoRepository.findByNomeAndId(nome, id);
        }else {
            produtos = produtoRepository.findByNome(nome);
        }
        return produtos;
    }
}
