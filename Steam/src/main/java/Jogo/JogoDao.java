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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe JogoDao
 * @author yodem
 */
public class JogoDao implements IDao{
    public static final String TABLE = "pedido";

    @Override
    public String getSaveStatement() {
        return "insert into "+ TABLE +" (funcionario_id, cliente_id, valorTotal, delivery) values (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update "+ TABLE + " set funcionario_id = ?, cliente_id = ?, valorTotal = ?, delivery = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Pedido e) {
        try{
            pstmt.setObject(1,e.getFuncionario().getId());
            pstmt.setObject(2,e.getCliente().getId());                 
            pstmt.setObject(3,e.getValorTotal());      
            pstmt.setObject(4,e.getDelivery());      
    
            if(e.getId() != null) {
                pstmt.setObject(5, e.getId());
            }

        } catch(SQLException ex){
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatement() {
        return "select * from "+ TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select * from "+ TABLE;
    }

    @Override
    public String getMoveToTrashStatement() {
        return "update "+ TABLE + " set excluido = 1 where id = ?";
    }


    @Override
    public Jogo extractObject(ResultSet resultSet) {
        Jogo jogo = null;
        ArrayList<Legenda> legendas = new ArrayList<>();        
        ArrayList<Linguagem> linguagens = new ArrayList<>();

        try {
            jogo = new Jogo();
            pedido.setId(resultSet.getLong("id"));
            funcionario = new FuncionarioDao().findById(resultSet.getLong("funcionario_id"));
            pedido.setFuncionario(funcionario);
            cliente = new ClienteDao().findById(resultSet.getLong("cliente_id"));            
            pedido.setCliente(cliente); 
            
            itens = new ItemDao().findByPedidoId(pedido.getId());
            pedido.setValorTotal(resultSet.getBigDecimal("valorTotal"));
            pedido.setItens(itens);
            pedido.setDelivery(resultSet.getBoolean("delivery"));
            pedido.setExcluido(resultSet.getBoolean("excluido"));

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedido;
    }
    
    
}
