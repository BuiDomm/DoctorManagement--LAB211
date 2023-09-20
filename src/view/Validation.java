/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import model.Doctor;


public class Validation {

    // declear Scanner class to input field 
    private static final Scanner sc = new Scanner(System.in);

    public String inputString(String msg) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {
            // allow user input a string 
            System.out.println(msg);
            String input_raw = sc.nextLine();

            // input == null or do dai = 0 => rong 
            if (input_raw == null || input_raw.length() == 0) {
                // error
                System.err.println("Must input a string not empty !!!");
                System.out.println("Please enter again!");
                continue;
            }
            return input_raw;
        }
    }

    // kiem tra so nguyen nam tu min den max 
    public int checkInt(String msg, int min, int max) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {

            // allow user input a string 
            String input_raw = inputString(msg);

            try {
                // loi nhap sai dinh dang so 
                int input = Integer.parseInt(input_raw);
                // loi nhap ngoai range cho phep
                if (input < min || input > max) {
                    System.err.println("Must input a number from " + min + "to " + max);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Must enter a number");
                continue;
            }

        }
    }
    
    
    public int checkINT(String input) { 
        while(true){ 
            if(Integer.parseInt(input)>0) { 
                return Integer.parseInt(input);
            }
            else
            continue;
        }
    }

    // kiem tra id bi trung hay khong 
    public String checkDoctorCodeAdd(String msg, HashMap<String, Doctor> list) {
        while (true) {
            // khai bao bien co de kiem tra xem co trung hay khong, neu trung thi flag = 1 
//        int flag = 0;
            // NHAP ID DE CHECK 
            String id = inputString(msg);
            Doctor find_doctor = getDoctorByCode(list, id);
            if (find_doctor != null) {
                System.err.println("Doctor code is existed in DB!!Please enter again");
                continue;
            }
            return id;
        }

    }
    
    public String checkNew( HashMap<String, Doctor> list) { 
        while (true) {
            // khai bao bien co de kiem tra xem co trung hay khong, neu trung thi flag = 1 
//        int flag = 0;
            // NHAP ID DE CHECK 
            System.out.println("Input new id of doctor (Enter to skip)");
            String id = sc.nextLine();
            Doctor find_doctor = getDoctorByCode(list, id);
            if (find_doctor != null) {
                System.err.println("Doctor code is existed in DB!!Please enter again");
                continue;
            }
            return id;
        }
    }

    public Doctor getDoctorByCode(HashMap<String, Doctor> list, String code) {
        Set keySet = list.keySet();
        for (Object key : keySet) {
            Doctor d = list.get(key);
            if (d.getCode().equals(code)) {
                return d;
            }
        }
        return null;
    }

    public String checkDoctorCodeUpdateOrDelete(String msg, HashMap<String, Doctor> list) {
        while (true) {
            // khai bao bien co de kiem tra xem co trung hay khong, neu trung thi flag = 1 
            int flag = 0;
            // NHAP ID DE CHECK 
            String id = inputString(msg);
            Doctor find_doctor = getDoctorByCode(list, id);
            if (find_doctor == null) {
                System.err.println("Doctor code must be in DB!!Please enter again");
                continue;
            }
            return id;
        }
    }

}

