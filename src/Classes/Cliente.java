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
public class Cliente {
    private String CPF;
    private String Nome;
    
    
    public Cliente(String CPF, String Nome) {
	this.CPF = CPF;
        this.Nome = Nome;
	}
    
	public Cliente() {
		
	}
	
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
    
}
