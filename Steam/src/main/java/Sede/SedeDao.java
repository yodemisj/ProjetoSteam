/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Sede;

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
 * Classe SedeDao
 * @author yodem
 */
public class SedeDao implements IDao<Sede> {
    public static final String TABLE = "SteamSede";
    //<editor-fold defaultstate="collapsed" desc="comment">
    @Override
    public Sede findById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public void composeSaveStatement(PreparedStatement psmt, Sede e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void composeUpdateStatement(PreparedStatement psmt, Sede e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long saveOrUpdate(Sede e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveToTrash(Sede e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  //</editor-fold>
            @Override
        public String getFindByIdStatement() {
            return "select * from "
                   + TABLE 
                   + " where NOME = ?";
        }

        @Override
        public String getFindAllStatement() {
            return "select * from "+ TABLE;
        }

        public Sede findByChave(String Nome) {
            try ( PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getFindByIdStatement(), Statement.RETURN_GENERATED_KEYS)) {

                // Assemble the SQL statement with the id
                preparedStatement.setString(1, Nome);

                // Show the full sentence
                System.out.println(">>FINDBYID SQL: " + preparedStatement);

                // Performs the query on the database
                ResultSet resultSet = preparedStatement.executeQuery();

                // Returns the respective object if exists
                if (resultSet.next()) {
                    return extractObject(resultSet);
                }

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }

            return null;
        }
        
        @Override
        public Sede extractObject(ResultSet resultSet) {
            try {
                Sede sede = new Sede();
                sede.setNome(resultSet.getString("nome"));
                sede.setCidade(resultSet.getString("cidade"));
                sede.setEstado(resultSet.getString("estado"));
                sede.setPais(resultSet.getString("pais"));

            } catch (SQLException ex) { 
            Logger.getLogger(SedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
        }
        
        @Override
        public List<Sede> extractObjects(ResultSet resultSet) {
            List<Sede> objects = new ArrayList<>();

            try {
                while (resultSet.next()) {
                    objects.add(extractObject(resultSet));
                }
            } catch (SQLException ex) {
            Logger.getLogger(SedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objects.isEmpty() ? null : objects;
        }
        
        @Override
        public List<Sede> findAll() {
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

}
