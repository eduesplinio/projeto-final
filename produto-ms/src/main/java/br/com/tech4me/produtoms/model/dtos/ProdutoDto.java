package br.com.tech4me.produtoms.model.dtos;

public class ProdutoDto {
  private Integer id;
  private int codigo;
  private String nome;
  private double valor;
  private int quantidadeEstoque;

  public ProdutoDto() {
  }

  public ProdutoDto(Integer id, int codigo, String nome, double valor, int quantidadeEstoque) {
    this.id = id;
    this.codigo = codigo;
    this.nome = nome;
    this.valor = valor;
    this.quantidadeEstoque = quantidadeEstoque;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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
