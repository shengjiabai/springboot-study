package com.bzy.service.other.spirngBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义BeanFactoryPostProcessor  该接口中的方法是最先执行的。在Bean实例化之前执行
 * 
 * 
 * BeanFactoryPostProcessor
 *   postProcessBeanFactory	在Bean对象实例化之前执行， 通过beanFactory可以获取bean的定义信息， 并可以修改bean的定义信息。
 *   这点是和BeanPostProcessor最大区别
 * @author 
 *
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	/**
	 * 本方法在Bean对象实例化之前执行，
	 * 通过beanFactory可以获取bean的定义信息，
	 * 并可以修改bean的定义信息。这点是和BeanPostProcessor最大区别
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("****** BeanFactoryPostProcessor 开始执行了");
		String[] names = beanFactory.getBeanDefinitionNames();
		for (String name : names) {
			if("user".equals(name)){

				BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
				MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
				// MutablePropertyValues如果设置了相关属性，可以修改，如果没有设置则可以添加相关属性信息
				if(propertyValues.contains("name")){
					propertyValues.addPropertyValue("name", "bobo");
					System.out.println("修改了属性信息");
				}
			}
		}
		System.out.println("******* BeanFactoryPostProcessor 执行结束了");
	}
}
