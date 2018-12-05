package com.fanqilong.spring.tx2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config-tx2.xml")
public class Test2 {
    /**
     *
     * 事务的特性
     * 原子性：事物不可分割
     * 一致性：事物执行前后数据完整性保持一致
     * 隔离性：一个事物的执行不应该受到其他事物的干扰
     * 持久性：一旦事物结束，数据就持久到数据库
     *
     *
     * 如果不靠路隔离性引发的安全性问题
     * 读问题
     *      脏读：一个事务读取到另一个事务未提交的数据
     *      不可重复读：一个事物读到另一个事务已经提交的update的数据，导致一个事务中多次查询的结果不一致
     *      虚读、幻读：一个事务读到另一个事务已经提交的insert的数据，导致一个事物中多次查询的结果不一致
     * 写问题：
     *      丢失更新
     *
     *
     * 解决读问题
     *  设置事务的级别
     *      Read uncommitted：未提交读，任何问题都解决不了
     *      Read committed：已提交读，解决脏读，但是不可重复读和虚读有可能发生 *** or
     *      Repeatable read：重复读，解决脏读和不可重复读，但是虚读可能发生呢 *** mysql
     *      Serializable：解决所有问题
     *
     *
     * spring的事务管理
     * 1.PlatformTransactionManager 平台事务管理器 是spring用于事务管理的真正的对象
     *          -DataSourceTransactionManager 使用jdbc管理事务
     *          -HibernateTransactionManager  使用Hibernate管理事务
     *
     * 2.TransactionDefinition 事务的定义信息
     *      事务定义：用于定义事务的相关信息，隔离级别，超时信息，传播行为，是否只读
     *
     * 3.TransactionStatus 事务状态
     *      事务状态：用于记录事务管理过程中，事务的状态的对象
     *
     * spring进行事务管理的时候，首先/平台事务管理器/根据/事务定义信息/进行事务管理，
     *       在事务管理过程中，产生各种状态，将这些状态的信息记录到/事务状态/中
     *
     *
     * spring中提供了七种传播行为
     */

    /**
     * spring的事物管理器： 二声明式事物管理（通过配置实现）----AOP
     *
     * 声明式事务管理   xml方式声明事物管理器
     */


    @Resource
    AccountService accountService;

    @Test
    public void test1(){

        accountService.transfer("fanqilong","gongli",100d);

    }
}
