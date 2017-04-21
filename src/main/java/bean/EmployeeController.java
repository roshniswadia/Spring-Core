package bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDao;

public class EmployeeController {

	private int employeeNumber;
	private long employeeContactNumber;
	private String employeeName;
	private String employeeCity;

	private final EmployeeDao empDemo = new EmployeeDao();
	private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	private EmployeeDao empDao;
	private Employee emp;

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public void addNewEmployee() {

		try {
			System.out.println("Enter Employee Name");
			employeeName = bufferedReader.readLine();
			System.out.println("Enter Employee Contact Number");
			employeeContactNumber = Long.parseLong(bufferedReader.readLine());
			System.out.println("Enter Employee City");
			employeeCity = bufferedReader.readLine();

			emp.setEmployeeName(employeeName);
			emp.setEmployeeContactNumber(employeeContactNumber);
			emp.setEmployeeCity(employeeCity);

			empDao.addNewEmployee(emp);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee() {

		try {
			System.out.println("Enter Employee Number");
			employeeNumber = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Enter Employee Name");
			employeeName = bufferedReader.readLine();
			System.out.println("Enter Employee Contact Number");
			employeeContactNumber = Long.parseLong(bufferedReader.readLine());
			System.out.println("Enter Employee City");
			employeeCity = bufferedReader.readLine();

			emp.setEmployeeNumber(employeeNumber);
			emp.setEmployeeName(employeeName);
			emp.setEmployeeContactNumber(employeeContactNumber);
			emp.setEmployeeCity(employeeCity);

			empDao.updateEmployee(emp);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployee() {

		System.out.println("Enter Employee Number");
		try {
			employeeNumber = Integer.parseInt(bufferedReader.readLine());
			empDao.deleteEmployee(employeeNumber);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void viewAllEmployee() {

		List<Employee> listOfEmployees = empDao.viewAllEmployee();
		for(Employee emp : listOfEmployees){
			System.out.println("Employee Number : " + emp.getEmployeeNumber());
			System.out.println("Employee Name : " + emp.getEmployeeName());
			System.out.println("Employee Contact : " + emp.getEmployeeContactNumber());
			System.out.println("Employee City : " + emp.getEmployeeCity());
			
			System.out.println("\n");
		}
	}

}
