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
public class Venda {
    private int id;
    private String data;
    private String cpfCLiente;
    
    public Venda(){
    	
    }
    
    public Venda(int id, String data, String cpfCliente){
    	this.id = id;
    	this.data = data;
    	this.cpfCLiente = cpfCliente;
    	
    }
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCpfCLiente() {
		return cpfCLiente;
	}
	public void setCpfCLiente(String cpfCLiente) {
		this.cpfCLiente = cpfCLiente;
	}
    
    
    
    
}
