package Classes;

public class Compra {
	private int id;
	private int idFornecedor;
	private String Data;
        private String NomeProduto;
        private int qtde;
	
	
        
        public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}
        
        public String getNomeProd() {
		return NomeProduto;
	}

	public void setNomeProd(String nome) {
		this.NomeProduto = nome;
	}
        
        
	public int getQtde() {
		return this.qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Compra(){
		
	}
        
    public Compra(int id, int idF, String data, int qtde, String nome){
            this.id = id;
            this.idFornecedor = idF;
            this.Data = data;
            this.NomeProduto = nome;
            this.qtde = qtde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	
	
}
