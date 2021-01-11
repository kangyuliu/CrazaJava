package com.company;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormateTest {
    public static void main(String[] args){
        var dt = new Date();
        Locale[] locales = {Locale.CHINA, Locale.US};
        var df = new DateFormat[16];

        for(var i=0; i<locales.length;i++){
            df[i*8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            df[i*8+1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            df[i*8+2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            df[i*8+3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
            df[i*8+4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
            df[i*8+5] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
            df[i*8+6] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
            df[i*8+7] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
        }

        for(var i=0; i< locales.length;i++){
            var tip=i == 0 ? "----中国日期格式----":"----";
            System.out.println(tip);
            System.out.println("SHORT格式日期：" + df[i*8].format(dt));
            System.out.println("MEDIUM格式日期：" + df[i*8+1].format(dt));
            System.out.println("LONG格式日期：" + df[i*8+2].format(dt));
            System.out.println("FULL格式日期：" + df[i*8+3].format(dt));
            System.out.println("SHORT格式时间：" + df[i*8+4].format(dt));
            System.out.println("MEDIUM格式时间：" + df[i*8+5].format(dt));
            System.out.println("LONG格式时间：" + df[i*8+6].format(dt));
            System.out.println("FULL格式时间：" + df[i*8+7].format(dt));
        }
    }

}