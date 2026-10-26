/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package exemplosql20262.entity;

/**
 *
 * @author lecol
 */
import java.sql.SQLException;
import java.util.List;

public interface IProduto {
    
    public void insertProduto(Produto p) throws ClassNotFoundException, SQLException;
    public void updateProduto(Produto p) throws ClassNotFoundException, SQLException;
    public void deleteProduto(Produto p) throws ClassNotFoundException, SQLException;
    public Produto findOneProduto(Produto p) throws ClassNotFoundException, SQLException;
    public List<Produto> findAllProduto() throws ClassNotFoundException, SQLException;
    
}
