package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.ItemCompra;

public class ItemCompraTxtDao {
	private static final String Nome_Arquivo = "ItemCompra.txt";
	private static ArrayList<ItemCompra> itemAux = new ArrayList<ItemCompra>();
	
	public void inserir(ItemCompra i){
		itemAux.add(i);
		
		escreverArquivo();
	}
	
	public void excluir(int id){
		ItemCompra itemTemp = buscarPorCodProd(id);
		itemAux.remove(itemTemp);
		
		escreverArquivo();
	}
	
	
	public ItemCompra buscarPorCodProd(int id) {
		for (ItemCompra itemTemp : itemAux) {
			if (itemTemp.getCodigoProduto() == id) {
				return itemTemp;
			}
		}
		
		return null;
	}
	
	public ItemCompra buscarPorIdCompra(int id) {
		for (ItemCompra itemTemp : itemAux) {
			if (itemTemp.getIdCompra() == id) {
				return itemTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(ItemCompra i){
		ItemCompra itemTemp = buscarPorIdCompra(i.getIdCompra());
		
		itemTemp.setCodigoProduto(i.getCodigoProduto());
		itemTemp.setIdCompra(i.getIdCompra());
		itemTemp.setQuant(i.getQuant());
	}
	
	
	public ArrayList<ItemCompra> Listar(){
		return itemAux;
	}
	
	private void escreverArquivo(){
		File f = new File(Nome_Arquivo);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try{
                    
                    fw = new FileWriter(f);
                    bw = new BufferedWriter(fw);
		
		for(ItemCompra itemTemp : itemAux){
			bw.write(itemTemp.getCodigoProduto()+";"+itemTemp.getIdCompra()+";"+itemTemp.getQuant());
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
				ItemCompra p = new ItemCompra(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), Integer.parseInt(dados[2]));
				itemAux.add(p);
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
