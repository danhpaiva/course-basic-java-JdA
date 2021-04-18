/**
 * 
 */
package poo;

/**
 * @author danhpaiva
 *
 */
public class Cessna {

	public static void main(String[] args) {
		Aviao cessna = new Aviao();

		cessna.ano = 2000;
		cessna.cor = "cinza";
		cessna.envergadura = 11;
		System.out.println("Avião Cessna");
		System.out.println("Ano: " + cessna.ano);
		System.out.println("Cor: " + cessna.cor);
		System.out.println("Envergadura: " + cessna.envergadura);
		cessna.desligar();
		cessna.aterrizar();
		cessna.ligar();
		cessna.acelerar();
	}

}
