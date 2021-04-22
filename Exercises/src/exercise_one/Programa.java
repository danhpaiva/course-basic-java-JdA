package exercise_one;

import java.text.DecimalFormat;
import java.util.logging.*;
import java.util.Scanner;

/**
 * @author danhpaiva
 *
 */
public class Programa {
	private static final Logger LOGGER = Logger.getLogger("");

	public static void main(String[] args) {
		LOGGER.info("\tConvers�o de Temperatura");
		Conversor conversor = new Conversor();
		Scanner leitor = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("#0.0");

		try {
			LOGGER.info("Digite um valor em Graus Fahrenheit: ");
			conversor.setF(leitor.nextDouble());
			leitor.close();
			LOGGER.info("Graus Fahrenheit: " + conversor.getF());
			String mensagem = "\nTemperatura convertida em Celsius: "
					+ formatador.format(conversor.converter(conversor.getF()));
			LOGGER.info(mensagem);

		} catch (Exception e) {
			LOGGER.info("Ocorreu um erro.");
		}
	}

}
