package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.Cliente;

public class ClienteTxtDao {
	private static final String NOME_ARQUIVO = "Cliente.txt";
	private static ArrayList<Cliente> ClienteAux = new ArrayList<Cliente>();
	
	public void inserir(Cliente c){
		ClienteAux.add(c);
		
		escreverArquivo();
	}
	
	public void excluir(String CPF){
		Cliente ClienteTemp = buscarPorCPF(CPF);
		ClienteAux.remove(ClienteTemp);
		
		escreverArquivo();
	}
	
	public Cliente buscarPorCPF(String CPF) {
		for (Cliente ClienteTemp : ClienteAux) {
			if (ClienteTemp.getCPF().equals(CPF)) {
				return ClienteTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(Cliente c) {
		Cliente ClienteTemp = buscarPorCPF(c.getCPF());
		
		ClienteTemp.setCPF(c.getCPF());
		ClienteTemp.setNome(c.getNome());
		
		
		escreverArquivo();
	}
	
	
	public ArrayList<Cliente> buscarPorNome(String nome) {
		ArrayList<Cliente> busca = new ArrayList<Cliente>();
		
		for (Cliente ClienteTemp : ClienteAux) {
			if (ClienteTemp.getNome().toUpperCase().contains(nome.toUpperCase())) {
				busca.add(ClienteTemp);
			}
		}
		
		return busca;
	}
	
	
	
	public ArrayList<Cliente> listar() {
		return ClienteAux;
	}
	
	
	
	private void escreverArquivo() {
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			for (Cliente ClienteTemp : ClienteAux) {
				bw.write(ClienteTemp.getCPF()+";"+ClienteTemp.getNome());
				bw.newLine();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static {
		File f = new File(NOME_ARQUIVO);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] dados = linha.split(";");
				Cliente i = new Cliente(dados[0], dados[1]);
				ClienteAux.add(i);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
