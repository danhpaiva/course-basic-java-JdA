/**
 * 
 */
package exercise_three;

import java.util.Scanner;

/**
 * @author danhpaiva
 *
 */
public class Programa {

	public static void main(String[] args) {
		System.out.println("Ponto de Vendas");
		Scanner sc = new Scanner(System.in);
		PontoDeVendas pontoDeVenda = new PontoDeVendas();

		System.out.print("Informe o valor total da compra: ");
		pontoDeVenda.setValorTotal(sc.nextDouble());

		System.out.print("Agora informe o valor do desconto a ser aplicado: ");
		pontoDeVenda.setDesconto(sc.nextDouble());

		System.out.print("Informe o valor pago: ");
		pontoDeVenda.setValorPago(sc.nextDouble());

		System.out.println("O valor total com desconto é: " + pontoDeVenda
				.calcularTotalDesconto(pontoDeVenda.getValorTotal(), pontoDeVenda.getDesconto(), pontoDeVenda));

		System.out.println("Seu troco é: " + pontoDeVenda.calcularTroco(pontoDeVenda));

	}

}
