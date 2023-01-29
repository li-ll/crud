package org.example.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.example.domain.User;
import org.example.service.UserService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/regist")
    @ResponseBody
    public Result regigster(@Valid @RequestBody User user) {
        Result result=new Result();
       result=userService.regist(user);
        return result;
    }
    @RequestMapping("/active")
    public Result activeUser(HttpServletRequest request, HttpServletResponse response,String code) throws IOException {
        boolean flag = userService.active(code);
        Result result=new Result();
        if(flag){
            result.setCode("200");
            result.setMessage("激活成功");
        }else {
            result.setCode("500");
            result.setMessage("激活失败，请联系管理员!");
            return result;
        }
        response.sendRedirect(request.getContextPath()+"user/login");
        return result;

    }
    @ResponseBody
    @RequestMapping("/login")
    public Result login(@RequestBody User user){
        Result result=userService.login(user.getUsername(),user.getPassword());
        return result;
    }
    @ResponseBody
    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        Result result=userService.update(user);
        return result;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Result delete(@RequestBody User user){
        Result result=userService.delete(user.getUsername());
        return result;
    }
}
