/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.DoctorAccess;
import java.util.HashMap;
import java.util.function.Predicate;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public class DoctorRepository implements InterfaceDoctorApp {

    @Override
    public void updateDoctor(HashMap<String, Doctor> hashDoctorList) {
        DoctorAccess.Intance().updateDoctor(hashDoctorList);
    }

    @Override
    public void addNewDoctor(HashMap<String, Doctor> hashDoctorList) {
        DoctorAccess.Intance().addNewDoctor(hashDoctorList);
    }

    @Override
    public void deleteDoctor(HashMap<String, Doctor> hashDoctorList) {
        DoctorAccess.Intance().deleteDoctor(hashDoctorList);
    }

    @Override
    public void displayAll(HashMap<String, Doctor> list) {
        DoctorAccess.Intance().displayAll(list);
    }

    @Override
    public HashMap<String, Doctor> search(Predicate<Doctor> d, HashMap<String, Doctor> hashDoctorList) {
        HashMap<String, Doctor> sub = DoctorAccess.Intance().search(d, hashDoctorList);
        return sub;
    }

    @Override
    public void checkEmpty(HashMap<String, Doctor> sub) {
        if (sub.isEmpty()) {
            System.out.println("================================");
            System.out.println("");
            System.out.println("No Data");
            System.out.println("");
            System.out.println("================================");

        } else {
            displayAll(sub);
        }
    }

}
