/**
 * 
 */
package poo;

/**
 * @author danhpaiva
 *
 */
public class Fusca {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Carro fusca = new Carro();

		fusca.ano = 1992;
		fusca.cor = "preto";

		System.out.println("Fusca\nAno: " + fusca.ano + "\nCor: " + fusca.cor);
		fusca.ligar();
		fusca.acelerar();
		fusca.desligar();

	}

}
