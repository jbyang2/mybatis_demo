package com.example.demo04.common.resp;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Result<T> {
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;


    public static <T>  Result<T> success(){
        return  new Result<T>(200,"操作成功",null);
    }
    public static <T>  Result<T> success(T data){
        return  new Result<T>(200,"操作成功",data);
    }

    public static <T>  Result<T> error(){
        return  new Result<T>(500,"操作异常",null);
    }
    public static <T>  Result<T> error(Integer code,String msg){
        return  new Result<T>(code,msg,null);
    }



}