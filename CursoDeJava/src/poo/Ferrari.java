/**
 * @author danhpaiva
 *
 */
package poo;

public class Ferrari {

	public static void main(String[] args) {
		Carro ferrari = new Carro();

		ferrari.ano = 2021;
		ferrari.cor = "vermelha";

		System.out.println("Ferrari\nAno: " + ferrari.ano + "\nCor: " + ferrari.cor);
		ferrari.ligar();
		ferrari.acelerar();
		ferrari.desligar();

	}

}
