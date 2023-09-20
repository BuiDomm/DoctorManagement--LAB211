/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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

    public App() {
        super("====================DOCTOR MANAGEMENT===================", choices, "Exit");
    }
    ManageDoctor md = new ManageDoctor();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                md.addNewDoctor();
                break;
            }
            case 2: {
                md.updateDoctor();
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
                                HashMap<String, Doctor> sub = md.search(d -> d.getCode().equals(id));
                                if (sub.isEmpty()) {
                                    System.out.println("================================");
                                    System.out.println("");
                                    System.out.println("No Data");
                                    System.out.println("");
                                    System.out.println("================================");

                                } else {
                                    md.displayAll(sub);

                                }
                                break;
                            }
                            case 2: {
                                String name = vl.inputString("Input name Doctor you want to search:");
                                HashMap<String, Doctor> sub = md.search(d -> d.getName().contains(name));
                                if (sub.isEmpty()) {
                                    System.out.println("================================");
                                    System.out.println("");
                                    System.out.println("No Data");
                                    System.out.println("");
                                    System.out.println("=================================");

                                } else {
                                    md.displayAll(sub);

                                }
                                break;
                            }
                            case 3: {
                                String spec = vl.inputString("Input specialization doctor you want to search:");
                                HashMap<String, Doctor> sub = md.search(d -> d.getSpecialization().equalsIgnoreCase(spec));
                                if (sub.isEmpty()) {
                                    System.out.println("================================");
                                    System.out.println("");
                                    System.out.println("No Data");
                                    System.out.println("");
                                    System.out.println("=================================");

                                } else {
                                    md.displayAll(sub);

                                }
                                break;
                            }
                            case 4: {
                                int avai = vl.checkInt("Input availability doctor you want to search: ", 1, 40);
                                HashMap<String, Doctor> sub = md.search(d -> d.getAvai() == avai);
                                if (sub.isEmpty()) {
                                    System.out.println("================================");
                                    System.out.println("");
                                    System.out.println("No Data");
                                    System.out.println("");
                                    System.out.println("================================");

                                } else {
                                    md.displayAll(sub);

                                }
                                break;
                            }
                        }
                    }

                };
                m.run();
                break;
            }
            case 3: {
                md.deleteDoctor();
                break;
            }

        }

    }

}
