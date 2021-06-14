package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {

        boolean isMale = true;
        char symbol = '\u0076';
        byte ageByte =  20;
        short ageShort = 21;
        int ageInt = 22;
        long ageLong = 23;
        float ageFloat = 24.1f;
        double ageDouble = 25.2;



        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        LOG.debug("User info isMale: : {}, symbol : {}, ageByte : {}, ageShort : {}, ageInt : {}, ageLong : {},ageFloat : {}, ageDouble : {}",
                isMale, symbol, ageByte, ageShort, ageInt, ageLong, ageFloat, ageDouble);
    }
}