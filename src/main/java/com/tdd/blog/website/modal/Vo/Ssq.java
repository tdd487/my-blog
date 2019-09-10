package com.tdd.blog.website.modal.Vo;

import javax.persistence.*;

@Table(name = "ssq")
public class Ssq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_SSQ.nextval from dual")
    private String id;

    private String red;

    private String blue;

    private String days;

    private String qihao;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return red
     */
    public String getRed() {
        return red;
    }

    /**
     * @param red
     */
    public void setRed(String red) {
        this.red = red;
    }

    /**
     * @return blue
     */
    public String getBlue() {
        return blue;
    }

    /**
     * @param blue
     */
    public void setBlue(String blue) {
        this.blue = blue;
    }

    /**
     * @return days
     */
    public String getDays() {
        return days;
    }

    /**
     * @param days
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * @return qihao
     */
    public String getQihao() {
        return qihao;
    }

    /**
     * @param qihao
     */
    public void setQihao(String qihao) {
        this.qihao = qihao;
    }
}