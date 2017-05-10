package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.ItemVenda;


public class ItemVendaTxtDao {
	private static final String NOME_ARQUIVO = "ItemVenda.txt";
	private static ArrayList<ItemVenda> ItemVendaAux = new ArrayList<ItemVenda>();
	
	public void inserir(ItemVenda i){
		ItemVendaAux.add(i);
		
		escreverArquivo();
	}
	
	public void excluir(int cod){
		ItemVenda ItemVendaTemp = buscarPorID(cod);
		ItemVendaAux.remove(ItemVendaTemp);
		
		escreverArquivo();
	}
	
	public ItemVenda buscarPorID(int id) {
		for (ItemVenda ItemVendaTemp : ItemVendaAux) {
			if (ItemVendaTemp.getIdVenda() == id) {
				return ItemVendaTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(ItemVenda i) {
		ItemVenda produtoTemp = buscarPorID(i.getIdVenda());
		
		produtoTemp.setIdVenda(i.getIdVenda());
		produtoTemp.setCodigoProduto(i.getCodigoProduto());
		produtoTemp.setQtde(i.getQtde());
		
		escreverArquivo();
	}
	
	
	public ArrayList<ItemVenda> buscarPorCodProd(String codProd) {
		ArrayList<ItemVenda> busca = new ArrayList<ItemVenda>();
		
		for (ItemVenda ItemVendaTemp : ItemVendaAux) {
			if (ItemVendaTemp.getCodigoProduto().toUpperCase().contains(codProd.toUpperCase())) {
				busca.add(ItemVendaTemp);
			}
		}
		
		return busca;
	}
	
	
	
	public ArrayList<ItemVenda> listar() {
		return ItemVendaAux;
	}
	
	
	
	private void escreverArquivo() {
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			for (ItemVenda produtoTemp : ItemVendaAux) {
				bw.write(produtoTemp.getIdVenda()+";"+produtoTemp.getCodigoProduto()+";"+produtoTemp.getQtde());
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
				ItemVenda i = new ItemVenda(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]));
				ItemVendaAux.add(i);
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
