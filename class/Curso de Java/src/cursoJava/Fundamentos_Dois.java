package cursoJava;

public class Fundamentos_Dois {

	public static void main(String[] args) {
		System.out.println("Uso de vari�veis");
		System.out.println("");
		
		double i = 10;
		
		System.out.println("Operadores Aritm�ticos e Atribui��es!");
		System.out.println("Exemplos:");
		
		System.out.println("i = " + i);
		System.out.println("i = " + i + " + 5 | i = " + (i + 5));
		System.out.println("i = " + i + " - 5 | i = " + (i - 5));
		System.out.println("i = " + i + " * 5 | i = " + (i * 5));
		System.out.println("i = " + i + " / 5 | i = " + (i / 5));
		System.out.println("i = " + i + " % 5 | i = " + (i % 5));
		
		System.out.println("i += 5 | i = " + (i += 5));
		System.out.println("i -= 5 | i = " + (i -= 5));
		System.out.println("i *= 5 | i = " + (i *= 5));
		System.out.println("i /= 5 | i = " + (i /= 5));
		
		i++;
		System.out.println("i++ | i = " + i);
		
		i--;
		System.out.println("i-- | i = " + i);

	}

}
