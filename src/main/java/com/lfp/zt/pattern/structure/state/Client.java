package com.lfp.zt.pattern.structure.state;

/**
 * Title:
 *
 * @author zhutao.0616@bytedance.com
 * @version 1.0
 * @Project: zt-javabase
 * @Date: 2023-03-21
 * @Company ByteDance
 */
public class Client {

    public static void main(String[] args) {
        Order order = new Order();

        State createState = new CreateState();
        createState.doAction(order);

        State commitState = new CommitState();
        commitState.doAction(order);


        State bindState = new BindState();
        bindState.doAction(order);



    }

}
