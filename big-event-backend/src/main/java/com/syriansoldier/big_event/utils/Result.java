package com.syriansoldier.big_event.utils;


import javax.xml.crypto.Data;

public class Result <T>  {
    private String code;
    private String message;
    private T data;

    public Result(){}

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <DataType> Result<DataType> success(){
        return new Result<DataType>("200","操作成功",null);
    }

    public static <DataType> Result<DataType> success(DataType data){
        return new Result<DataType>("200","操作成功",data);
    }

    public static <DataType> Result<DataType> success(String message, DataType data){
        return new Result<DataType>("200",message,data);
    }

    public static <DataType> Result<DataType> error (){
        return new Result<DataType>("500","操作失败", null);
    }

    public static <DataType> Result<DataType> error (String message){
        return new Result<DataType>("500",message, null);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
