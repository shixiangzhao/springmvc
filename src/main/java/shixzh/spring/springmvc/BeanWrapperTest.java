package shixzh.spring.springmvc;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import shixzh.spring.springmvc.model.User;

public class BeanWrapperTest {

    public static void main(String[] args) {
        User user = new User();
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
        beanWrapper.setPropertyValue("name", "张三");
        System.out.println(user.getName());
        beanWrapper.setPropertyValue("name", "李四");
        System.out.println(user.getName());
    }

}
