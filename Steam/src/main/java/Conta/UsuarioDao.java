/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conta;

import Database.DbConnection;
import Database.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class UsuarioDao implements IDao<Usuario> {
    public static final String TABLE = "steamUsuario";
    
//    @Override
//    public String getSaveStatement() {
//        return "INSERT INTO "
//                + TABLE
//                + " (nome, precoBase, recheio_id, valorProduto)"
//                + " VALUES (?, ?, ?, ?)";    
//    }
//
//    @Override
//    public String getUpdateStatement() {
//        return "UPDATE " 
//            + TABLE 
//            + " SET nome = ?, precoBase = ?, recheio_id = ?, valorProduto = ?"
//            + " WHERE id = ?"; 
//    }
//
//    @Override
//    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Usuario e) {
//        try {
//            pstmt.setString(1, e.getNome());
//            
//            pstmt.setObject(2, e.getPrecoBase(), java.sql.Types.DECIMAL);
//            if(e.getRecheio() == null) {
//                pstmt.setString(3, null);
//            } else {
//                pstmt.setObject(3, e.getRecheio().getId(), java.sql.Types.BIGINT);
//            }
//            
//            pstmt.setObject(4, e.calcularValorProduto(), java.sql.Types.DECIMAL);
//
//            // Just for the update
//            if (e.getId() != null) {
//                pstmt.setLong(5, e.getId());
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @Override
//    public String getFindByIdStatement() {
//        return "SELECT id, nome, precoBase, recheio_id, valorProduto, excluido FROM "
//            + TABLE
//            + " WHERE id = ?";
//    }
//
    @Override
    public String getFindAllStatement() {
        return "SELECT * FROM "
            + TABLE;
    }
//    
//    public List<Produto> FindProdutos() {
//        
//        final String SQL = "SELECT nome, precoBase, valorProduto"
//            + " FROM " + TABLE;
//        
//        try ( PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(SQL)) {
//
//            // Show the full sentence
//            System.out.println(">>FINDPRODUTOS SQL: " + preparedStatement);
//
//            // Performs the query on the database
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            // Returns the respective object
//            return extractObjects(resultSet);
//
//        } catch (Exception ex) {
//            System.out.println("Exception: " + ex);
//        }
//
//        return null;
//    }
//  
        
    public List<Usuario> extractObjects(ResultSet resultSet) {
        List<Usuario> objects = new ArrayList<>();

        try {
            while (resultSet.next()) {
                objects.add(extractObject(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return objects.isEmpty() ? null : objects;
    }
    
    
    public List<Usuario> findAll() {
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindAllStatement())) {

            // Show the full sentence
            System.out.println(">>FINDALL SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }
  
    
    @Override
    public Usuario extractObject(ResultSet resultSet) {
        Usuario usuario = null;
        try {
            usuario = new Usuario();

            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setPais(resultSet.getString("pais"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public String getSaveStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void composeSaveStatement(PreparedStatement psmt, Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void composeUpdateStatement(PreparedStatement psmt, Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long saveOrUpdate(Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindByIdStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario findById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveToTrash(Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
