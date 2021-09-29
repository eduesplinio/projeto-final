package br.com.tech4me.produtoms.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.produtoms.model.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
    List<Produto> findByOrderByNomeAsc();
    List<Produto> findByNomeContainingIgnoreCase(String name);
    Produto findByCodigo(Integer codigo);
}