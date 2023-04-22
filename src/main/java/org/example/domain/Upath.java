package org.example.domain;

/**
 * @author ruo
 * @version 1.0
 * @date 2023/4/22
 */

import java.io.Serializable;
import java.util.Date;

public class Upath implements Serializable {


    private String url;
    private Date createTime;
    private String methodType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    @Override
    public String toString() {
        return "Upath{" +
                "url='" + url + '\'' +
                ", createTime=" + createTime +
                ", methodType='" + methodType + '\'' +
                '}';
    }
}

