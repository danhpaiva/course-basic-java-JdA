/**
 * @author danhpaiva
 *
 */
package contas;

public class PessoaFisica {

	public static void main(String[] args) {
		Conta conta_corrente_um = new Conta();

		conta_corrente_um.setCliente("Daniel Paiva");
		conta_corrente_um.setSaldo(70000);
		System.out.println("Cliente: " + conta_corrente_um.getCliente());
		conta_corrente_um.exibirSaldo();
		conta_corrente_um.sacar(10000);
		conta_corrente_um.exibirSaldo();

		System.out.println("\n");

		Conta conta_corrente_dois = new Conta();

		conta_corrente_dois.setCliente("Eliezer Souza");
		conta_corrente_dois.setSaldo(5000);
		System.out.println("Cliente: " + conta_corrente_dois.getCliente());
		conta_corrente_dois.exibirSaldo();
		conta_corrente_dois.depositar(10000);
		conta_corrente_dois.exibirSaldo();

		System.out.println("\n");
		System.out.println("Cliente: " + conta_corrente_um.getCliente());
		System.out.println("Favorecido Cliente: " + conta_corrente_dois.getCliente());

		conta_corrente_um.transferir(conta_corrente_dois, 1000);
		System.out.println("\n");
		System.out.println("Cliente: " + conta_corrente_um.getCliente());
		conta_corrente_um.exibirSaldo();
		System.out.println("Cliente: " + conta_corrente_dois.getCliente());
		conta_corrente_dois.exibirSaldo();

		System.out.println("\n");
		Conta gerente = new Conta();
		double relatorio = gerente.soma(conta_corrente_um.getSaldo(), conta_corrente_dois.getSaldo());
		System.out.println("Relat�rio Gerencial\nSaldo Total: R$" + relatorio);
	}

}
