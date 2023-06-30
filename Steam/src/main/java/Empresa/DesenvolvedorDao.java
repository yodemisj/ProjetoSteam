/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Empresa;

import Database.DbConnection;
import Database.IDao;
import Sede.Sede;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe DesenvolvedorDao
 * @author yodem
 */
public class DesenvolvedorDao implements IDao<Desenvolvedor>{
        public static final String TABLE = "SteamDesenvolvedor";

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
    public void composeSaveStatement(PreparedStatement psmt, Desenvolvedor e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void composeUpdateStatement(PreparedStatement psmt, Desenvolvedor e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long saveOrUpdate(Desenvolvedor e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Desenvolvedor findById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveToTrash(Desenvolvedor e) {
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

        public Desenvolvedor findByChave(String NomeJogo) {
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
        public Desenvolvedor extractObject(ResultSet resultSet) {
            try {
                Desenvolvedor desenvolvedor = new Desenvolvedor();
                desenvolvedor.setNome(resultSet.getString("nome"));
                desenvolvedor.setFundador(resultSet.getString("fundador"));
                desenvolvedor.setDataFundacao(resultSet.getDate("Datafundacao"));
                desenvolvedor.setWebSite(resultSet.getString("Website"));
                Sede sede = new SedeDao().findByChave(resultSet.getString("");
                desenvolvedor.setSede(sede);
//                legenda.setLegenda(resultSet.getString("legenda"));

            } catch (SQLException ex) { 
                Logger.getLogger(DesenvolvedorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
        @Override
        public List<Desenvolvedor> extractObjects(ResultSet resultSet) {
            List<Desenvolvedor> objects = new ArrayList<>();

            try {
                while (resultSet.next()) {
                    objects.add(extractObject(resultSet));
                }
            } catch (SQLException ex) { 
            Logger.getLogger(DesenvolvedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objects.isEmpty() ? null : objects;
        }
        
        @Override
        public List<Desenvolvedor> findAll() {
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
