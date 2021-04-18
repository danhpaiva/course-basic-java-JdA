package exercise1;

public class Conversor {
	private double f;

	public double getF() {
		return f;
	}

	public double setF(double f) {
		this.f = f;
		return f;
	}

	private double c;

	public double getC() {
		return c;
	}
	
	public double setC(double c) {
		this.c = c;
		return c;
	}

	public double converter(double f) {
		c = (5 * (f - 32)) / 9;
		setC(c);
		return c;
	}
}
