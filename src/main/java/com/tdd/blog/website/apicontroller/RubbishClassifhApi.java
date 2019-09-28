package com.tdd.blog.website.apicontroller;


import com.alibaba.fastjson.JSONObject;
import com.tdd.blog.website.exception.TipException;
import com.tdd.blog.website.service.ITbRubbishClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/rubbish")
@Transactional(rollbackFor = TipException.class)
public class RubbishClassifhApi {

    @Resource
    private ITbRubbishClassifyService iTbRubbishClassifyService;

    @PostMapping(value = "/findRubbish")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public Object login(@RequestBody JSONObject jsonObject){
        String rubbishName = jsonObject.getString("rubbishName");

        JSONObject jsonRes = iTbRubbishClassifyService.findRubbishByName(rubbishName);

        return jsonRes;
    }
}
