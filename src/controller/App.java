/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.DoctorRepository;
import java.util.HashMap;
import model.Doctor;
import view.Menu;
import view.Validation;

/**
 *
 * @author ASUS
 */
public class App extends Menu<String> {

    static String[] choices = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor"};
    Validation vl = new Validation();
    DoctorRepository doc = new DoctorRepository();
    HashMap<String, Doctor> list = new HashMap<>();

    public App() {
        super("====================DOCTOR MANAGEMENT===================", choices, "Exit");
    }

    @Override
    public void execute(int n) {
//        md.autoAddDoctor();
        switch (n) {
            case 1: {
                doc.addNewDoctor(list);
                break;
            }
            case 2: {
                doc.updateDoctor(list);
                break;
            }

       
            case 3: {
                doc.deleteDoctor(list);
                break;
            }
                 case 4: {
                String[] mc = {"Search by ID", "Search by name", "Search by specialization", "Search Availability"};
                Menu m = new Menu("-------------Search Doctor------------", mc, "Exit") {
                    @Override
                    public void execute(int n) {
                        switch (n) {
                            case 1: {
                                String id = vl.inputString("Input ID Doctor you want to search:");
                                HashMap<String, Doctor> sub = doc.search(d -> d.getCode().equals(id),list);
                                doc.checkEmpty(sub);

                                break;
                            }
                            case 2: {
                                String name = vl.inputString("Input name Doctor you want to search:");
                                HashMap<String, Doctor> sub = doc.search(d -> d.getName().contains(name),list);
                                doc.checkEmpty(sub);
                                break;
                            }
                            case 3: {
                                String spec = vl.inputString("Input specialization doctor you want to search:");
                                HashMap<String, Doctor> sub = doc.search(d -> d.getSpecialization().equalsIgnoreCase(spec),list);
                                doc.checkEmpty(sub);

                                break;
                            }
                            case 4: {
                                int avai = vl.checkInt("Input availability doctor you want to search: ", 1, 40);
                                HashMap<String, Doctor> sub = doc.search(d -> d.getAvai() == avai,list);
                                doc.checkEmpty(sub);
                                break;
                            }
                        }
                    }

                };
                m.run();
                break;
            }
        }

    }

}
