/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Alexandre
 */
public class ItemVenda {
    private int idVenda;
    private String codigoProduto;
    private int Qtde;
    
    public ItemVenda(){
    	
    }
    
    public ItemVenda(int idVenda, String codigoProduto, int Qtde){
    	this.codigoProduto = codigoProduto;
    	this.idVenda = idVenda;
    	this.Qtde = Qtde;
    }
    
    
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public int getQtde() {
		return Qtde;
	}
	public void setQtde(int qtde) {
		Qtde = qtde;
	}
}
