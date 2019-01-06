package com.lfp.zt.javabase.annontation;

import java.lang.annotation.*;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-06
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface TimeAble {
    String value() default "";
}
