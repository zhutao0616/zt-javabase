package com.lfp.zt.javabase.classLoader;

import java.io.*;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-05
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class MyClassLoader extends ClassLoader {

    private String root;

    public MyClassLoader(String root) {
        this.root = root;
    }

    public Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return super.defineClass(name, classData, 0, classData.length);
        }

    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
