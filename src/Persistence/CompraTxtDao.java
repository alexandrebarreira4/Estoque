package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.Compra;

public class CompraTxtDao {
    
        public CompraTxtDao(){
            
        }
	private static final String NOME_ARQUIVO = "Compra.txt";
	private static ArrayList<Compra> compraAux = new ArrayList<Compra>();
	
	public void inserir(Compra c){
		compraAux.add(c);
		
		escreverArquivo();
	}
	
	public void excluir(int id){
		Compra compraTemp = buscarPorID(id);
		compraAux.remove(compraTemp);
		
		escreverArquivo();
	}
	
	
	public Compra buscarPorID(int id) {
		for (Compra compraTemp : compraAux) {
			if (compraTemp.getId() == id) {
				return compraTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(Compra c){
		Compra compraTemp = buscarPorID(c.getId());
		
		compraTemp.setId(c.getId());
		compraTemp.setData(c.getData());
		compraTemp.setIdFornecedor(c.getIdFornecedor());
	}
	
	public ArrayList<Compra> buscarPorData(String data) {
		ArrayList<Compra> busca = new ArrayList<Compra>();
		
		for (Compra compraTemp : compraAux) {
			if (compraTemp.getData().toUpperCase().contains(data.toUpperCase())) {
				busca.add(compraTemp);
			}
		}
		
		return busca;
	}
        
        public ArrayList<Compra> buscarPorNome(String nome) {
		ArrayList<Compra> busca = new ArrayList<Compra>();
		
		for (Compra compraTemp : compraAux) {
			if (compraTemp.getNomeProd().toUpperCase().contains(nome.toUpperCase())) {
				busca.add(compraTemp);
			}
		}
		
		return busca;
	}
	
	public Compra buscarPorIdFornecedor(int iDfornecedor) {
		for (Compra compraTemp : compraAux) {
			if (compraTemp.getIdFornecedor() == iDfornecedor) {
				return compraTemp;
			}
		}
		
		return null;
	}
        
        public Compra buscarPorQtde(int Qtde) {
		for (Compra compraTemp : compraAux) {
			if (compraTemp.getQtde() == Qtde) {
				return compraTemp;
			}
		}
		
		return null;
	}
	
	public ArrayList<Compra> Listar(){
		return compraAux;
	}
	
	private void escreverArquivo(){
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try{
                    
                    fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
		
		for(Compra compratemp : compraAux){
			bw.write(compratemp.getId()+";"+compratemp.getIdFornecedor()+";"+compratemp.getData());
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
				Compra p = new Compra(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), dados[2], Integer.parseInt(dados[3]), dados[4]);
				compraAux.add(p);
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
