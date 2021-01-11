package com.company;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
    public static void main(String[] args)throws Exception{
        Map<String, String> envs = System.getenv();
        for(var key : envs.keySet()){
            System.out.println(key + " ---> " + envs.get(key));
        }
        System.out.println(System.getenv("JAVA_HOME"));
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("pros.txt"), "System Properties");
        System.out.println(properties.getProperty("os.name"));
    }
}
