package br.com.tech4me.produtoms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int codigo;
    private String nome;
    private double valor;
    @Column(name="quantidadeestoque")
    private int quantidadeEstoque;

    public Produto() {}

    public Produto(int codigo){
        this.codigo = codigo;
    }

    public Produto(int codigo, String nome, double valor, int quantidadeEstoque) {
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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Produto && ((Produto)obj).getCodigo() == codigo;
    }

    @Override
    public String toString() {
        return String.format("Codigo: %d - Nome: %s - Valor: %.2f - Estoque: %d", 
                             codigo, nome, valor, quantidadeEstoque);
    }
}