package br.com.britolmbs.farmaoeste.useCases;

import br.com.britolmbs.farmaoeste.entity.Produto;
import br.com.britolmbs.farmaoeste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadatroProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto execute(Produto produto) {
        if (produto.getNome() == null || produto.getPreco() == null || produto.getDescricao() == null || produto.getQuantidade_estoque() == null){
            throw  new IllegalArgumentException("Preencher os campos todos os campos");
        }
        produtoRepository.save(produto);
        return produto;
    }
}
