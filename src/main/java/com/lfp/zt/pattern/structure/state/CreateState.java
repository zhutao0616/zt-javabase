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
public class CreateState implements State{

    @Override
    public void doAction(Order order) {
        order.setState(new CommitState());
        System.out.println("create done");
    }
}
