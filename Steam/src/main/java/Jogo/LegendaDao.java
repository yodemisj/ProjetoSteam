/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Jogo;

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
 * Classe LegendaDao
 * @author yodem
 */
public class LegendaDao implements IDao<Legenda>{
    public static final String TABLE = "SteamLegendasJogo";

    //<editor-fold defaultstate="collapsed" desc="comment">
                @Override
        public String getSaveStatement() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public String getUpdateStatement() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void composeSaveStatement(PreparedStatement psmt, Legenda e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void composeUpdateStatement(PreparedStatement psmt, Legenda e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Long saveOrUpdate(Legenda e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public String getMoveToTrashStatement() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void moveToTrash(Legenda e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        @Override
        public Legenda findById() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    //</editor-fold>
           
        @Override
        public String getFindByIdStatement() {
            return "select * from "
                   + TABLE 
                   + " where NOMEJOGO = ?";
        }

        @Override
        public String getFindAllStatement() {
            return "select * from "+ TABLE;
        }

        public Legenda findByChave(String NomeJogo) {
            try ( PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getFindByIdStatement(), Statement.RETURN_GENERATED_KEYS)) {

                // Assemble the SQL statement with the id
                preparedStatement.setString(1, NomeJogo);

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
        public Legenda extractObject(ResultSet resultSet) {
            try {
                Legenda legenda = new Legenda();
                legenda.setLegenda(resultSet.getString("legenda"));

            } catch (SQLException ex) { 
                Logger.getLogger(LegendaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
        @Override
        public List<Legenda> extractObjects(ResultSet resultSet) {
            List<Legenda> objects = new ArrayList<>();

            try {
                while (resultSet.next()) {
                    objects.add(extractObject(resultSet));
                }
            } catch (SQLException ex) {
                Logger.getLogger(LinguagemDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return objects.isEmpty() ? null : objects;
        }
        
        @Override
        public List<Legenda> findAll() {
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
