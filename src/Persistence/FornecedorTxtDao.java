package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.Fornecedor;

public class FornecedorTxtDao {
	private static final String Nome_Arquivo = "Fornecedor.txt";
	private static ArrayList<Fornecedor> fornecedorAux = new ArrayList<Fornecedor>();
	
	public void inserir(Fornecedor f){
		fornecedorAux.add(f);
		
		escreverArquivo();
	}
	
	public void excluir(int id){
		Fornecedor fornecedorTemp = buscarPorID(id);
		fornecedorAux.remove(fornecedorTemp);
		
		escreverArquivo();
	}
	
	
	public Fornecedor buscarPorID(int id) {
		for (Fornecedor fornecedorTemp : fornecedorAux) {
			if (fornecedorTemp.getId() == id) {
				return fornecedorTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(Fornecedor f){
		Fornecedor fornecedorTemp = buscarPorID(f.getId());
		
		fornecedorTemp.setId(f.getId());
		fornecedorTemp.setNome(f.getNome());
	}
	
	
	public ArrayList<Fornecedor> buscarPorNome(String nome) {
		ArrayList<Fornecedor> busca = new ArrayList<Fornecedor>();
		
		for (Fornecedor fornecedorTemp : fornecedorAux) {
			if (fornecedorTemp.getNome().toUpperCase().contains(nome.toUpperCase())) {
				busca.add(fornecedorTemp);
			}
		}
		
		return busca;
	}
	
	
	public ArrayList<Fornecedor> Listar(){
		return fornecedorAux;
	}
	
	private void escreverArquivo(){
		File f = new File(Nome_Arquivo);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try{
                    fw = new FileWriter(f);
                    bw = new BufferedWriter(fw);
		for(Fornecedor fornecedorTemp : fornecedorAux){
			bw.write(fornecedorTemp.getId()+";"+fornecedorTemp.getNome());
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
		File f = new File(Nome_Arquivo);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] dados = linha.split(";");
				Fornecedor i = new Fornecedor(Integer.parseInt(dados[0]), dados[1]);
				fornecedorAux.add(i);
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
