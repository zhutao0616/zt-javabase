package com.lfp.zt.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Project: zt-javabase
 * Title: 环绕增强
 * Description: 在原方法的前后都进行拦截增强新的代码
 * @see org.springframework.aop.MethodBeforeAdvice      前置增强
 * @see org.springframework.aop.AfterReturningAdvice    后置增强
 * @see org.aopalliance.intercept.MethodInterceptor     环绕增强
 * @see org.springframework.aop.ThrowsAdvice            异常增强
 * @see org.springframework.aop.IntroductionInterceptor 引介增强
 * Date: 2019-01-09
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ServeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String custom = (String) args[0];

        System.out.println("Can I help you? " + custom);
        Object ret = invocation.proceed();
        System.out.println("Enjoy yourself! " + custom);

        return ret;
    }
}
