package br.com.impacta.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.impacta.lab.models.Produto;

@RestController
@RequestMapping("/simular")
public class SimularValoresController {

	@GetMapping
	public ResponseEntity<String> simularValores(@RequestParam(name="codigoProduto") int codigoProduto,
			@RequestParam(name="codTipoPagamento") int codTipoPagamento) {
		/*
		 * Exemplo de chamada:
		 * https://<URL-REPL-IT>/simular?codigoProduto=1&codTipoPagamento=2
		 * 
		 * Elabore um algoritmo para calcular o valor final de um produto com base em seu valor REAL
		 *  e a condição de pagamento.
		 *  
		 *  A escolha do produto e sua condição de pagamento da-se através de seus códigos, faça um 
		 *  algoritmo também para realizar a escolha de cada um dos itens a partir de seus códigos.
		 *  
		 *  Tabela de produto
		 *  
		 *  CodigoProduto	descrição do Produto		Valor do Produto
		 * 	1				Camisa						70.00
		 * 	2				Shorts						57.50
		 * 	3				Meia						9.99
		 * 	4				Toca						35.00
		 * 	5				Luvas						19.50
		 * 
		 * -----------------------------------------------------------------
		 * 
		 * Tabela de condição de pagamento
		 * 
		 * 	CodTipoPagamento		descrição da condição de pagamento
		 * 	1						A vista no dinheiro com 10% de desconto
		 * 	2						A vista no cartão de crédito  com 5% de desconto
		 * 	3						Em duas parcelas sem nenhum desconto
		 * 	4						Em três vezes com 10% de juros
		 * 
		 * OBS: Considerar sempre os descontos ou juros do valor do produto
		 * A resposta do exercicio deve seguir o seguinte formato:
		 * 
		 * <descrição do produto> sendo pago <descrição da condição de pagamento> custará <valor final do produto> reais
		 * 
		 * Ex.: Camisa sendo pago A vista no dinheiro com 10% de desconto custará 63.0 reais
		 * 
		 */
		
    String retorno = simular(codigoProduto, codTipoPagamento);

    // Produto camisa = new Produto();
    // camisa.codigo = 1;
    // camisa.descricao = "Camisa";
    // camisa.valor = 70.00;
    // camisa.criarResumo();
		
		return ResponseEntity.ok(retorno);
	}

  public String simular(int codProduto, int codTipoPagamento) {
    String descricaoProduto = "";
    String descricaoCondicaoPagamento = "";
    double valorFinal = 0;

    if (codProduto == 1) {
      descricaoProduto = "Camisa";
      valorFinal = 70.00;
    }
    else if (codProduto == 2) {
      descricaoProduto = "Shorts";
      valorFinal = 57.50;
    }
    else if (codProduto == 3) {
      descricaoProduto = "Meia";
      valorFinal = 9.99;
    }
    else if (codProduto == 4) {
      descricaoProduto = "Toca";
      valorFinal = 35.00;
    }
    else if (codProduto == 5) {
      descricaoProduto = "Luvas";
      valorFinal = 19.50;
    }

    if (codTipoPagamento == 1) {
      descricaoCondicaoPagamento = "A vista no dinheiro com 10% de desconto";

      valorFinal = valorFinal - (valorFinal * 0.1);
    }
    else if (codTipoPagamento == 2) {
      descricaoCondicaoPagamento = "A vista no cartão de crédito  com 5% de desconto";

      valorFinal = valorFinal - (valorFinal * 0.05);
    }
    else if (codTipoPagamento == 3) {
      descricaoCondicaoPagamento = "Em duas parcelas sem nenhum desconto";
    }
    else if (codTipoPagamento == 4) {
      descricaoCondicaoPagamento = "Em três vezes com 10% de juros";

      valorFinal = valorFinal - (valorFinal * 1.1);
    }

    return descricaoProduto + " sendo pago " + descricaoCondicaoPagamento + " custará " + valorFinal + " reais";
  }
	
}
