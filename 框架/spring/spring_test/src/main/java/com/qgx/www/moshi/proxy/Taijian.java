package com.qgx.www.moshi.proxy;

public class Taijian implements FindWoman{
    private King king;


    public Taijian(King king) {
        this.king = king;
    }

    @Override
    public void getGirl() {
        king.getGirl();
    }
}
