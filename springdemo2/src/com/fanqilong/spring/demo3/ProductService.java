package com.fanqilong.spring.demo3;

import javax.annotation.Resource;

public class ProductService {
    @Resource
    private ProductDao productDao;
    @Resource
    private OrderDao orderDao;

//    public void setProductDao(ProductDao productDao) {
//        this.productDao = productDao;
//    }

//    public void setOrderDao(OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }

    public void save(){
        System.out.println("ProductService执行了 save 方法。。。。。");
        orderDao.save();
        productDao.save();
    }
}
