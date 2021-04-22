/**
 * 
 */
package poo;

/**
 * @author danhpaiva
 *
 */
public class Camaro {

	public static void main(String[] args) {
		Carro camaro = new Carro(2020, "amarelo");

		System.out.println("Camaro\nAno: " + camaro.ano + "\nCor: " + camaro.cor);
		camaro.ligar();
		camaro.acelerar();
		camaro.desligar();
	}

}
