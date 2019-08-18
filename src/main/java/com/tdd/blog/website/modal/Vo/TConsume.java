package com.tdd.blog.website.modal.Vo;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Tdd
 * */
@Table(name = "t_consume")
@Data
public class TConsume {
    /**
     * 主键
     */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_T_CONSUME.nextval from dual")
    private String id;

    /**
     * 消费类型
     */
    @Column(name = "t_consume_type")
    private String tConsumeType;

    /**
     * 消费人
     */
    @Column(name = "t_consume_user")
    private String tConsumeUser;
    /**
     * 消费人
     */
    @Column(name = "t_consume_money")
    private String tConsumeMoney;

    /**
     * 消费时间
     */
    @Column(name = "t_consume_date")
    private Date tConsumeDate;

    /**
     * 消费地点
     */
    @Column(name = "t_consume_place")
    private String tConsumePlace;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 修改人
     */
    @Column(name = "updte_user")
    private String updteUser;

    @Transient
    private String pageNum;
    @Transient
    private String pageSize;


}