package org.example.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8374325179529529802L;
    private int uid;//用户id
    @NotBlank(message = "用户名不能为空")
    private String username;//用户名，账号
    @NotBlank(message = "密码不能为空")
    private String password;//密码
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式有误")
    private String email;//邮箱
    private String status;//激活状态，Y代表激活，N代表未激活
    private String code;//激活码（要求唯一）
    private String isDelete;

    /**
     * 无参构造方法
     */
    public User() {
    }


    public User(int uid, @NotBlank(message = "用户名不能为空") String username, @NotBlank(message = "密码不能为空") String password, @NotBlank(message = "邮箱不能为空") @Email(message = "邮箱格式有误") String email, String status, String code, String isDelete) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.code = code;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", delete=" + isDelete +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
