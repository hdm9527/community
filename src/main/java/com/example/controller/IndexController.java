package com.example.controller;

import com.example.dto.PaginationDTO;
import com.example.dto.QuestionDTO;
import com.example.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class IndexController {
    @Resource
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "5") Integer size) {
        PaginationDTO<QuestionDTO> pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
