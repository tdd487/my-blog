package com.tdd.blog.website.modal.Vo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "t_consume_select")
public class TConsumeSelect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_T_CONSUME_SELECT.nextval from dual")
    private String id;

    /**
     * select标签option
     */
    @Column(name = "t_consume_type_option")
    private String tConsumeTypeOption;

    /**
     * select标签value
     */
    @Column(name = "t_consume_type_value")
    private String tConsumeTypeValue;

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

}