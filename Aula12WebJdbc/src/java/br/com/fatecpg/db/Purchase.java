package br.com.fatecpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Purchase {
    private int id, idproduto, quantidade;
    public static ArrayList<Purchase> getList(int id) throws Exception {
        ArrayList<Purchase> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String password = "app";                
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT CUSTOMER_ID, PRODUCT_ID, QUANTITY FROM APP.PURCHASE_ORDER WHERE CUSTOMER_ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1,id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Purchase p = new Purchase(
                    rs.getInt("CUSTOMER_ID"),
                    rs.getInt("PRODUCT_ID"),
                    rs.getInt("QUANTITY")
            );
            list.add(p);
        }
        rs.close();stmt.close();con.close();
        return list;  
    }

    public Purchase(int id, int idproduto, int quantidade){
        this.id = id;
        this.idproduto = idproduto;
        this.quantidade = quantidade;
    }
            
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
