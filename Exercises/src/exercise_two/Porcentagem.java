/**
 * @author danhpaiva
 *
 */
package exercise_two;

public class Porcentagem {
	private double x;
	private double y;
	private double valor;

	public double getX() {
		return x;
	}

	public double setX(double x) {
		this.x = x;
		return x;
	}

	public double getY() {
		return y;
	}

	public double setY(double y) {
		this.y = y;
		return y;
	}

	public double calcularPorcentagem(Porcentagem p) {
		p.valor = (p.x * p.y) / 100;
		return p.valor;
	}
}
