/**
 * @author danhpaiva
 *
 */
package exercise_two;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Calculo de Porcentagem\n");

		System.out.print("Digite o valor: ");
		Scanner sc = new Scanner(System.in);
		Porcentagem porcentagem = new Porcentagem();
		porcentagem.setY(sc.nextDouble());

		System.out.print("Agora digite o valor da porcentagem em cima de " + porcentagem.getY() + ": ");
		porcentagem.setX(sc.nextDouble());
		sc.close();

		System.out.println("O valor da porcentagem �: " + porcentagem.calcularPorcentagem(porcentagem));
	}

}
