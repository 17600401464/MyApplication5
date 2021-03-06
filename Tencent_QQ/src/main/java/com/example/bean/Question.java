package com.example.bean;

/**
 * Created by lenovo on 2017/9/22.
 */

public class Question {

    /**
     * reason : 成功的返回
     * result : {"code":100000,"text":"我不好，别理我。"}
     * error_code : 0
     * http://op.juhe.cn/robot/index
     info=%E4%BD%A0%E5%A5%BD%E4%BD%A0%E5%A5%BD&dtype=&loc=&userid=&key=f5d2667dff1bfc58786a06c04c8429af
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * code : 100000
         * text : 我不好，别理我。
         */

        private int code;
        private String text;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
