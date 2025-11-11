package br.com.britolmbs.farmaoeste.repository;

import br.com.britolmbs.farmaoeste.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    List<Produto> findByNome(String nome);
    List<Produto> findByNomeAndId(String nome, UUID id);

    @Transactional
    void deleteByNome(String nome);
}
