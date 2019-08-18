package com.tdd.blog.website.controller.admin;


import com.tdd.blog.website.controller.BaseController;
import com.tdd.blog.website.exception.TipException;
import com.tdd.blog.website.modal.Bo.RestResponseBo;
import com.tdd.blog.website.modal.Vo.TConsume;
import com.tdd.blog.website.modal.Vo.TConsumeSelect;
import com.tdd.blog.website.service.ILogService;
import com.tdd.blog.website.service.ITConsumeSelectService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

;

/**
 * Created by 13 on 2017/2/21.
 */
@Controller
@RequestMapping("/admin/consumeSelect")
@Transactional(rollbackFor = TipException.class)
public class TConsumeSelectController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TConsumeSelectController.class);

    @Resource
    private ITConsumeSelectService itConsumeSelectService;

    @Resource
    private ILogService logService;

    @PostMapping(value = "/consumeList")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public Object consumeList() {
        JSONObject jsonObject = new JSONObject();;
        jsonObject = itConsumeSelectService.tConsumeSelectList();

        return RestResponseBo.successMsg(jsonObject.toString());
    }

    @PostMapping(value = "/saveConsume")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo publishArticle(TConsumeSelect tConsumeSelect, HttpServletRequest request) {
        RestResponseBo restResponseBo = new RestResponseBo();
        try {
            JSONObject jsonObject = itConsumeSelectService.saveTconsumeSelect(tConsumeSelect);
            restResponseBo.setMsg(jsonObject.getString("respDesc"));
            restResponseBo.setCode(jsonObject.getString("respCode"));
            return RestResponseBo.successMsg(jsonObject.toString());
        } catch (Exception e) {
            String msg = "保存失败";

            return RestResponseBo.failMsg(msg);
        }
    }

}
