package com.qgx.www.moshi.abstractfactory;

public class FactoryB implements Produce {
    @Override
    public Food getFood() {
        return new Jiaozi();
    }
}
