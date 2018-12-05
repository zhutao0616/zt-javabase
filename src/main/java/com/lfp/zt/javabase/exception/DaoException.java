package com.lfp.zt.javabase.exception;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-05
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class DaoException extends RuntimeException {
    public DaoException(Throwable cause) {
        super("[DaoException]", cause);
    }
}
