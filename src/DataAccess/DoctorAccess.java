/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import model.Doctor;
import view.Validation;

/**
 *
 * @author ASUS
 */
public class DoctorAccess {

    private static DoctorAccess instance = null;
    Validation vl = new Validation();
    Scanner sc = new Scanner(System.in);

    public static DoctorAccess Intance() {
        if (instance == null) {
            synchronized (Doctor.class) {
                if (instance == null) {
                    instance = new DoctorAccess();
                }
            }
        }
        return instance;
    }

    public void addNewDoctor(HashMap<String, Doctor> hashDoctorList) {

        String id = vl.checkDoctorCodeAdd("Input id code doctor:", hashDoctorList);
        //Nhap id của Doctor. Lớp Validation (vl) có phương thức checkDoctorCodeAdd được dùng để kiểm tra xem liệu đã có ID nào đã trùng lặp chưa
        String name = vl.inputString("Input name of doctor:");
        //Nhập tên của Doctor
        String spec = vl.inputString("Input the speccialization of doctor:");
        // Nhập speccicalization.
        int avai = vl.checkInt("Input the availability of the doctor:", 1, 100);
        //Nhap availability của Doctor. Lớp Validation (vl) có phương thức checkInt được dùng để kiểm tra xem liệu đã có Avai này được nhập vào có thực sự là 1 số INT hay không
        Doctor d = new Doctor(id, name, spec, avai);
        //Khởi tạo 1 đối tượng mới Doctor .
        hashDoctorList.put(id, d);
        //Add doctor mới vào HashMap với key là ID ( key này vì nó là duy nhất nên nó có thể xác định được value ) và cặp value sẽ gán là đối tượng Doctor
        displayAll(hashDoctorList);

    }

    public void updateDoctor(HashMap<String, Doctor> hashDoctorList) {
        String id = vl.inputString("Input id code doctor you want to update:");
//        Nhập id của doctor để tìm kiếm doctor cần update
        vl.checkIDis(hashDoctorList, id);
        Doctor d = vl.getDoctorByCode(hashDoctorList, id);
        String newID = vl.checkNew(hashDoctorList);
        if (newID.isEmpty()) {
            newID = d.getCode();
        }
        System.out.println("Input new name of doctor (Enter to skip) :");
        String newName = sc.nextLine();
        if (newName.isEmpty()) {
            newName = d.getName();
        }
        System.out.println("Input new specialization of doctor (Enter to skip) :");
        String newSpec = sc.nextLine();
        if (newSpec.isEmpty()) {
            newSpec = d.getSpecialization();
        }
        System.out.println("Input new availability of doctor (Enter to skip) :");
        String subAvai = sc.nextLine();
        int newAvai = 0;
        if (subAvai.isEmpty()) {
            newAvai = d.getAvai();
        } else {
            newAvai = Integer.parseInt(subAvai);
        }
        d.setCode(newID);
        d.setName(newName);
        d.setSpecialization(newSpec);
        d.setAvai(newAvai);
//        System.out.println(d.getCode() + "       " + d.getName() + "      " + d.getSpecialization() + "                " + d.getAvai());
        System.out.printf("%-5s|%-7s|%-15s|%-5d\n", d.getCode(), d.getName(), d.getSpecialization(), d.getAvai());

    }

    public void deleteDoctor(HashMap<String, Doctor> hashDoctorList) {
        String id = vl.inputString("Input id code doctor you want to delete:");
        vl.checkIDis(hashDoctorList, id);
        Doctor d = vl.getDoctorByCode(hashDoctorList, id);
        hashDoctorList.remove(id);
        System.out.println("Remove Successed");
        displayAll(hashDoctorList);
    }

    public void displayAll(HashMap<String, Doctor> list) {
        System.out.println("------------------RESULT--------------");
        System.out.println("Code      " + "Name      " + "Specialization                " + "Availabity   ");

        for (Map.Entry<String, Doctor> entry : list.entrySet()) {
            System.out.printf("%-5s|%-7s|%-25s|%-5d\n", "DOC " + entry.getValue().getCode(), entry.getValue().getName(), entry.getValue().getSpecialization(), entry.getValue().getAvai());

//            System.out.println(entry.getKey() + "       " + entry.getValue().getName() + "      " + entry.getValue().getSpecialization() + "                " + entry.getValue().getAvai());
        }
    }

    public HashMap<String, Doctor> search(Predicate<Doctor> d, HashMap<String, Doctor> hashDoctorList) {
        HashMap<String, Doctor> subList = new HashMap<>();
        Set keySet = hashDoctorList.keySet();
        for (Object key : keySet) {
            Doctor d1 = hashDoctorList.get(key);
            if (d.test(d1)) {
                subList.put(d1.getCode(), d1);
            }
        }
        return subList;
    }

    public void checkEmpty(HashMap<String, Doctor> list) {
        if (list.isEmpty()) {
            System.out.println("=============================================");
            System.out.println("");
            System.out.println("No exist data.");
            System.out.println("");
            System.out.println("=============================================");

        } else {
            displayAll(list);
        }

    }

}
