package com.smartbean.result;

public class ResponseResult {

    private String message;//返回成功或失败的提示信息
    private Object result;//返回的实体数据
    private boolean success;//返回是否成功的标示
    private Integer errorCode;//报文编码

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
