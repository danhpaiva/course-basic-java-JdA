/**
 * 
 */
package exercise_one;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author danhpaiva
 *
 */
public class Programa {

	public static void main(String[] args) {

		System.out.println("\tConversão de Temperatura");
		Conversor conversor = new Conversor();
		Scanner leitor = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("#0.0");

		try {
			System.out.print("Digite um valor em Graus Fahrenheit: ");
			conversor.setF(leitor.nextDouble());
			leitor.close();
			System.out.println("Graus Fahrenheit: " + conversor.getF());
			System.out.println(
					"\nTemperatura convertida em Celsius: " + formatador.format(conversor.converter(conversor.getF())));
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}

}
