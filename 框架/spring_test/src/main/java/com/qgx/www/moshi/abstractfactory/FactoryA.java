package com.qgx.www.moshi.abstractfactory;

public class FactoryA  implements Produce{
    @Override
    public Food getFood() {
        return new Baozi();
    }
}
