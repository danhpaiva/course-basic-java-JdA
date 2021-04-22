/**
 * @author danhpaiva
 *
 */
package exercise_three;

public class PontoDeVendas {
	private double valorTotal;
	private double desconto;
	private double totalDesconto;
	private double valorPago;
	private double troco;

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getDesconto() {
		return desconto;
	}

	public double getDesconto(Double desconto) {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getTotalDesconto() {
		return totalDesconto;
	}

	public double calcularTotalDesconto(double totalValor, double desconto, PontoDeVendas ponto) {
		ponto.totalDesconto = totalValor - (totalValor * (desconto / 100));
		return ponto.totalDesconto;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public double getTroco() {
		return troco;
	}

	public double calcularTroco(PontoDeVendas ponto) {
		troco = ponto.valorTotal - ponto.totalDesconto;
		return troco;
	}

}
