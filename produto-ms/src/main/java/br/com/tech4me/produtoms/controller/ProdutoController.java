package br.com.tech4me.produtoms.controller;

import static java.util.stream.Collectors.summarizingDouble;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import javax.persistence.PersistenceException;

import com.google.common.reflect.TypeToken;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.produtoms.model.dtos.ProdutoDto;
import br.com.tech4me.produtoms.services.ProdutoService;
import br.com.tech4me.produtoms.viewmodels.AcertoEstoqueRequestModel;
import br.com.tech4me.produtoms.viewmodels.ProdutoRequestModel;
import br.com.tech4me.produtoms.viewmodels.ProdutoResponseModel;
import br.com.tech4me.produtoms.viewmodels.RelatorioProdutoResponseModel;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
  @Autowired
  private ProdutoService service;

  @GetMapping
  public ResponseEntity<List<ProdutoResponseModel>> getTodos() {
    List<ProdutoDto> produtos = service.obterTodosOsProdutos();
    TypeToken<List<ProdutoResponseModel>> token = new TypeToken<>() {
    };
    List<ProdutoResponseModel> saida = new ModelMapper().map(produtos, token.getType());

    return new ResponseEntity<>(saida, HttpStatus.OK);
  }

  @GetMapping(value = "/{codigo}")
  public ResponseEntity<ProdutoResponseModel> getPorCodigo(@PathVariable int codigo) {
    ProdutoDto produto = service.obterProdutoPorCodigo(codigo);

    return new ResponseEntity<>(new ModelMapper().map(produto, ProdutoResponseModel.class), HttpStatus.OK);
  }

  @GetMapping(value = "/nome/{nome}")
  public ResponseEntity<List<ProdutoResponseModel>> getPorNome(@PathVariable String nome) {
    List<ProdutoDto> produtos = service.obterProdutoPorNome(nome);
    TypeToken<List<ProdutoResponseModel>> token = new TypeToken<>() {
    };
    List<ProdutoResponseModel> saida = new ModelMapper().map(produtos, token.getType());

    return new ResponseEntity<>(saida, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProdutoResponseModel> criarProduto(@RequestBody ProdutoRequestModel produto) {
    ModelMapper mapper = new ModelMapper();
    ProdutoDto produtoDto = service.criarProduto(mapper.map(produto, ProdutoDto.class));

    return new ResponseEntity<>(mapper.map(produtoDto, ProdutoResponseModel.class), HttpStatus.CREATED);
  }

  @PostMapping(value = "/{id}/acertoestoque")
  public ResponseEntity<ProdutoResponseModel> alterarEstoque(@RequestBody AcertoEstoqueRequestModel acerto,
      @PathVariable int id) {
    try {
      ProdutoDto produtoDto = service.alterarEstoqueProduto(id, acerto.getQuantidadeVenda());

      return new ResponseEntity<>(new ModelMapper().map(produtoDto, ProdutoResponseModel.class), HttpStatus.OK);
    } catch (PersistenceException ex) {
      return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }
  }

  @GetMapping(value = "/relatorio")
  public ResponseEntity<RelatorioProdutoResponseModel> obterRelatorio() {
    List<ProdutoDto> produtos = service.obterTodosOsProdutos();
    TypeToken<List<ProdutoResponseModel>> token = new TypeToken<>() {
    };

    RelatorioProdutoResponseModel saida = new RelatorioProdutoResponseModel();
    saida.setProdutos(new ModelMapper().map(produtos, token.getType()));

    DoubleSummaryStatistics dados = produtos.stream().collect(summarizingDouble(ProdutoDto::getValor));
    saida.setValorMaximo(dados.getMax());
    saida.setValorMedio(dados.getAverage());
    saida.setValorMinimo(dados.getMin());

    return new ResponseEntity<>(saida, HttpStatus.OK);
  }

}