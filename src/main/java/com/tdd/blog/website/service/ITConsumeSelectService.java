package com.tdd.blog.website.service;

import com.tdd.blog.website.modal.Vo.TConsumeSelect;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author Tdd
 * */
public interface ITConsumeSelectService {

    JSONObject saveTconsumeSelect(TConsumeSelect tConsumeSelect) throws JSONException;

    JSONObject tConsumeSelectList();
}
