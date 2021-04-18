/**
 * 
 */
package fundamentos;

/**
 * @author danhpaiva
 *
 */
public class Class09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Uso do FOR");

		for (int i = 0; i <= 10; i++)
			System.out.println("Valor do i: " + i);

		System.out.println("\nTabuada de 10");
		for (int i = 0; i <= 10; i++)
			System.out.println("10 * " + i + " = " + (10 * i));

		System.out.println("\nUso do While");
		double valor = 10.1;
		while (valor < 11.5) {
			System.out.println("Valor:" + valor);
			valor += 0.3;
		}

		System.out.println("\nUso do DOWhile");
		double preco = 10;
		do {
			System.out.println("Preço: " + preco);
			preco += 0.2;
		} while (preco < 11);

	}

}
