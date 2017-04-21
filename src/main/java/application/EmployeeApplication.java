package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Employee;
import bean.EmployeeBeanPostProcessor;
import bean.EmployeeController;

/**
 * Hello world!
 *
 */
public class EmployeeApplication {
	private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		EmployeeController empController = (EmployeeController) context.getBean("empController");
		
		Employee emp = (Employee) context.getBean("employee");
		String beanName = emp.getBeanName();
		System.out.println("BEAN NAME : " + beanName);
		System.out.println(emp.getBeanClassLoader().toString());
		System.out.println(emp.getBeanClassLoader().getClass());
		System.out.println(emp.getBeanFactory().getClass());

		while (true) {
			int userInput;
			System.out.println("MENU");
			System.out.println("1. Add New Employee");
			System.out.println("2. Update Existing Employee");
			System.out.println("3. Delete Existing Employee");
			System.out.println("4. View All Employee Data");
			System.out.println("5. Exit");
			System.out.println("/n");
			System.out.println("Please Enter Your Choice");

			try {
				userInput = Integer.parseInt(bufferedReader.readLine());

				switch (userInput) {
				case 1:
					empController.addNewEmployee();
					break;

				case 2:
					empController.updateEmployee();
					break;

				case 3:
					empController.deleteEmployee();
					break;

				case 4:
					empController.viewAllEmployee();
					break;

				case 5:
					System.exit(0);
					break;

				default:
					System.out.println("Please Enter a valid choice");
					break;
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}

		}
	}
}
