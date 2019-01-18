package com.lfp.zt.javabase.keyword;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-4-17
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
abstract class Parent {                 //abstract:1、修饰类，说明为抽象类

    public abstract String name();      //abstract:2、修饰方法，说明为抽象方法

    static int prop = 1;                //static:1、修饰属性变量，标识为类变量

    static int getProp(){return prop;}  //static:2、修饰方法，标识为类方法

    static {                            //static:3、修饰代码块，类加载时执行
        System.out.println(Parent.class.getName());
    }

}


public class StaticWord extends Parent {

    static int propOne = 11;
    int propTwo = 12;

    static {
        System.out.println(StaticWord.class.getName());
    }

    @Override
    public String name() {
        return StaticWord.class.getName();
    }


    static class InnerOne {             //static:4、修饰内部类，在外部类可以直接实例化

        void test() {
            //静态内部类只可以使用外部类的静态变量
            System.out.println(propOne);
            //静态内部类不可以使用外部类的实例变量
            //System.out.println(propTwo);
        }

    }

    class InnerTwo {

        void test() {
            //内部类既可以使用外部类的静态变量
            System.out.println(propOne);
            //内部类也可以使用外部类的实例变量
            System.out.println(propTwo);
        }
    }


    public static void main(String[] args){

        //静态内部类可以直接new
        InnerOne innerOne = new InnerOne();
        innerOne.test();
        //非静态内部类需创建一个父类的实例，方能new
        InnerTwo innerTwo = (new StaticWord()).new InnerTwo();
        innerTwo.test();
    }


}

