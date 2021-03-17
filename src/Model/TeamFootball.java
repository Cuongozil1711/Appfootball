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
public class TeamFootball {
    private int Id_Team;
    private String Name_Team,Level,Color_Shirt,Image_Team;
    private int Year_Start;
    private String tendangnhap;
    private String password;
    
    public TeamFootball() {
       
    }

    public TeamFootball(int Id_Team, String Name_Team, String Level, String Color_Shirt, String Image_Team, int Year_Start, String tendangnhap, String password) {
        this.Id_Team = Id_Team;
        this.Name_Team = Name_Team;
        this.Level = Level;
        this.Color_Shirt = Color_Shirt;
        this.Image_Team = Image_Team;
        this.Year_Start = Year_Start;
        this.tendangnhap = tendangnhap;
        this.password = password;
    }

    public int getId_Team() {
        return Id_Team;
    }

    public void setId_Team(int Id_Team) {
        this.Id_Team = Id_Team;
    }

    public String getName_Team() {
        return Name_Team;
    }

    public void setName_Team(String Name_Team) {
        this.Name_Team = Name_Team;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public String getColor_Shirt() {
        return Color_Shirt;
    }

    public void setColor_Shirt(String Color_Shirt) {
        this.Color_Shirt = Color_Shirt;
    }

    public String getImage_Team() {
        return Image_Team;
    }

    public void setImage_Team(String Image_Team) {
        this.Image_Team = Image_Team;
    }

    public int getYear_Start() {
        return Year_Start;
    }

    public void setYear_Start(int Year_Start) {
        this.Year_Start = Year_Start;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    
    
    
}
