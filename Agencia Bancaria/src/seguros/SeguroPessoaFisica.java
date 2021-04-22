/**
 * @author danhpaiva
 *
 */
package seguros;

import contas.Conta;

public class SeguroPessoaFisica extends Conta {

	public static void main(String[] args) {
		SeguroPessoaFisica conta_corrente_tres = new SeguroPessoaFisica();

		conta_corrente_tres.setCliente("Thamirys Souza");
		conta_corrente_tres.setSaldo(30000);
		System.out.println("Cliente: " + conta_corrente_tres.getCliente());
		conta_corrente_tres.exibirSaldo();

	}

}
