/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Doctor {
    private String code; 
    private String name ; 
    private String specialization;
    private int avai;

    public Doctor() {
    }

    public Doctor(String code, String name, String specialization, int avai) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.avai = avai;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvai() {
        return avai;
    }

    public void setAvai(int avai) {
        this.avai = avai;
    }

    @Override
    public String toString() {
        return "Doctor{" + "code=" + code + ", name=" + name + ", specialization=" + specialization + ", avai=" + avai + '}';
    }
    
}
