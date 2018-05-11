package com.smartbean.enums;

public enum ResponseResultEnum {
    OK("OK", 0, "删除"),
    UNKNOWN_ERROR("UNKNOWN_ERROR", 10000,  "内部错误"),
    TOKEN_INVALID("TOKEN_INVALID", 10001, "Token 无效"),
    TOKEN_EXPIRED("TOKEN_EXPIRED", 10002, "Token 过期"),
    SIGN_INVALID("SIGN_INVALID", 10003, "Sign 无效"),
    SIGN_EXPIRED("SIGN_EXPIRED", 10004, "Sign 过期"),

    ;

    /**
     * 返回结果枚举构造方法
     *
     * @param code        结果码
     * @param dbValue      数据库存入短整型值
     * @param description 结果描述
     */
    ResponseResultEnum(String code, Integer dbValue, String description) {
        this.code = code;
        this.dbValue = dbValue;
        this.description = description;
    }

    /**
     * code
     */
    private String code;

    /**
     * 数据库保存的对应值
     */
    private Integer dbValue;
    /**
     * 描述
     */
    private String description;

    /**
     *
     * @return 代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取数据中存入的对应短整型值
     * @return
     */
    public Integer getDBValue() {
        return dbValue;
    }

    /**
     * @return 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 通过code得到返回结果对象
     *
     * @param code 结果码
     * @return 结果枚举对象
     */
    public static ResponseResultEnum get(String code) {
        if ("".equals(code) || code == null) {
            throw new RuntimeException("编码不存在！");
        }
        ResponseResultEnum[] list = values();
        for (ResponseResultEnum customerType : list) {
            if (code.equals(customerType.getCode().toString())) {
                return customerType;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DataStatusEnum{" +
                "code=" + code +
                ", dbValue=" + dbValue +
                ", description='" + description + '\'' +
                '}';
    }
}
