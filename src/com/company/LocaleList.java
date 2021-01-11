package com.company;

import java.util.Locale;

public class LocaleList {
    public static void main(String[] args){
        Locale[] localeList= Locale.getAvailableLocales();
        for(var locale : localeList){
            System.out.println(locale.getDisplayCountry() + "=" + locale.getCountry()
            + " " + locale.getDisplayLanguage() + "=" + locale.getLanguage());
        }
       /* System.out.println(localeList[5].getDisplayCountry() + "=" + localeList[5].getCountry()
                + " " +localeList[5].getDisplayLanguage() + "=" + localeList[5].getLanguage());*/
    }

}
