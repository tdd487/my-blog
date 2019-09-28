package com.tdd.blog.website.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tdd.blog.website.dao.TbRubbishClassifyMapper;
import com.tdd.blog.website.modal.Bo.TConsumeBO;
import com.tdd.blog.website.modal.Vo.TConsume;
import com.tdd.blog.website.modal.Vo.TbRubbishClassify;
import com.tdd.blog.website.service.ITbRubbishClassifyService;
import com.tdd.blog.website.utils.UUID;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by BlueT on 2017/3/3.
 */
@Service
public class TbRubbishClassifyServiceImpl implements ITbRubbishClassifyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TbRubbishClassifyServiceImpl.class);

    @Resource
    private TbRubbishClassifyMapper tbRubbishClassifyMapper;


    @Override
    public JSONObject getTheRubbishType(String content) {
        JSONObject jsonObject = new JSONObject();

        Document doc = Jsoup.parse(content);
        Elements elements = doc.select("p[class=rest]");
        System.out.println(elements);
        String text = elements.text();
        System.out.println(text);
        String[] textList = text.split("：");//你所查询的是：虾 这货属于(建议分类)：湿垃圾 累积已查询次数： 1161909
        //你所查询的是   虾 这货属于(建议分类)   湿垃圾 累积已查询次数   1161909
        String searchKey = textList[1].split(" ")[0];
        String searchValue = textList[2].split(" ")[0];
        System.out.println(searchKey+":"+searchValue);
        TbRubbishClassify tbRubbishClassify = new TbRubbishClassify();
        tbRubbishClassify.setPrimeryKeyId(UUID.UU32());
        tbRubbishClassify.setRubbishName(searchKey);
        tbRubbishClassify.setRubbishType(searchValue);
        tbRubbishClassify.setCreateTime(new Date());
        try{
            tbRubbishClassifyMapper.saveTbRubbishClassify(tbRubbishClassify);
            jsonObject.put("respCode","0000");
            jsonObject.put("respDesc","保存成功");
        }catch (Exception e) {
            jsonObject.put("respCode","0000");
            jsonObject.put("respDesc","保存失败");
        }
        return jsonObject;
    }

    @Override
    public JSONObject findRubbishByName(String rubbishName) {
        JSONObject jsonObject = new JSONObject();
        try {
            TbRubbishClassify tbRubbishClassify = new TbRubbishClassify();
            tbRubbishClassify.setRubbishName(rubbishName);
            List<TbRubbishClassify> list = tbRubbishClassifyMapper.findRubbishByName(tbRubbishClassify);
            jsonObject.put("respCode","0000");
            jsonObject.put("data",list);
            jsonObject.put("respDesc","查询成功");
        }catch (Exception e) {
            jsonObject.put("respCode","0000");
            jsonObject.put("respDesc","保查询失败");
        }
        return jsonObject;
    }
}
