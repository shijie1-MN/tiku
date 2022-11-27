package com.hopu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @description: ResultPage
 * @author: Ying
 * @time: 2022-8-28 , 0028 23:49
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 940933542793016240L;
    //信息
    private String msg;
    //编码
    private String code;
    //具体内容
    private List<?> data;
    //列表总数量
    private Integer count;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
