package Classes;

public class ItemCompra {
	private int idCompra;
	private int codigoProduto;
	private int Quant;
	
	public ItemCompra(){
		
	}
	
	public ItemCompra(int idCompra, int codProduto, int Quant){
		this.idCompra = idCompra;
		this.codigoProduto = codProduto;
		this.Quant = Quant;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
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
