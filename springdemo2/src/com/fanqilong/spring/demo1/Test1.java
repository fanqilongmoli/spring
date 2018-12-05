package com.fanqilong.spring.demo1;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring IOC 注解开发测试
 */
public class Test1 {
    /**
     *
     *  -@Component 注解
     *  修饰一个类 将这个类交给spring管理
     *  这个类有三个衍生注解（功能类似） 修饰类
     *  -@Controller web层
     *  -@Service service层
     *  -@Repository Dao层
     *
     * =====属性注入注解
     *  普通属性    @Value 设置普通属性值
     *
     *  对象属性    -@Autowired 设置对象的属性值，但是是按照类型完成属性注入
     *                        我们的习惯是按照名称完成属性注入：必须让@Autowired注解和@Qualifier()一起使用 来完成按照名称注入
     *             -@Resource 完成对象类型的属性注入，按照名称完成属性注入
     *
     *
     *
     */

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
