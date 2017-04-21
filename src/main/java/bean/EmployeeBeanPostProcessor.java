package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EmployeeBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Before Initialization");
		System.out.println("Bean object: " + bean);
		System.out.println("Bean name: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("After Initialization");
		System.out.println("Bean object: " + bean);
		System.out.println("Bean name: " + beanName);
		return bean;
	}

}
