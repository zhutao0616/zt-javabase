package com.lfp.zt.javabase.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-03
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    private void stream(){
        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> upper = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        String[] array = alpha.stream().map(object->String.format("##%s",object)).toArray(String[]::new);

        Arrays.stream(array).forEach(System.out::println);
        upper.forEach(System.out::println);

        new Random().ints().limit(10).sorted().forEach(System.out::println);
        String.join(",", upper);
    }

    private void parallelStream(){
        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        alpha.parallelStream().map(String::toUpperCase).forEach(System.out::println);
    }

    public static void main(String[] args){
        Client client = new Client();
        client.parallelStream();
    }

}
