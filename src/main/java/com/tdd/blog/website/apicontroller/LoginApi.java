package com.tdd.blog.website.apicontroller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tdd.blog.website.controller.BaseController;
import com.tdd.blog.website.exception.TipException;
import com.tdd.blog.website.service.ISsqService;
import com.tools.CompearTwoList;
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
@RequestMapping("/api/loginApi")
@Transactional(rollbackFor = TipException.class)
public class LoginApi extends BaseController {

    @Resource
    private ISsqService iSsqService;

    @PostMapping(value = "/login")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public Object login(@RequestBody JSONObject jsonObject){
        String redStr = jsonObject.getString("red");
        String[] saList = redStr.split(",");
        List aList = new ArrayList();
        for(int i = 0;i<saList.length;i++) {
            aList.add(saList[i]);
        }
        String blue = jsonObject.getString("blue");

        JSONObject jsonRes = iSsqService.findAllSsq(saList,blue);

        return jsonRes;
    }
}
