package com.tdd.blog.website.service.impl;

import com.tdd.blog.website.dao.TConsumeMapper;
import com.tdd.blog.website.dao.UserVoMapper;
import com.tdd.blog.website.exception.TipException;
import com.tdd.blog.website.modal.Bo.TConsumeBO;
import com.tdd.blog.website.modal.Vo.TConsume;
import com.tdd.blog.website.modal.Vo.UserVo;
import com.tdd.blog.website.modal.Vo.UserVoExample;
import com.tdd.blog.website.service.ITConsumeService;
import com.tdd.blog.website.service.IUserService;
import com.tdd.blog.website.utils.TaleUtils;
import com.tdd.blog.website.utils.UUID;
import com.tdd.blog.website.utils.UUIDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
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
public class TConsumeServiceImpl implements ITConsumeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TConsumeServiceImpl.class);

    @Resource
    private TConsumeMapper tConsumeMapper;


    @Override
    public JSONObject saveTconsume(TConsume tConsume) {
        JSONObject jsonObject = new JSONObject();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            tConsume.setId(UUIDGenerator.getUUID());
            tConsume.setCreateTime(new Date());
            tConsumeMapper.saveTconsume(tConsume);
            jsonObject.put("respCode","0000");
            jsonObject.put("respDesc","保存成功");
        }catch (Exception e) {
            jsonObject.put("respCode","9999");
            jsonObject.put("respDesc","保存失败");
        }

        return jsonObject;
    }

    @Override
    public JSONObject tConsume(String pageNum, String pageSize) {
        JSONObject jsonObject = new JSONObject();
        Integer pN = Integer.valueOf(pageNum);
        Integer pS = Integer.valueOf(pageSize);
        Integer usn = (pN-1)*pS;
        pageNum = usn.toString();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<TConsume> list = tConsumeMapper.tConsumeList(Integer.valueOf(pageNum),Integer.valueOf(pageSize));
            List<TConsumeBO> listBO = new ArrayList<TConsumeBO>();
            BeanCopier copier = BeanCopier.create(TConsume.class, TConsumeBO.class, false);
            for(TConsume tConsume : list) {
                TConsumeBO tConsumeBO = new TConsumeBO();
                copier.copy(tConsume,tConsumeBO,null);
                tConsumeBO.setTConsumeDate(sdf.format(tConsume.getTConsumeDate()));
                listBO.add(tConsumeBO);
            }
            jsonObject.put("respCode","0000");
            jsonObject.put("data",listBO);
            jsonObject.put("respDesc","查询成功");
        }catch (Exception e) {
            jsonObject.put("respCode","9999");
            jsonObject.put("respDesc","查询失败");
        }

        return jsonObject;
    }
}
