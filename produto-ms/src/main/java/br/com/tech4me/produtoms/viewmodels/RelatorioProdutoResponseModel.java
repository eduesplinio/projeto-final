package br.com.tech4me.produtoms.viewmodels;

import java.util.List;

public class RelatorioProdutoResponseModel {
  private List<ProdutoResponseModel> produtos;
  private double valorMedio;
  private double valorMaximo;
  private double valorMinimo;

  public List<ProdutoResponseModel> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<ProdutoResponseModel> produtos) {
    this.produtos = produtos;
  }

  public double getValorMedio() {
    return valorMedio;
  }

  public void setValorMedio(double valorMedio) {
    this.valorMedio = valorMedio;
  }

  public double getValorMaximo() {
    return valorMaximo;
  }

  public void setValorMaximo(double valorMaximo) {
    this.valorMaximo = valorMaximo;
  }

  public double getValorMinimo() {
    return valorMinimo;
  }

  public void setValorMinimo(double valorMinimo) {
    this.valorMinimo = valorMinimo;
  }

}
