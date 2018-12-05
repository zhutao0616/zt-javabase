package com.lfp.zt.javabase.exception;

import java.io.*;

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
public class ExceptionTest {

    public void copyFile(String srcPath, String disPath) throws IOException {
        try(InputStream inputStream = new FileInputStream(srcPath);
            OutputStream outputStream = new FileOutputStream(disPath)){
            byte[] buffer = new byte[8192];
            int len;
            while ((len=inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, len);
            }
        }
        //对于已经实现了AutoCloseable接口的异常，可以不需要finally子句，自带对文件资源的关闭
    }




    public static void main(String[] args){
        BaseService service = new BaseService();

        try {
            //java.lang.ArithmeticException: / by zero
            service.get("123");

            //java.lang.NumberFormatException: For input string: "aaa"
            service.get("aaa");
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
