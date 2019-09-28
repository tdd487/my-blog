package com.tdd.blog.website.controller.admin;

import com.tdd.blog.website.exception.TipException;
import com.tdd.blog.website.modal.Bo.RestResponseBo;
import com.tdd.blog.website.modal.Vo.OptionVo;
import com.tdd.blog.website.modal.Vo.TConsume;
import com.tdd.blog.website.modal.Vo.TbRubbishClassify;
import com.tdd.blog.website.modal.Vo.UserVo;
import com.tdd.blog.website.service.IOptionService;
import com.tdd.blog.website.service.ITConsumeService;
import com.tdd.blog.website.service.ITbRubbishClassifyService;
import com.tdd.blog.website.utils.MapCache;
import com.tdd.blog.website.utils.TaleUtils;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tdd on 2017/2/21.
 */
@Controller
@RequestMapping("/admin/rubbish")
@Transactional(rollbackFor = TipException.class)
public class RubbishClassifyController {

    @Resource
    private ITbRubbishClassifyService iTbRubbishClassifyService;

    @Resource
    private IOptionService optionService;

    public static String THEME = "themes/default";
    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = String.valueOf(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) throws UnsupportedEncodingException {
        String str= "虾";
        System.out.println(toUtf8String(str));
    }

    /**
     * 系统设置
     */
    @GetMapping(value = "")
    public String setting(HttpServletRequest request) {
        List<OptionVo> voList = optionService.getOptions();
        Map<String, String> options = new HashMap<>();
        voList.forEach((option) -> {
            options.put(option.getName(), option.getValue());
        });
        request.setAttribute("options", options);
        return "admin/rubbish";
    }
}
