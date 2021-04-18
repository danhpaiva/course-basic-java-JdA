/**
 * 
 */
package poo;
import java.util.Random;

/**
 * @author danhpaiva
 *
 */
public class Carro {
	int ano;
	String cor;
	
	public Carro() {
		Random geradorNumero = new Random();
		int chassi = geradorNumero.nextInt(1000);
		System.out.println("Chassi: " + chassi);
	}
	
	public Carro(int ano, String cor) {
		this.ano = ano;
		this.cor = cor;
	}

	public void ligar() {
		System.out.println("engine On...");
	}

	public void desligar() {
		System.out.println("engine Off...");
	}

	public void acelerar() {
		System.out.println("vrummm...");
	}
}
