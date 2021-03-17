/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Stadium {
    private int Id_Stadium;
    private String stadiumName, stadiumArea, stadiumAddress;
    private int stadiumPrice;

    public Stadium() {
    }

    public Stadium(int Id_Stadium, String stadiumName, String stadiumArea, String stadiumAddress, int stadiumPrice) {
        this.Id_Stadium = Id_Stadium;
        this.stadiumName = stadiumName;
        this.stadiumArea = stadiumArea;
        this.stadiumAddress = stadiumAddress;
        this.stadiumPrice = stadiumPrice;
    }

    public int getId_Stadium() {
        return Id_Stadium;
    }

    public void setId_Stadium(int Id_Stadium) {
        this.Id_Stadium = Id_Stadium;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getStadiumArea() {
        return stadiumArea;
    }

    public void setStadiumArea(String stadiumArea) {
        this.stadiumArea = stadiumArea;
    }

    public String getStadiumAddress() {
        return stadiumAddress;
    }

    public void setStadiumAddress(String stadiumAddress) {
        this.stadiumAddress = stadiumAddress;
    }

    public int getStadiumPrice() {
        return stadiumPrice;
    }

    public void setStadiumPrice(int stadiumPrice) {
        this.stadiumPrice = stadiumPrice;
    }
    
}
