package com.fanqilong.spring.demo2;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void save() {
        System.out.println("ProductDaoImpl 执行 save");
    }

    @Override
    public void find() {
        System.out.println("ProductDaoImpl 执行 find");
//        int i =1/0;
    }

    @Override
    public void update() {
        System.out.println("ProductDaoImpl 执行 update");
    }

    @Override
    public String delete() {
        System.out.println("ProductDaoImpl 执行 delete");
        return "delete返回值";
    }
}
