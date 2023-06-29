/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author yodemis
 */

public interface IDao<T> {
    
    //save
    public String getSaveStatement();
    public String getUpdateStatement();
    public void composeSaveStatement(PreparedStatement psmt, T e);
    public void composeUpdateStatement(PreparedStatement psmt, T e);
    public Long saveOrUpdate(T e);
    
    //Get find by Id
    public String getFindByIdStatement();
    public T findById();
    
    //Get find all
    public String getFindAllStatement();
    public List<T> findAll();
    
    //Trash
    public String getMoveToTrashStatement();
    public void moveToTrash(T e);
    
    //Assembly objects
    public T extractObject(ResultSet resultSet);
    public List<T> extractObjects(ResultSet resultSet);
}
