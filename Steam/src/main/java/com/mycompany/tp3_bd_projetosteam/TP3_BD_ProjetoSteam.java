/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp3_bd_projetosteam;

import Empresa.Desenvolvedor;
import Empresa.Distribuidor;
import Jogo.Jogo;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yodem
 */
public class TP3_BD_ProjetoSteam {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//200.131.242.43:1521/IFNMGPDB";
        String username = "yjs25681";
        String password = "yjsn";
        
        Desenvolvedor dev = new Desenvolvedor();
        dev.setNome("Ubisoft");
        System.out.println("> "+dev.toString());
        
        Jogo jogo = new Jogo( "FarCry", "Golden", "18", "Primeira pessoal", "bla bla bla", new BigDecimal(BigInteger.valueOf(250)), dev);
        
        System.out.println("> "+jogo.toString());
        
//        try {
//            // Registrar o driver JDBC
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            // Estabelecer conexão
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            // Criar um statement
//            Statement statement = connection.createStatement();
//
//            // Executar a consulta SQL
//            String sql = "SELECT * FROM categoria";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            // Processar os resultados da consulta
//            while (resultSet.next()) {
//                // Ler os valores das colunas
//                int id = resultSet.getInt("codigo");
//                String nome = resultSet.getString("nome");
//                int Cod_categoria = resultSet.getInt("Categoriaprincipal");
//
//
//                // Fazer algo com os valores lidos
//                System.out.println("Codigo: " + id + ", Nome: " + nome + ", Categoria Principal: "+ Cod_categoria);
//            }
//
//            // Fechar o ResultSet, o Statement e a conexão
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver Oracle JDBC não encontrado.");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Erro ao conectar ao banco de dados.");
//            e.printStackTrace();
//        }
    }
}
    

