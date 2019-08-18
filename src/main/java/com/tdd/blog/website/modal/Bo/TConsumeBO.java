package com.tdd.blog.website.modal.Bo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Tdd
 * */
@Table(name = "t_consume")
@Data
public class TConsumeBO {
    /**
     * 主键
     */

    private String id;

    /**
     * 消费类型
     */

    private String tConsumeType;

    /**
     * 消费人
     */
    private String tConsumeUser;
    /**
     * 消费人
     */
    private String tConsumeMoney;

    /**
     * 消费时间
     */
    private String tConsumeDate;

    /**
     * 消费地点
     */
    private String tConsumePlace;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updteUser;

    @Transient
    private String pageNum;
    @Transient
    private String pageSize;


}