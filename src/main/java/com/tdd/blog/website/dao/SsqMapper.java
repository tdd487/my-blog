package com.tdd.blog.website.dao;

import com.tdd.blog.website.modal.Vo.Ssq;
import com.tdd.blog.website.service.impl.SsqServiceImpl;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface SsqMapper{

    List<Ssq> findAllSsq();
}