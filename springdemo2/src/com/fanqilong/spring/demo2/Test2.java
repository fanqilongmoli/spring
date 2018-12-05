package com.fanqilong.spring.demo2;

import com.fanqilong.spring.demo1.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring IOC 注解开发测试
 */
public class Test2 {
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
     * =====Bean中的其他注解
     *  生命周期注解
     *      -@PostConstruct  //相当于 init-method
     *      -@PreDestroy // 相当于 destroy-method
     *  bean的作用范围注解
     *      -@Scope   作用范围
     *          - singleton  默认单例
     *          - prototype  多例
     *          - request
     *          - session
     *          - globalsession
     */

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
        customerService.save();
//        applicationContext.close();
    }
}
