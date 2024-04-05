package com.ezen.mall.web.common.encription;

public class EzenUtil {

    // 암호화
    public static String encription(String text){
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(array[i] + 1004);
        }
        return new String(array);
    }

    // 복호화
    public static String decription(String text){
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(array[i] - 1004);
        }
        return new String(array);
    }
}
