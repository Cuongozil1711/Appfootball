/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.DatabaseHelper;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TeamDao {

    Connection conn = null;
    PreparedStatement sttm = null;
    private final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DbNguoidung;user=sa;password=123456";

    public int add(TeamFootball st) {
        try {
            String sSQL = "INSERT TeamFootball1 "
                    + "VALUES(?,?,?,?,?,?,?,?)";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, st.getId_Team());
            sttm.setString(2, st.getName_Team());
            sttm.setString(3, st.getLevel());
            sttm.setString(4, st.getColor_Shirt());
            sttm.setString(5, st.getImage_Team());
            sttm.setInt(6, st.getYear_Start());
            sttm.setString(7, st.getTendangnhap());
            sttm.setString(8, st.getPassword());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
        return -1;
    }
    
    public int AddDsTeam(int idteam,int idsan,int gio,String tinhtrang,String thanhtoan){
        try {
            String sSQL = "INSERT DsTeam "
                    + "VALUES(?,?,?,?,?)";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, idteam);
            sttm.setInt(2, idsan);
            sttm.setInt(3, gio);
            sttm.setString(4, tinhtrang);
            sttm.setString(5, thanhtoan);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
            }
        } catch (Exception e) {
             System.out.println("Error 5:" + e.toString());
        }
        return -1;
    }
    public ArrayList<TeamFootball> SoSanhTaiKhoan(String tk, String pass) {
        ArrayList<TeamFootball> st = new ArrayList<>();

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM TeamFootball1 t WHERE 1 = 1";
            List<String> param = new ArrayList<>();
            if (tk != null && !tk.equals("")) {
                SQL += " AND t.tendangnhap = '" + tk + "'";
            }
            if (pass != null && !pass.equals("")) {
                SQL += " AND t.password = '" + pass + "'";
            }
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                TeamFootball k = new TeamFootball();
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

        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public ArrayList<Stadium> readData() {
        ArrayList<Stadium> st = new ArrayList<>();

        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DbNguoidung;user=sa;password=123456";

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT  * FROM STADIUM1";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            int d = 0;
//            while (rs.next()) {
//                d++;
//            }
//            if(d>0){
            while (rs.next()) {
                Stadium k = new Stadium();
                k.setId_Stadium(Integer.valueOf(rs.getString(1)));
                k.setStadiumName(rs.getString(2));
                k.setStadiumArea(rs.getString(3));
                k.setStadiumAddress(rs.getString(4));
                k.setStadiumPrice(Integer.valueOf(rs.getString(5)));
                st.add(k);
            }
//            }
//            else return null;
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public ArrayList<DsTeam> readDs(String a) {
        ArrayList<DsTeam> ds = new ArrayList<>();
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DbNguoidung;user=sa;password=123456";

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT  k.gio, t.Name_Team,k.tinhtrang, k.thanhtoan,  s.stadiumPrice FROM DsTeam k, STADIUM1 s, TeamFootball1 t WHERE 1=1 AND k.Id_Team = t.Id_Team AND k.Id_Stadium = s.Id_Stadium";
            if (a.length() != 0) {
                SQL += " AND s.stadiumName = N'" + a + "'";
            }
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            int d = 0;
//            while (rs.next()) {
//                d++;
//            }
//            if(d>0){
            while (rs.next()) {
                DsTeam s = new DsTeam();
                s.setHour(Integer.valueOf(rs.getString(1)));
                s.setName_team(rs.getString(2));
                s.setStatus(rs.getString(3));
                s.setPayment(rs.getString(4));
                s.setPrice(Integer.valueOf(rs.getString(5)));
                ds.add(s);
            }
//            }
//            else return null;
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
        //return null;
    }
    public int CleanTeam(String tendoi,int nam,String mauao,String trinhdo, TeamFootball k){
        try {
            String sSQL = "UPDATE dbo.TeamFootball1 SET Name_Team = N'"+tendoi+"',Year_Start = "+nam+",Color_Shirt = N'"+mauao+"',Level = N'"+trinhdo+"' WHERE Id_Team = "+ k.getId_Team();
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
            }
        } catch (Exception e) {
             System.out.println("Error 5:" + e.toString());
        }
        return -1;
    }
    public ArrayList<Friend> readThanhVien(TeamFootball v) {
        System.out.println(v.toString());
        ArrayList<Friend> st = new ArrayList<>();

        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DbNguoidung;user=sa;password=123456";

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT  * FROM Friend WHERE Id_Team ="+v.getId_Team()+"" ;
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            int d = 0;
//            while (rs.next()) {
//                d++;
//            }
//            if(d>0){
            while (rs.next()) {
                Friend k = new Friend();
                k.setId_Frend(rs.getString(1));
                k.setTen(rs.getString(2));
                k.setNamsinh(Integer.valueOf(rs.getString(3)));
                k.setSoao(Integer.valueOf(rs.getString(4)));
                k.setId_Team(Integer.valueOf(rs.getString(5)));
                System.out.println(k.toString());
                st.add(k);
            }
 
//            }
//            else return null;
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(st);
        return st;
    }
    public int add(Friend st) {
        try {
            String sSQL = "INSERT Friend "
                    + "VALUES(?,?,?,?,?)";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, st.getId_Frend());
            sttm.setString(2, st.getTen());
            sttm.setInt(3, st.getNamsinh());
            sttm.setInt(4, st.getSoao());
            sttm.setInt(5, st.getId_Team());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
            }
        } catch (Exception e) {
            System.out.println("Error: 1" + e.toString());
        }
        return -1;
    }
    public boolean xoaten(String id){
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DbNguoidung;user=sa;password=123456";
        
        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "DELETE   FROM [Friend] WHERE Id_Friend = N'"+id+"'" ;
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(SQL);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Xóa thành công");
                return true;
            }
        }
        catch (SQLException e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
        return false;
    }
    public int UpdateTeam(Friend v){
        try {
            String sSQL = "UPDATE dbo.Friend SET Id_Friend = N'"+v.getId_Frend()+"',Ten = N'"+v.getTen()+"',namsinh = "+v.getSoao()+",Id_Team = "+v.getId_Team()+"WHERE Id_Friend = "+ v.getId_Frend();
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
            }
        } catch (Exception e) {
             System.out.println("Error 5:" + e.toString());
        }
        return -1;
    }
    public static void main(String[] args) {
        TeamDao t = new TeamDao();
        System.out.println(t.readData().size());
    }
}
