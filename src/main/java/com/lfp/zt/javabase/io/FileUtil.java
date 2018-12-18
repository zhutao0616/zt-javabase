package com.lfp.zt.javabase.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-16
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class FileUtil {


    public static void copyFile(String path) throws IOException {
        Path oldFile = Paths.get(path);
        Path newFile = Paths.get("new.txt");
        Files.copy(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void walkDir(String path) throws IOException {
        Path startingDir = Paths.get(path);
        List<Path> result = new LinkedList<>();
        Files.walkFileTree(startingDir, new FindJavaVisitor(result));
        System.out.println("result.size()=" + result.size());
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
        private List<Path> result;
        public FindJavaVisitor(List<Path> result){
            this.result = result;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
            if(file.toString().endsWith(".java")){
                result.add(file.getFileName());
                System.out.println(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }



    public static void zip2rar(File zipFile){

    }

    public static void rar2zip(){

    }


    public static void main(String[] args){
        try {
            //copyFile("baidu.html");

            walkDir(".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
