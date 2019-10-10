package day24;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //在运行时读取
@Target(ElementType.FIELD) //只能写在属性上
public @interface ColorName {
    public Color  color() default Color.RED;
}
