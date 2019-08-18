package com.tdd.blog.website.controller.admin;


;
import com.tdd.blog.website.controller.BaseController;
import com.tdd.blog.website.exception.TipException;
import com.tdd.blog.website.modal.Bo.RestResponseBo;
import com.tdd.blog.website.modal.Vo.*;
import com.tdd.blog.website.service.ILogService;
import com.tdd.blog.website.service.ITConsumeService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 13 on 2017/2/21.
 */
@Controller
@RequestMapping("/admin/consume")
@Transactional(rollbackFor = TipException.class)
public class TConsumeController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TConsumeController.class);

    @Resource
    private ITConsumeService itConsumeService;

    @Resource
    private ILogService logService;



    @PostMapping(value = "/saveConsume")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo publishArticle(TConsume tConsume, HttpServletRequest request) {
        RestResponseBo restResponseBo = new RestResponseBo();
        try {
            JSONObject jsonObject = itConsumeService.saveTconsume(tConsume);
            restResponseBo.setMsg(jsonObject.getString("respDesc"));
            restResponseBo.setCode(jsonObject.getString("respCode"));
        } catch (Exception e) {
            String msg = "保存失败";

            return RestResponseBo.failMsg(msg);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "/consumeList")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public Object consumeList(TConsume tConsume) {
        JSONObject jsonObject = new JSONObject();
        String pageNum = tConsume.getPageNum();
        String pageSize = tConsume.getPageSize();
        jsonObject = itConsumeService.tConsume(pageNum,pageSize);

        return RestResponseBo.successMsg(jsonObject.toString());
    }


    @GetMapping(value = "/toConsume")
    public String editArticle(HttpServletRequest request) {

        return "admin/consume/consume_add";
    }
    @GetMapping(value = "/toConsumeList")
    public String toConsumeList(HttpServletRequest request) {

        return "admin/consume/consume_list";
    }
}
