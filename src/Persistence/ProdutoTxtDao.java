package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import Classes.Produto;


public class ProdutoTxtDao {
	
	private static final String NOME_ARQUIVO = "Produto.txt";
	private static ArrayList<Produto> produtoAux = new ArrayList<Produto>();
	
	public void inserir(Produto p){
		produtoAux.add(p);
		
		escreverArquivo();
	}
	
	public void excluir(int cod){
		Produto produtoTemp = buscarPorCodigo(cod);
		produtoAux.remove(produtoTemp);
		
		escreverArquivo();
	}
	
	public Produto buscarPorCodigo(int cod) {
		for (Produto produtoTemp : produtoAux) {
			if (produtoTemp.getCodigo() == cod) {
				return produtoTemp;
			}
		}
		
		return null;
	}
	
	public void alterar(Produto p) {
		Produto produtoTemp = buscarPorCodigo(p.getCodigo());
		
		produtoTemp.setCodigo(p.getCodigo());
		produtoTemp.setNome(p.getNome());
		produtoTemp.setValor(p.getValor());
		
		escreverArquivo();
	}
	
	
	public ArrayList<Produto> buscarPorNome(String nome) {
		ArrayList<Produto> busca = new ArrayList<Produto>();
		
		for (Produto clienteTemp : produtoAux) {
			if (clienteTemp.getNome().toUpperCase().contains(nome.toUpperCase())) {
				busca.add(clienteTemp);
			}
		}
		
		return busca;
	}
	
	
	
	public ArrayList<Produto> listar() {
		return produtoAux;
	}
	
	
	
	private void escreverArquivo() {
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			for (Produto produtoTemp : produtoAux) {
				bw.write(produtoTemp.getCodigo()+";"+produtoTemp.getNome()+";"+produtoTemp.getValor());
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
				Produto p = new Produto(Integer.parseInt(dados[0]), dados[1], Float.parseFloat(dados[2]));
				produtoAux.add(p);
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
