package com.yk.Motivation.domain.qna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usr/qna")
@RequiredArgsConstructor
public class QuestionController {
    @GetMapping("/list")
    public String showList() {
        return "usr/qna/list";
    }
}
