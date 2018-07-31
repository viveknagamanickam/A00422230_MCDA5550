package com.example.vivek.sqltest;

/**
 * Created by vivek on 7/17/2018.
 */

public final class UserContract {

    private UserContract(){

    }

    public static class UserEntry {
        public static final String TABLE_NAME = "userInfo";
        public static final String NAME = "name";
        public static final String PASSWORD = "password";
        public static final String DATE = "date";
        public static final String HEALTH_CARD_NUMBER = "healthCardNumber";
        public static final String TABME_NAME_BMI = "bmiInfo";
        public static final int HEIGHT = 0;
        public static final int WEIGHT = 0;
    }


}
