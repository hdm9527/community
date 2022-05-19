package com.example.controller;

import com.example.dto.QuestionDTO;
import com.example.entity.Question;
import com.example.entity.User;
import com.example.mapper.QuestionMapper;
import com.example.mapper.UserMapper;
import com.example.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                        @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findUserByToken(token);
                    if (user != null) request.getSession().setAttribute("user", user);
                    break;
                }
            }
        }
        List<QuestionDTO> questionList = questionService.list(page, size);
        model.addAttribute("questions", questionList);
        return "index";
    }
}
