package com.qgx.www.ex;

public class MyException extends Exception {
    private int errorCode;
    private String errorMsg;


    public MyException( ) {

    }

    public MyException( int errorCode, String errorMsg) {
        super(errorCode+":"+errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException( int errorCode, String errorMsg,Throwable e) {
        super(errorCode+":"+errorMsg,e);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
