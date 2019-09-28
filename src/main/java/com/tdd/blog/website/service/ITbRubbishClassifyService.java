package com.tdd.blog.website.service;

import com.alibaba.fastjson.JSONObject;
import com.tdd.blog.website.modal.Vo.TConsume;
import org.json.JSONException;


/**
 * @author Tdd
 * */
public interface ITbRubbishClassifyService {


    JSONObject getTheRubbishType(String content);

    JSONObject findRubbishByName(String rubbishName);
}
