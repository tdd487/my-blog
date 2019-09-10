package com.tdd.blog.website.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tdd.blog.website.dao.SsqMapper;
import com.tdd.blog.website.modal.Vo.Ssq;
import com.tdd.blog.website.service.ISsqService;
import com.tools.CompearTwoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BlueT on 2017/3/3.
 */
@Service
public class SsqServiceImpl implements ISsqService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SsqServiceImpl.class);

    @Resource
    private SsqMapper ssqMapper;

    @Override
    public JSONObject findAllSsq(String[] aList, String blue) {

        List<Ssq> ssqList = ssqMapper.findAllSsq();
        boolean flg = false;
        String res = "";
        String data = "";
        for(int i = 0;i<ssqList.size();i++){
            List bList = new ArrayList();
            String resRed = ssqList.get(i).getRed();
            System.out.println(resRed);
            String[] sbList = resRed.split(",");

            for(int j = 0;j<sbList.length;j++) {

                bList.add(sbList[j]);
            }
            Arrays.sort(aList);
            Arrays.sort(sbList);
            flg =  Arrays.equals(aList, sbList);
            //flg = CompearTwoList.equals(aList, bList);
            if(flg==true) {
                res = "已有";
                data = resRed;
                break;
            }else{
                res = "未有";
            }
            bList.clear();
        }


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("respCode","0000");
        jsonObject.put("data",data);
        jsonObject.put("respDesc","查询成功,"+res);
        return jsonObject;
    }
}
