//package com.yhr.base;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.MutablePropertyValues;
//import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
//import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.BeanDefinitionHolder;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
//import org.springframework.beans.factory.support.BeanNameGenerator;
//import org.springframework.context.annotation.AnnotationBeanNameGenerator;
//
///**
// * 实现自己实例化bean并注册为Spring管理
// *
// * @author yhr
// * @version latest
// * @date 2016/9/19
// * @description
// */
//public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
//    /**
//     * 先执行：postProcessBeanDefinitionRegistry()方法，
//     * 在执行：postProcessBeanFactory()方法。
//     */
//
//    //bean 的名称生成器.
//    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
//
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//        /*
//        * 在这里可以注入bean.
//        */
////        registerBean(registry, "shanyA", ShanhyA.class);
////        registerBean(registry, "shanyB", ShanhyB.class);
//    }
//
//    /**
//     * postProcessBeanFactory()是bean配置的工厂方法，在这个方法中可以获取到我们所有在
//     * postProcessBeanDefinitionRegistry方法中注册的所有bean，
//     * 在这里我们可以进行属性的设置等操作。
//     * @param beanFactory
//     * @throws BeansException
//     */
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        String beanName = "dataSourceA";
//        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
//        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
//        //加入属性值
//        mutablePropertyValues.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
//        mutablePropertyValues.addPropertyValue("url", "jdbc:mysql://localhost:3306/test");
//        mutablePropertyValues.addPropertyValue("username", "root");
//        mutablePropertyValues.addPropertyValue("password", "123456");
//
//
//    }
//
//    /**
//     * 提供公共的注册方法。
//     *
//     * @param registry
//     * @param name 注入的名称，未传值则根据bean的名称生成器根据class来生成
//     * @param beanClass bean的Class对象
//     */
//    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
//        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);
//        //可以自动生成name
//        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry));
//        //bean注册的Holer类.
//        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);
//        //使用bean注册工具类进行注册.
//        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
//    }
//}
