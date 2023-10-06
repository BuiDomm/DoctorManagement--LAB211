/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import java.util.HashMap;
import java.util.function.Predicate;
import model.Doctor;

/**
 *
 * @author ASUS
 */
public interface InterfaceDoctorApp {

    public void updateDoctor(HashMap<String, Doctor> hashDoctorList);

    public void addNewDoctor(HashMap<String, Doctor> hashDoctorList);

    public void deleteDoctor(HashMap<String, Doctor> hashDoctorList);

    public void displayAll(HashMap<String, Doctor> list);

    public HashMap<String, Doctor> search(Predicate<Doctor> d, HashMap<String, Doctor> hashDoctorList);

    public void checkEmpty(HashMap<String, Doctor> list);
    
    
}
