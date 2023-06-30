/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Jogo;

import Database.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe JogoDao
 * @author yodem
 */
public class JogoDao implements IDao<Jogo>{
    public static final String TABLE = "SteamJogo";

    @Override
    public String getSaveStatement() {
        return "insert into "
               + TABLE 
               + " (NOME, EDICAO, CLASSIFICACAO, GENERO, SINOPSE, PRECO, NOMEDESENVOLVEDOR) values (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "
               + TABLE 
               + " set EDICAO = ?, CLASSIFICACAO = ?, GENERO = ?, SINOPSE = ?, PRECO = ?, NOMEDESENVOLVEDOR = ? where NOME = ?";
    }

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

    @Override
    public String getMoveToTrashStatement() {
        return "delete from "+ TABLE + " where NOME = ?";
    }
    
    @Override
    public void composeSaveStatement(PreparedStatement psmt, Jogo e) {
        // (NOME, EDICAO, CLASSIFICACAO, GENERO, SINOPSE, PRECO, NOMEDESENVOLVEDOR) values (?, ?, ?, ?, ?, ?, ?)
        try{
            psmt.setObject(1,e.getNome());
            psmt.setObject(2,e.getEdicao());                 
            psmt.setObject(3,e.getClassificacao());      
            psmt.setObject(4,e.getGenero());      
            psmt.setObject(5,e.getSinopse());
            psmt.setObject(6,e.getPreco());
            psmt.setObject(7,e.getDesenvolvedor().getNome());
        } catch (SQLException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void composeUpdateStatement(PreparedStatement psmt, Jogo e) {
        //  set EDICAO = ?, CLASSIFICACAO = ?, GENERO = ?, SINOPSE = ?, PRECO = ?, NOMEDESENVOLVEDOR = ? where NOME = ?"
        try{
            psmt.setObject(1,e.getEdicao());                 
            psmt.setObject(2,e.getClassificacao());      
            psmt.setObject(3,e.getGenero());      
            psmt.setObject(4,e.getSinopse());
            psmt.setObject(5,e.getPreco());
            psmt.setObject(6,e.getDesenvolvedor().getNome());
            psmt.setObject(7,e.getNome());            
        } catch (SQLException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    @Override
//    public List<Jogo> extractObjects(ResultSet resultSet) {
//        Jogo jogo = null;
//        ArrayList<Legenda> legendas = new ArrayList<>();        
//        ArrayList<Linguagem> linguagens = new ArrayList<>();
//        try{
//            jogo = new Jogo();
//        }
//        return null;
//    }
//
//    @Override
//    public Jogo extractObject(ResultSet resultSet) {
//
//        try {
//
//            pedido.setId(resultSet.getLong("id"));
//            funcionario = new FuncionarioDao().findById(resultSet.getLong("funcionario_id"));
//            pedido.setFuncionario(funcionario);
//            cliente = new ClienteDao().findById(resultSet.getLong("cliente_id"));            
//            pedido.setCliente(cliente); 
//            
//            itens = new ItemDao().findByPedidoId(pedido.getId());
//            pedido.setValorTotal(resultSet.getBigDecimal("valorTotal"));
//            pedido.setItens(itens);
//            pedido.setDelivery(resultSet.getBoolean("delivery"));
//            pedido.setExcluido(resultSet.getBoolean("excluido"));
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return pedido;
//    }    

    @Override
    public Long saveOrUpdate(Jogo e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Jogo findById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Jogo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveToTrash(Jogo e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Jogo extractObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Jogo> extractObjects(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
