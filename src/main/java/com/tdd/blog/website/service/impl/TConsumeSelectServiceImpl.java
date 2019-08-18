package com.tdd.blog.website.service.impl;


import com.tdd.blog.website.dao.TConsumeSelectMapper;
import com.tdd.blog.website.modal.Vo.TConsumeSelect;
import com.tdd.blog.website.service.ITConsumeSelectService;
import com.tdd.blog.website.utils.UUIDGenerator;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by BlueT on 2017/3/3.
 */
@Service
public class TConsumeSelectServiceImpl implements ITConsumeSelectService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TConsumeSelectServiceImpl.class);

    @Resource
    private TConsumeSelectMapper tConsumeSelectMapper;


    @Override
    public JSONObject saveTconsumeSelect(TConsumeSelect tConsumeSelect) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        try{


            tConsumeSelect.setId(UUIDGenerator.getUUID());
            tConsumeSelect.setCreateTime(new Date());
            tConsumeSelect.setUpdateTime(new Date());
            tConsumeSelect.setCreateUser("谭栋栋");
            tConsumeSelect.setUpdteUser("谭栋栋");
            tConsumeSelectMapper.saveTconsumeSelect(tConsumeSelect);
            jsonObject.put("respCode","0000");
            jsonObject.put("respDesc","保存成功");
        }catch (Exception e) {
            jsonObject.put("respCode","9999");
            jsonObject.put("respDesc","保存失败");
        }

        return jsonObject;
    }

    @Override
    public JSONObject tConsumeSelectList() {
        JSONObject jsonObject = new JSONObject();
        try{
            List<TConsumeSelect> list = tConsumeSelectMapper.tConsumeSelectList();
            jsonObject.put("respCode","0000");
            jsonObject.put("data",list);
            jsonObject.put("respDesc","查询成功");
        }catch (Exception e) {
            jsonObject.put("respCode","9999");
            jsonObject.put("respDesc","查询失败");
        }
        return jsonObject;
    }
}
