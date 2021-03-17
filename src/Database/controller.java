/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.ArrayList;
import Model.TeamFootball;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class controller{

   public ArrayList<TeamFootball> readData(){
        ArrayList<TeamFootball> st = new ArrayList<>();
                
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DbNguoidung;user=sa;password=";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM TeamFootball1";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            int d=0;
            while (rs.next()) {
                d++;
            }
            if(d>0){
                while(rs.next()){
                   TeamFootball k = null;
                   k.setId_Team(Integer.valueOf(rs.getString(1)));
                   k.setName_Team(rs.getString(2));
                   k.setLevel(rs.getString(3));
                   k.setColor_Shirt(rs.getString(4));
                   k.setImage_Team(rs.getString(5));
                   k.setYear_Start(Integer.valueOf(rs.getString(6)));
                   k.setTendangnhap(rs.getString(7));
                   k.setPassword(rs.getString(8));
                   st.add(k);
                }
            }
            else return null;
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }


    
}
