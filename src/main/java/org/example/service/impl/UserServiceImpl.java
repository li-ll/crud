package org.example.service.impl;


import org.example.domain.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.example.util.MailUtils;
import org.example.util.Result;
import org.example.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result regist(User user) {
       User u= userMapper.findByUsername(user.getUsername());
       if(u!=null){
           return  new Result("403","用户名重复","");
       }

        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        userMapper.add(user);
       //3.激活邮件发送，邮件正文？
        String content="<a href='http://localhost:81/user/active?code="+user.getCode()+"'>点击激活</a>";
       MailUtils.sendMail(user.getEmail(),content,"激活邮件");
       //暂时不发送邮件
        return new Result("200","注册成功","");
    }



    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userMapper.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userMapper.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Result login(String username, String password) {
        Result result=new Result();
        User user =   userMapper.findByUsernameAndPassword(username,password);
        if(user==null){
            result.setCode("401");
            result.setMessage("用户名或密码错误");
            return result;
        }
        if (user != null && !"Y".equals(user.getStatus())) {
            result.setCode("402");
            result.setMessage("您尚未激活，请激活");
            return result;
        }else {
            result.setCode("200");
            result.setMessage("登陆成功");
            result.setData(user);
        }
        return result;
    }

    @Override
    public Result update(User user) {
      int i= userMapper.updateUser(user);
      if(i>0){
          return new Result("200","更新成功","");
      }
        return new Result();
    }

    @Override
    public Result delete(String username) {
        int i=userMapper.deleteUser(username);
        if(i>=0){
            return new Result("200","删除成功","");
        }
        return new Result();
    }


}
