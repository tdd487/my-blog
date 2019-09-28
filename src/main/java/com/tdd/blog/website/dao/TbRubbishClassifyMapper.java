package com.tdd.blog.website.dao;

import com.tdd.blog.website.modal.Vo.TbRubbishClassify;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbRubbishClassifyMapper{

    Integer saveTbRubbishClassify(@Param("result") TbRubbishClassify tbRubbishClassify);
    List<TbRubbishClassify> findRubbishByName(@Param("result") TbRubbishClassify tbRubbishClassify);
}