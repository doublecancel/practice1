package com.example.learn.entity;

import lombok.Data;

@Data
public class Order {
    private Long id;

    private String order_id;

    private String customer_account;
    private String customer_name;
    private Long customer_id;

    private String goods_name;
    private Long goods_id;
    private Long goods_price;
    private Integer goods_num;
    private String goods_pic;
    private Integer goods_type;

    private Long cost_money;
    private Long pay_money;
    private String pay_type;
    private Long pay_account;

    private String create_date;
    private String modify_date;
    private String pay_date;

    private String pay_area;
    private String pay_channel;



    private Integer status;
    private Integer version;


}
