package br.com.impacta.lab.models;

public class Produto {
  public int codigo;
  public String descricao;
  public double valor;

  public String criarResumo() {
    String resumo = "Código do produto é: " + this.codigo + " descrição: " + this.descricao + " valor: " + this.valor;
    return resumo;
  }
}