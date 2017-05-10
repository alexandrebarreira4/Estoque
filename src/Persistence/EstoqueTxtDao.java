package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.Estoque;


public class EstoqueTxtDao {
	private static final String Nome_Arquivo = "Estoque.txt";
	private static ArrayList<Estoque> estoqueAux = new ArrayList<Estoque>();
	
	public void inserir(Estoque e){
		estoqueAux.add(e);
		
		escreverArquivo();
	}
	
	public void excluir(int id){
		Estoque estoqueTemp = buscarPorID(id);
		estoqueAux.remove(estoqueTemp);
		
		escreverArquivo();
	}
	
	
	public Estoque buscarPorID(int id) {
		for (Estoque estoqueTemp : estoqueAux) {
			if (estoqueTemp.getCodigoProduto() == id) {
				return estoqueTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(Estoque e){
		Estoque estoqueTemp = buscarPorID(e.getCodigoProduto());
		
		estoqueTemp.setCodigoProduto((e.getCodigoProduto()));
		estoqueTemp.setQuant((e.getQuant()));
		
		escreverArquivo();
	}
	
	public ArrayList<Estoque> Listar(){
		return estoqueAux;
	}
	
	private void escreverArquivo(){
		File f = new File(Nome_Arquivo);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try{
                        fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
		for(Estoque estoqueTemp : estoqueAux){
			bw.write(estoqueTemp.getCodigoProduto()+";"+estoqueTemp.getQuant());
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
				Estoque p = new Estoque(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]));
				estoqueAux.add(p);
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
