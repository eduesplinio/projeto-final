package br.com.tech4me.produtoms.services;

import java.util.List;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.produtoms.model.Produto;
import br.com.tech4me.produtoms.model.dtos.ProdutoDto;
import br.com.tech4me.produtoms.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {
  @Autowired
  private ProdutoRepositorio repo;

  public List<ProdutoDto> obterTodosOsProdutos() {
    List<Produto> produtos = repo.findByOrderByNomeAsc();
    TypeToken<List<ProdutoDto>> tipo = new TypeToken<>(){};
    List<ProdutoDto> saida = new ModelMapper().map(produtos, tipo.getType());

    return saida;
  }

  public List<ProdutoDto> obterProdutoPorNome(String nome) {
    List<Produto> produtos = repo.findByNomeContainingIgnoreCase(nome);
    TypeToken<List<ProdutoDto>> tipo = new TypeToken<>() {};
    List<ProdutoDto> saida = new ModelMapper().map(produtos, tipo.getType());

    return saida;
  }

  public ProdutoDto obterProdutoPorCodigo(int codigo) {
    Produto produto = repo.findByCodigo(codigo);
    ProdutoDto saida = new ModelMapper().map(produto, ProdutoDto.class);

    return saida;
  }

  public ProdutoDto criarProduto(ProdutoDto novoProduto) {
    Produto produto = new ModelMapper().map(novoProduto, Produto.class);
    produto = repo.save(produto);

    novoProduto.setId(produto.getId());

    return novoProduto;
  }

  public ProdutoDto alterarEstoqueProduto(int idProduto, int quantidadeDebito) {
    Produto produto = repo.findById(idProduto).get();

    int novoEstoque = produto.getQuantidadeEstoque() - quantidadeDebito;

    if (novoEstoque < 0) {
      throw new PersistenceException("O estoque do produto não pode ser negativo.");
    }

    produto.setQuantidadeEstoque(novoEstoque);

    produto = repo.save(produto);

    return new ModelMapper().map(produto, ProdutoDto.class);
  }

}
