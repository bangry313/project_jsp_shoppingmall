package com.ezen.mall.web.common.validate;

/**
 * 데이터 유효성 검증을 위한 유틸리티 클래스
 */
public class Validator {
    /**
     * 데이터 입력 여부 거믖
     * @param value 검증하고자 하는 문자열
     * @return 값이 있을 경우 true, 없을 경우 false
     */
    public static boolean isEmpty(String value){
        if(value == null || value.trim().length() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isEmpty(null));
        System.out.println(isEmpty(""));
        System.out.println(isEmpty(" "));
    }


}
