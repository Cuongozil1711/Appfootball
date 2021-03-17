/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.DatabaseHelper;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class TestDb {
    public static void main(String[] args) {
        Connection conn = DatabaseHelper.getDBConnect();
        if(conn!=null){
            System.out.println("connect thanh cong");
        }
        else{
            System.out.println("connect that bại");
        }
    }
}
