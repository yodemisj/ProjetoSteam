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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class ContaDao implements IDao<Conta>{
    
    public static final String TABLE = "steamContaPrincipal";

    @Override
    public String getSaveStatement() {
    return "INSERT INTO "
            + TABLE
            + " (login, nickname, senha, pergunta, cpfUsuario)"
            + " VALUES (?, ?, ?, ?, ?)";    
    }
    
    @Override
    public void composeSaveStatement(PreparedStatement pstmt, Conta e) {
        try {
            pstmt.setString(1, e.getLogin());
            pstmt.setString(2, e.getNickname());
            pstmt.setString(3, e.getSenha());
            pstmt.setString(4, e.getPergunta());
            pstmt.setString(5, e.getUsuario().getCpf());
            
        } catch (Exception ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save(Conta e) {
        try ( 
                PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getSaveStatement(),
                        Statement.RETURN_GENERATED_KEYS)) {
                // Assemble the SQL statement with the data (->?)
                composeSaveStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">>SAVE SQL: " + preparedStatement);
                System.out.println(">> " + e.toString());
                // Performs insertion into the database
                preparedStatement.executeUpdate();
        }   
            catch (ClassNotFoundException ex) {
                Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getUpdateStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void composeUpdateStatement(PreparedStatement psmt, Conta e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long saveOrUpdate(Conta e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindByIdStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Conta findById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindAllStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Conta> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveToTrash(Conta e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Conta extractObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Conta> extractObjects(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

