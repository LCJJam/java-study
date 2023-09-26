package com.study.java.ch01;

public enum Ex02Enum {
    KOREA(82,1.1f),
    USA(1,1.2f),
    UK(44,1.3f),
    ETC(0,.15f);

    private final int code;
    private final float tax;

    Ex02Enum (int code , float tax) {
        this.code = code;
        this.tax = tax;
    }
    public float getRefundTax() {
        float refundTax = tax;

        if(code != 0) refundTax = tax - 0.1f;

        return refundTax;
    }
    public float getTax(){
        return tax;
    }
}
