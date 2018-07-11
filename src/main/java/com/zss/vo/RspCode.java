package com.zss.vo;

public enum RspCode {

    SUCCESS("成功", "000"),
    SYS_ERROR("系统异常", "001"),
    CODE_ERROR("程序异常", "002"),
    DATA_NOT_EXIST("数据不存在", "070"),
    DATA_REPEAT("数据重复", "071"),
    VERIFICATION_DOES_NOT_PASS("验证不通过", "110000"),
    REGECTION_LOAN("拒绝贷款","110003"),
    MISSING_REQUIRED_PARAMETERS("缺少必要参数，参数名为：", "110001"),
    NO_DATA_REQUIRED("必填项无数据", "110002");



    private String message;

    private String code;

    RspCode(String message, String code) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static RspCode getEnum(String value) {
        RspCode[] crc = RspCode.values();
        for (int i = 0; i < crc.length; i++) {
            if (crc[i].getCode().equals(value)) {
                return crc[i];
            }
            i++;
        }
        return null;
    }
}
