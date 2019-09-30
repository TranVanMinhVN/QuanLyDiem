/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Place;
import model.Student;

/**
 *
 * @author Minh
 */
public class DaoPlace {
    private Connection conn;
    
    public DaoPlace(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ProjectData;"
                    + "username=sa;password=123");        
        } catch(Exception e){
            e.printStackTrace();
        }
    }
        public ArrayList<Place> getListPlace(){
        ArrayList<Place> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Place ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Place s= new Place();
                
                s.setIdPL(rs.getInt("IDPlace"));
                s.setNamePL(rs.getString("NamePlace"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        
    public boolean add(Place s){
        String sql = "INSERT INTO Place(NamePlace)"
                            +"VALUES(?)";
                try{
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, s.getNamePL());
                return ps.executeUpdate() > 0;
                   
            }catch (Exception e){
            return false;
        }
        
    }
     public static void main(String[] args) {
        new DaoPlace();
    }
}
