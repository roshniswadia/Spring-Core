package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.Employee;

public class EmployeeDao {

	private final static String INSERT_EMPLOYEE_QUERY = "Insert into employee(Emp_Name,Emp_Contact_Number,Emp_City) values(?,?,?)";
	private final static String UPDATE_EMPLOYEE_QUERY = "Update employee set Emp_Name = ? , Emp_Contact_Number = ? , Emp_City = ? where Emp_Number = ?";
	private final static String DELETE_EMPLOYEE_QUERY = "delete from employee where Emp_Number = ?";
	private final static String SELECT_ALL_EMPLOYEE_QUERY = "select * from employee";

	private JdbcTemplate jdbcTemplate;

	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource) ;
	}

	public void addNewEmployee(final Employee emp) {

		final int noOfRowsInserted = jdbcTemplate.update(INSERT_EMPLOYEE_QUERY, emp.getEmployeeName(),
				emp.getEmployeeContactNumber(), emp.getEmployeeCity());
		if (noOfRowsInserted == 0)
			System.out.println("Records Not Inserted Successfully");
		else
			System.out.println("Records Inserted Successfully");
	}

	public void updateEmployee(final Employee emp) {

		final int noOfRowsUpdated = jdbcTemplate.update(UPDATE_EMPLOYEE_QUERY, emp.getEmployeeName(),
				emp.getEmployeeContactNumber(), emp.getEmployeeCity(), emp.getEmployeeNumber());
		if (noOfRowsUpdated == 0)
			System.out.println("Records Not updated Successfully");
		else
			System.out.println("Records updated Successfully");
	}

	public void deleteEmployee(final int employeeNumber) {

		final int noOfRowsDeleted = jdbcTemplate.update(DELETE_EMPLOYEE_QUERY, employeeNumber);
		if (noOfRowsDeleted == 0)
			System.out.println("Records Not deleted Successfully");
		else
			System.out.println("Records deleted Successfully");

	}

	public List<Employee> viewAllEmployee() {

		List<Employee> empList = (List<Employee>) jdbcTemplate.query(SELECT_ALL_EMPLOYEE_QUERY,
				new RowMapper<Employee>() {

					public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
						Employee emp = new Employee();
						emp.setEmployeeNumber(result.getInt("Emp_Number"));
						emp.setEmployeeName(result.getString("Emp_Name"));
						emp.setEmployeeContactNumber(result.getLong("Emp_Contact_Number"));
						emp.setEmployeeCity(result.getString("Emp_City"));

						return emp;
					}

				});

		return empList;
	}

}
