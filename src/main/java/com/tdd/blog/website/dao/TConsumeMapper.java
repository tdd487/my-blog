package com.tdd.blog.website.dao;

import com.tdd.blog.website.modal.Vo.TConsume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tdd
 * */
public interface TConsumeMapper {
    Integer saveTconsume(@Param("tConsume") TConsume tConsume);
    List<TConsume> tConsumeList(@Param("page") Integer page,@Param("pageSize") Integer pageSize);
}