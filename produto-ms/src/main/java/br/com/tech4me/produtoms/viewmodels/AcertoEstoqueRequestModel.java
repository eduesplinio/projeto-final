package br.com.tech4me.produtoms.viewmodels;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AcertoEstoqueRequestModel {
  @NotNull(message = "A quantidade em estoque deve ser informada")
  @Min(value = 0, message = "A quantidade em estoque não pode ser negativa")
  private int quantidadeVenda;

  public int getQuantidadeVenda() {
    return quantidadeVenda;
  }

  public void setQuantidadeVenda(int quantidadeVenda) {
    this.quantidadeVenda = quantidadeVenda;
  }
}
