/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Minh
 */
public class Student {

    private int IdS;
    private String NameS, DateOfBirth;
    private Boolean Sex;
    private int IDPlace;
    private float M, P, C;

    public int getIDPlace() {
        return IDPlace;
    }

    public void setIDPlace(int IDPlace) {
        this.IDPlace = IDPlace;
    }

    public void setSex(Boolean Sex) {
        this.Sex = Sex;
    }

    public Boolean getSex() {
        return Sex;
    }

    public int getIdS() {
        return IdS;
    }

    public String getNameS() {
        return NameS;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public float getM() {
        return M;
    }

    public float getP() {
        return P;
    }

    public float getC() {
        return C;
    }

    public void setIdS(int IdS) {
        this.IdS = IdS;
    }

    public void setNameS(String NameS) {
        this.NameS = NameS;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setM(float M) {
        this.M = M;
    }

    public void setP(float P) {
        this.P = P;
    }

    public void setC(float C) {
        this.C = C;
    }
}
