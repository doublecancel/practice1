package com.example.learn.dao;

import com.example.learn.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public int order(Order order) {
        System.out.println("executing---------------");
        Object[] os = Obj2Array(order) ;
        return template.update("insert into `order` (order_id, " +
                "customer_account, " +
                "customer_name, " +
                "customer_id, " +
                "goods_name, " +
                "goods_id, " +
                "goods_price, " +
                "goods_num, " +
                "goods_pic, " +
                "goods_type, " +
                "cost_money, " +
                "pay_money, " +
                "pay_type, " +
                "pay_account, " +
                "pay_channel, " +
                "pay_area, " +
                "create_date, " +
                "modify_date, " +
                "pay_date, " +
                "status, " +
                "version)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",


                order.getOrder_id(),
                order.getCustomer_account(),
                order.getCustomer_name(),
                order.getCustomer_id(),
                order.getGoods_name(),
                order.getGoods_id(),
                order.getGoods_price(),
                order.getGoods_num(),
                order.getGoods_pic(),
                order.getGoods_type(),
                order.getCost_money(),
                order.getPay_money(),
                order.getPay_type(),
                order.getPay_account(),
                order.getPay_channel(),
                order.getPay_area(),
                order.getCreate_date(),
                order.getModify_date(),
                order.getPay_date(),
                order.getStatus(),
                order.getVersion()
                );
    }

    private Object[] Obj2Array(Order order){
        Object[] os = new Object[21];
        os[0] = order.getOrder_id();
        os[1] = order.getCustomer_account();
        os[2] = order.getCustomer_name();
        os[3] = order.getCustomer_id();
        os[4] = order.getGoods_name();
        os[5] = order.getGoods_id();
        os[6] = order.getGoods_price();
        os[7] = order.getGoods_num();
        os[8] = order.getGoods_pic();
        os[9] = order.getGoods_type();
        os[10] = order.getCost_money();
        os[11] = order.getPay_money();
        os[12] = order.getPay_type();
        os[13] = order.getPay_account();
        os[14] = order.getPay_channel();
        os[15] = order.getPay_area();
        os[16] = order.getCreate_date();
        os[17] = order.getModify_date();
        os[18] = order.getPay_date();
        os[19] = order.getStatus();
        os[20] = order.getVersion();
        return os;

    }
}
