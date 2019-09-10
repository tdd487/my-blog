package com.tdd.blog.website.service;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author Tdd
 * */
public interface ISsqService {

    JSONObject findAllSsq(String[] aList, String blue);
}
