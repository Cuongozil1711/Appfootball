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
public class Friend {
    private String Id_Frend;
    private String ten;
    private int namsinh,soao;
    private int Id_Team;

    public Friend(String Id_Frend, String ten, int namsinh, int soao, int Id_Team) {
        this.Id_Frend = Id_Frend;
        this.ten = ten;
        this.namsinh = namsinh;
        this.soao = soao;
        this.Id_Team = Id_Team;
    }

    public Friend() {
    }

    public String getId_Frend() {
        return Id_Frend;
    }

    public void setId_Frend(String Id_Frend) {
        this.Id_Frend = Id_Frend;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public int getSoao() {
        return soao;
    }

    public void setSoao(int soao) {
        this.soao = soao;
    }

    public int getId_Team() {
        return Id_Team;
    }

    public void setId_Team(int Id_Team) {
        this.Id_Team = Id_Team;
    }

    
    
    
}
