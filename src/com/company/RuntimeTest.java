package com.company;

import java.io.IOException;

public class RuntimeTest {
    public static void main(String[] args)throws IOException {
        var runTime = Runtime.getRuntime();
        runTime.exec("java HelloWolrd");
    }
}
