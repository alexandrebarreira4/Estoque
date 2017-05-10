
package Persistence;

import java.sql.Connection;
import Classes.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoBDdao {
    public void inserir(Produto p){
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("insert into tb_produto (null,?,?)");
            
            
            stmt.setString(1, p.getNome());
            stmt.setFloat(2, p.getValor());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoBDdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoBDdao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public void alterar(Produto p) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("update tb_produto set nome=?, preco=? where codigo=?");
            
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getValor());
  
            stmt.setInt(3, p.getCodigo());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoBDdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoBDdao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Produto> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Produto> produtosTemp = new ArrayList<>();
                
        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement("select * from produto");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                int c = rs.getInt("codigo");
                String n = rs.getString("nome");
                float p = rs.getFloat("preco");  
                
                Produto prod = new Produto(c, n, p);
                produtosTemp.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoBDdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoBDdao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produtosTemp;
    }
    
}
