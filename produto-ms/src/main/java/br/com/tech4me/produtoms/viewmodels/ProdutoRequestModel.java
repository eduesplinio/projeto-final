package br.com.tech4me.produtoms.viewmodels;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoRequestModel {
  @NotNull(message = "O código deve ser informado")
  private int codigo;

  @NotBlank(message = "O nome deve ser preenchido")
  private String nome;

  @NotNull(message = "O valor deve ser informado")
  @Min(value = 0, message = "O valor não pode ser negativo")
  private double valor;

  @NotNull(message = "A quantidade em estoque deve ser informada")
  @Min(value = 0, message = "A quantidade em estoque não pode ser negativa")
  private int quantidadeEstoque;

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public int getQuantidadeEstoque() {
    return quantidadeEstoque;
  }

  public void setQuantidadeEstoque(int quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }
}
