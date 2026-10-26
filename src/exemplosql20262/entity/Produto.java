/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplosql20262.entity;

import exemplosql20262.dao.GenericDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lecol
 */
public class Produto implements IProduto {
    
    public Produto() {
        this.id = 0;
        this.nome = "";
        this.valor = 0.0f;
    }
    
    private int id;
    private String nome;
    private float valor;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public void insertProduto(Produto p) throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO produto VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.setString(2, p.getNome());
        ps.setFloat(3, p.getValor());
        ps.execute();
        ps.close();
        conn.close();
    }

    @Override
    public void updateProduto(Produto p) throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();
        String sql = "UPDATE produto SET nome = ?, valor = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setFloat(2, p.getValor());
        ps.setInt(3, p.getId());
        ps.execute();
        ps.close();
        conn.close();
    }

    @Override
    public void deleteProduto(Produto p) throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();
        String sql = "DELETE produto WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.execute();
        ps.close();
        conn.close();
    }

    @Override
    public Produto findOneProduto(Produto p) throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();
        String sql = "SELECT id, nome, valor FROM produto WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getFloat("valor"));
        }
        rs.close();
        ps.close();
        conn.close();
        return p;
    }

    @Override
    public List<Produto> findAllProduto() throws ClassNotFoundException, SQLException {
        List<Produto> lista = new ArrayList<>();
        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();
        String sql = "SELECT id, nome, valor FROM produto";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Produto p = new Produto();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getFloat("valor"));
            lista.add(p);
        }
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }
}
