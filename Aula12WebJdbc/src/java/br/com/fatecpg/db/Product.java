/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Product {
    
    private int id;
    private String codigo;
    private double preco;
    private String disp;
    private String desc;
    private int fabid;
    
    
    public static ArrayList<Product> getList(int id) throws Exception{
        ArrayList<Product> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String password = "app";                
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT PRODUCT_ID, PRODUCT_CODE, PURCHASE_COST, AVAILABLE, DESCRIPTION, MANUFACTURER_ID FROM APP.PRODUCT WHERE MANUFACTURER_ID = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1,id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Product p = new Product(
                    rs.getInt("PRODUCT_ID"),
                    rs.getString("PRODUCT_CODE"),
                    rs.getDouble("PURCHASE_COST"),
                    rs.getString("AVAILABLE"),
                    rs.getString("DESCRIPTION"),
                    rs.getInt("MANUFACTURER_ID")
            );
            list.add(p);
        }
        rs.close();stmt.close();con.close();
        return list;
    }

    public Product(int id, String codigo, double preco, String disp, String desc, int fabid) {
        this.id = id;
        this.codigo = codigo;
        this.preco = preco;
        this.disp = disp;
        this.desc = desc;
        this.fabid = fabid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getFabid() {
        return fabid;
    }

    public void setFabid(int fabid) {
        this.fabid = fabid;
    }
    
    
}
