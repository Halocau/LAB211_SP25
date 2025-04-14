/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Manager {

    private static ArrayList<Employee> listEmployee = new ArrayList<>();

    public static ArrayList<Employee> SearchEmployeeByName(String input, ArrayList<Employee> listEmployee) {
        ArrayList<Employee> search = new ArrayList<>();
        String searchName = input.replaceAll("\\s+", "").toLowerCase();
        for (Employee emp : listEmployee) {
            String fullName = emp.getFirstName() + emp.getLastName();
            if (fullName.contains(searchName)) {
                search.add(emp);
            }
        }
        return search;
    }

    public void initData() {
        listEmployee.add(new Employee(
                "E001",
                "Nguyen",
                "Van A",
                "0123456789",
                "nguyenvana@example.com",
                "123 Le Loi, Ha Noi",
                new Date(90, 0, 1), // 01-01-1990
                "Nam",
                1,
                "Ha Noi Branch"
        ));

        listEmployee.add(new Employee(
                "E002",
                "Tran",
                "Thi B",
                "0987654321",
                "tranthib@example.com",
                "456 Tran Hung Dao, HCM",
                new Date(95, 4, 20), // 20-05-1995
                "Nữ",
                3,
                "HCM Branch"
        ));

        listEmployee.add(new Employee(
                "E003",
                "Le",
                "Van C",
                "0911223344",
                "levanc@example.com",
                "789 Nguyen Trai, Da Nang",
                new Date(92, 6, 15), // 15-07-1992
                "Nam",
                2,
                "Da Nang Branch"
        ));
    }

    public static void displayEmployee(ArrayList<Employee> listEmployee) {
        for (Employee emp : listEmployee) {
            System.out.println(emp);
        }
    }

    public static Employee searchEmployeeById(ArrayList<Employee> listEmployee, String findId) {
        ArrayList<Employee> search = new ArrayList<>();
        for (Employee emp : listEmployee) {
            if (emp.getId().contains(findId)) {
                return emp;
            }
        }
        return null;
    }

    public int displayMenu() {
        System.out.println("Main menu: ");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        int choice = Validation.checkInputIntLimit("Please enter your selection: ", 1, 6);
        return choice;
    }

    public static void addEmployee() {
        System.out.println("=== Add employee ===");

        String idEmployee = Validation.checkIdExit("Enter employee id: ", listEmployee);
        String fistName = Validation.inputStringName("Enter employee first name: ");
        String lastName = Validation.inputStringName("Enter employee last name: ");
        String phone = Validation.inputPhone("Enter employee phone number: ");
        String email = Validation.inputEmail("Enter employee email: ");
        String address = Validation.inputStringName("Enter employee address: ");
        Date dob = Validation.inputDate("Enter employee dob: ");
        String sex = Validation.inputSex("Enter employee sex: ");
        Double salary = Validation.inputSalary("Enter employee salary: ");
        String agency = Validation.inputStringName("Enter employee agency");
        Employee employee = new Employee(idEmployee, fistName, lastName, phone, email, address, dob, sex, salary, agency);
        listEmployee.add(employee);
        System.out.println("Add employee successfully");
        displayEmployee(listEmployee);
    }

    public static void updateEmployee() {
        if (listEmployee.isEmpty()) {
            System.err.println("List employee is empty");
            return;
        }
        String findId = Validation.inputString("Enter id need update:");
        Employee searchEmployee = searchEmployeeById(listEmployee, findId);
        if (searchEmployee == null) {
            System.err.println("Id not exist in the system");
            return;
        }
        System.out.println(searchEmployee);
        //enter information
        String fistName = Validation.inputStringName("Enter employee first name: ");
        String lastName = Validation.inputStringName("Enter employee last name: ");
        String phone = Validation.inputPhone("Enter employee phone number: ");
        String email = Validation.inputEmail("Enter employee email: ");
        String address = Validation.inputStringName("Enter employee address: ");
        Date dob = Validation.inputDate("Enter employee dob: ");
        String sex = Validation.inputSex("Enter employee sex: ");
        Double salary = Validation.inputSalary("Enter employee salary: ");
        String agency = Validation.inputStringName("Enter employee agency");
        searchEmployee.setFirstName(fistName);
        searchEmployee.setLastName(lastName);
        searchEmployee.setPhone(phone);
        searchEmployee.setEmail(email);
        searchEmployee.setAddress(address);
        searchEmployee.setSex(sex);
        searchEmployee.setSalary(salary);
        searchEmployee.setAgency(agency);
        System.out.println("Update successfully");
    }

    public static void removeEmployee() {
        if (listEmployee.isEmpty()) {
            System.err.println("List employee is empty");
            return;
        }
        String findId = Validation.inputString("Enter id need delete:");
        Employee searchEmployee = searchEmployeeById(listEmployee, findId);
        if (searchEmployee == null) {
            System.err.println("Id not exist in the system");
            return;
        }
        listEmployee.remove(searchEmployee);
        System.out.println("Delete successfully");
    }

    public static void searchEmployee() {
        if (listEmployee.isEmpty()) {
            System.err.println("List employee is empty");
            return;
        }
        String input = Validation.inputString("Enter employee name find:");
        ArrayList<Employee> searchEmployeeName = SearchEmployeeByName(input, listEmployee);
        if (searchEmployeeName.isEmpty()) {
            System.err.println("name not found in system");
            return;
        }
        displayEmployee(searchEmployeeName);
    }

    public static void sortEmployeeBySalary() {
        if (listEmployee.isEmpty()) {
            System.err.println("List employee is empty");
            return;
        }

        Comparator<Employee> sort = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;   // o1 đứng sau o2
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;  // o1 đứng trước o2
                } else {
                    return 0;   // bằng nhau, giữ nguyên vị trí
                }
            }
        };

        Collections.sort(listEmployee, sort);
        displayEmployee(listEmployee); // Gọi hàm hiển thị sau khi sắp xếp
    }

}
