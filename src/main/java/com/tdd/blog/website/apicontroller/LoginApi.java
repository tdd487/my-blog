package com.tdd.blog.website.apicontroller;


import com.tdd.blog.website.exception.TipException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/loginApi")
@Transactional(rollbackFor = TipException.class)
public class LoginApi {

}
