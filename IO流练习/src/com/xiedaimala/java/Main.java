package com.xiedaimala.java;


import org.apache.commons.io.FileUtils;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        //标准输出
        System.out.println("Hello,World!");
        System.out.println("第二行 ");
        //标准输入和Reader
        InputStream val = System.in;
        InputStreamReader stdReader = new InputStreamReader(val);
        char[] buffer = new char[20];
        int length = stdReader.read(buffer);
        //异常处理
        try {
            if (length != 10) {
                throw new IllegalAccessException();
            }
        }catch(IllegalAccessException e){
            System.out.println("输入错误！！！");
            return ;
        }finally {
            System.out.println("不管有没有异常都要继续执行");
            stdReader.close();
        }
        System.out.println(length);
        System.out.println(buffer);

        //从一个文件读取内容，输出到另一个文件
        FileInputStream input = new FileInputStream("res/input.txt");
        FileOutputStream output = new FileOutputStream("res/output.txt");

        InputStreamReader reader = new InputStreamReader(input,"UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(output,"UTF-8");
        /*不使用bufferedReader
        int ch ;
        while ((ch = reader.read()) != -1){
        writer.write(ch);
        }

        reader.close;
        input.close;
        writer.close;
        output.close;
         */
        BufferedReader bufferedReader = new BufferedReader(reader);
        PrintWriter printer = new PrintWriter(writer);
        /*for循环：
        String context = "";


        for(String l = bufferedReader.readLine(); l != null; l = bufferedReader.readLine()){
            context += l;
        }
        */

        //while 循环
        String context1 = "";
        String l2 = null;
        while ((l2 = bufferedReader.readLine())!=null){
            context1 += l2+"\n";
        }

        reader.close();
        input.close();
        System.out.println(context1);
        printer.println(context1);

        printer.close();
        output.close();

        //IO Utils
        File inputFile = new File("res/input.txt");
        String content = FileUtils.readFileToString(inputFile);
        System.out.println(content);
    }
}
