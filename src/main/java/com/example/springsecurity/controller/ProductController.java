package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/add")
    public String add(){
        return "添加商品成功";
    }

    @RequestMapping("/update")
    public String update(){
        return "修改商品成功";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "删除商品成功";
    }

    @RequestMapping("/find")
    public String find(){
        return "查找商品成功";
    }




}
