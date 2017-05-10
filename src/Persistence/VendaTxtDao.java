package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.Venda;



public class VendaTxtDao {
	private static final String NOME_ARQUIVO = "Venda.txt";
	private static ArrayList<Venda> VendaAux = new ArrayList<Venda>();
	
	public void inserir(Venda v){
		VendaAux.add(v);
		
		escreverArquivo();
	}
	
	public void excluir(int id){
		Venda produtoTemp = buscarPorID(id);
		VendaAux.remove(produtoTemp);
		
		escreverArquivo();
	}
	
	public Venda buscarPorID(int id) {
		for (Venda VendaTemp : VendaAux) {
			if (VendaTemp.getId() == id) {
				return VendaTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(Venda v) {
		Venda VendaTemp = buscarPorID(v.getId());
		
		VendaTemp.setId(v.getId());
		VendaTemp.setCpfCLiente(v.getCpfCLiente());
		VendaTemp.setData(v.getData());
		
		escreverArquivo();
	}
	
	
	public ArrayList<Venda> buscarPorCPF(String CPF) {
		ArrayList<Venda> busca = new ArrayList<Venda>();
		
		for (Venda VendaTemp : VendaAux) {
			if (VendaTemp.getCpfCLiente().toUpperCase().contains(CPF.toUpperCase())) {
				busca.add(VendaTemp);
			}
		}
		
		return busca;
	}
	
	
	
	public ArrayList<Venda> listar() {
		return VendaAux;
	}
	
	
	
	private void escreverArquivo() {
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			for (Venda VendaTemp : VendaAux) {
				bw.write(VendaTemp.getId()+";"+VendaTemp.getCpfCLiente()+";"+VendaTemp.getData());
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
				Venda p = new Venda(Integer.parseInt(dados[0]), dados[1], dados[2]);
				VendaAux.add(p);
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
