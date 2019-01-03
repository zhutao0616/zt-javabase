package com.lfp.zt.javabase.exception;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-05
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class BaseDao {

    public Object get(String id) throws DaoException{
        try {
            return Integer.parseInt(id) / 0;
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

}
