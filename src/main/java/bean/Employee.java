package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class Employee implements BeanNameAware , BeanClassLoaderAware , BeanFactoryAware {

	private int employeeNumber;
	private Long employeeContactNumber;
	private String employeeName;
	private String employeeCity;
	private String beanName;
	private ClassLoader classLoader;
	private BeanFactory beanFactory;
	
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Long getEmployeeContactNumber() {
		return employeeContactNumber;
	}
	public void setEmployeeContactNumber(Long employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	public void setBeanName(String beanName) {
		this.beanName=beanName;		
	}
	
	public String getBeanName() {
		return beanName;
	}
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader=classLoader;
		
	}
	public ClassLoader getBeanClassLoader() {
		return classLoader;

	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory=beanFactory;
		
	}
	
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}
	

}
