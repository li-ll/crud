package org.example.service;


import org.example.domain.User;
import org.example.util.Result;

import java.util.List;

public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    Result regist(User user);

    /**
     * 判断激活与否
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 登录
     * @param
     * @return
     */
    Result login(String username, String password);

    Result update(User user);

    Result delete(String username);

}
