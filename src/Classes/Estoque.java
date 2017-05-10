package Classes;

public class Estoque {
	private int codigoProduto;
	private int Quant;
	
	public Estoque(){
		
	}
	
	public Estoque(int cod, int Quant){
		this.codigoProduto = cod;
		this.Quant = Quant;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getQuant() {
		return Quant;
	}

	public void setQuant(int quant) {
		Quant = quant;
	}
	
	
	
}
