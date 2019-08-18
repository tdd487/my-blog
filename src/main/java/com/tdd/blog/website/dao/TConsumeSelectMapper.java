package com.tdd.blog.website.dao;

import com.tdd.blog.website.modal.Vo.TConsumeSelect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TConsumeSelectMapper{
    Integer saveTconsumeSelect(@Param("tConsumeSelect") TConsumeSelect tConsumeSelect);

    List<TConsumeSelect> tConsumeSelectList();
}