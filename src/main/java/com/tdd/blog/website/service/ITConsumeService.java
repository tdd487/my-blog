package com.tdd.blog.website.service;

import com.tdd.blog.website.modal.Vo.TConsume;
import com.tdd.blog.website.modal.Vo.UserVo;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author Tdd
 * */
public interface ITConsumeService {

    JSONObject saveTconsume(TConsume tConsume) throws JSONException;

    JSONObject tConsume(String pageNum,String pageSize);
}
