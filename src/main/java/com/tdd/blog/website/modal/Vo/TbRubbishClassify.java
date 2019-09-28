package com.tdd.blog.website.modal.Vo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_rubbish_classify")
public class TbRubbishClassify {
    /**
     * 主键
     */
    @Column(name = "primery_key_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TB_RUBBISH_CLASSIFY.nextval from dual")
    private String primeryKeyId;

    /**
     * 垃圾名称
     */
    @Column(name = "rubbish_name")
    private String rubbishName;

    /**
     * 1干垃圾2湿垃圾3可回收垃圾4不可回收垃圾
     */
    @Column(name = "rubbish_type")
    private String rubbishType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private String updateUser;

    /**
     * 获取主键
     *
     * @return primery_key_id - 主键
     */
    public String getPrimeryKeyId() {
        return primeryKeyId;
    }

    /**
     * 设置主键
     *
     * @param primeryKeyId 主键
     */
    public void setPrimeryKeyId(String primeryKeyId) {
        this.primeryKeyId = primeryKeyId;
    }

    /**
     * 获取垃圾名称
     *
     * @return rubbish_name - 垃圾名称
     */
    public String getRubbishName() {
        return rubbishName;
    }

    /**
     * 设置垃圾名称
     *
     * @param rubbishName 垃圾名称
     */
    public void setRubbishName(String rubbishName) {
        this.rubbishName = rubbishName;
    }

    /**
     * 获取1干垃圾2湿垃圾3可回收垃圾4不可回收垃圾
     *
     * @return rubbish_type - 1干垃圾2湿垃圾3可回收垃圾4不可回收垃圾
     */
    public String getRubbishType() {
        return rubbishType;
    }

    /**
     * 设置1干垃圾2湿垃圾3可回收垃圾4不可回收垃圾
     *
     * @param rubbishType 1干垃圾2湿垃圾3可回收垃圾4不可回收垃圾
     */
    public void setRubbishType(String rubbishType) {
        this.rubbishType = rubbishType;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}