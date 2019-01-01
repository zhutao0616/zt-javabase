package com.lfp.zt.javabase.serial;

import java.io.*;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    private void saveFile(Object obj, String des) throws IOException {
        FileOutputStream fos = new FileOutputStream(des);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
        fos.close();
    }

    private Object loadFile(String src) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(src);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }


    public static void main(String[] args) {
        Client client = new Client();
        Demo demo = new Demo();
        demo.setName("zhutao");
        demo.setVersion(1);
        try {
            client.saveFile(demo, "demo.txt");
            Demo copy = (Demo) client.loadFile("demo.txt");
            System.out.println(copy.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
