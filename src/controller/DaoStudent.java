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
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author Minh
 */
public class DaoStudent {

    private Connection conn;

    public DaoStudent(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ProjectData;"
                    + "username=sa;password=123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO Student(ID,Name,IDPlace,DateOfBirth,Sex,Math,Physical,Chemistry)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getIdS());
            ps.setString(2, s.getNameS());
            ps.setInt(3, s.getIDPlace());
            ps.setString(4, s.getDateOfBirth());
            ps.setBoolean(5, s.getSex());
            ps.setString(6, String.valueOf(s.getM()));
            ps.setString(7, String.valueOf(s.getP()));
            ps.setString(8, String.valueOf(s.getC()));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
        
    }

    public boolean deleteStudent(Student s) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Student WHERE ID = " + s.getIdS());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(Student s){

        String sql
                = "update Student "
                + "set Name = ? , "
                + "IDPlace = ?, "
                + "DateOfBirth = ? ,"
                + "Sex = ?, "
                + "Math = ?, "
                + "Physical = ? ,"
                + "Chemistry = ? "
                + "where ID = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.getNameS());
            ps.setInt(2, s.getIDPlace());
            ps.setString(3, s.getDateOfBirth());
            ps.setBoolean(4, s.getSex());
            ps.setString(5, String.valueOf(s.getM()));
            ps.setString(6, String.valueOf(s.getP()));
            ps.setString(7, String.valueOf(s.getC()));
            ps.setInt(8, s.getIdS());

            return ps.executeUpdate() > 0;
        }catch (Exception e) {
            return false;
        }
      
    }

    public ArrayList<Student> SearchID(int ID) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Student WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setIdS(rs.getInt("ID"));
                s.setNameS(rs.getString("Name"));
                s.setIDPlace(rs.getInt("IDPlace"));
                s.setDateOfBirth(rs.getString("DateOfBirth"));
                s.setSex(rs.getBoolean("Sex"));
                s.setM(rs.getFloat("Math"));
                s.setP(rs.getFloat("Physical"));
                s.setC(rs.getFloat("Chemistry"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Student> getListStudent() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Student ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setIdS(rs.getInt("ID"));
                s.setNameS(rs.getString("Name"));
                s.setIDPlace(rs.getInt("IDPlace"));
                s.setDateOfBirth(rs.getString("DateOfBirth"));
                s.setSex(rs.getBoolean("Sex"));
                s.setM(rs.getFloat("Math"));
                s.setP(rs.getFloat("Physical"));
                s.setC(rs.getFloat("Chemistry"));

                list.add(s);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Student> SearchBirthPlace(int IDPlace) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Student WHERE IDPlace = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, IDPlace);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setIdS(rs.getInt("ID"));
                s.setNameS(rs.getString("Name"));
                s.setIDPlace(rs.getInt("IDPlace"));
                s.setDateOfBirth(rs.getString("DateOfBirth"));
                s.setSex(rs.getBoolean("Sex"));
                s.setM(rs.getFloat("Math"));
                s.setP(rs.getFloat("Physical"));
                s.setC(rs.getFloat("Chemistry"));
                list.add(s);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        new DaoStudent();
    }
}
