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
public interface State {

    void doAction(Order order);

}
