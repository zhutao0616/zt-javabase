package com.lfp.zt.javabase.javaBean;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-16
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    public void writeObject() throws IOException {

        BeanDemo demo = new BeanDemo();
        demo.setId("666");
        demo.setName("zhutao");


        OutputStream output = Files.newOutputStream(Paths.get("demo.xml"));
        XMLEncoder encoder = new XMLEncoder(output);
        encoder.writeObject(demo);
        encoder.close();
        output.close();
    }

    public void readObject() throws IOException {
        InputStream input = Files.newInputStream(Paths.get("demo.xml"));
        XMLDecoder decoder = new XMLDecoder(input);

        BeanDemo demo = (BeanDemo) decoder.readObject();
        System.out.println(demo.getId()+":"+demo.getName());
        decoder.close();
        input.close();
    }


    public static void main(String[] args) {

        Client client = new Client();
        try {
            client.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        BeanInfo beanInfo = Introspector.getBeanInfo(SimpleFileVisitor.class);
        System.out.println(beanInfo.toString());
        System.out.println(beanInfo.getBeanDescriptor());
        System.out.println(beanInfo.getMethodDescriptors().length);
        System.out.println(beanInfo.getPropertyDescriptors().length);
        System.out.println(beanInfo.getEventSetDescriptors().length);
        */

    }
}
