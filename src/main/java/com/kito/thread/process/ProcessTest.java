package com.kito.thread.process;/**
 * Created by hasee on 2017/8/6.
 */

import java.io.IOException;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/6-17:27
 */
public class ProcessTest {
    public static void main(String[] args) throws IOException {
        try {
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "E:\\copytest\\123.txt");
            proc.start();
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }

    }
}
