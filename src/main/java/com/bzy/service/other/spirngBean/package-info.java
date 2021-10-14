/**
 * BeanFactoryPostProcessor BeanPostProcessor InstantiationAwareBeanPostProcessor 
 * 三者的区别：
 *  1.BeanFactoryPostProcessor实在所有的bean实例化之前执行，该接口中的方法是最先执行的
 *    postProcessBeanFactory（）中可以获取的所有的bean 可以对bean的属性进行修改
 *  2.BeanPostProcessor  该接口中定义了两个方法，分别在Bean对象实例化及装配后在初始化的前后执行
 *    BeforeInitialization AfterInitialization
 *  3.InstantiationAwareBeanPostProcessor接口
 *   该接口是BeanPostProcessor接口的子接口，所以该接口肯定具有BeanPostProcessor接口的功能，
 *   同时又定义了三个自己的接口，这三个接口是在Bean实例化前后执行的方法。  
 *   
 *   postProcessAfterInitialization bean实例化，初始化了
 *   postProcessAfterInstantiation  bean实例化，没有初始化了
 *   https://dpb-bobokaoya-sm.blog.csdn.net/article/details/8814316
 */

package com.bzy.service.other.spirngBean;

 