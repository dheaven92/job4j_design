package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        short myShort = Short.MAX_VALUE;
        byte myByte = Byte.MAX_VALUE;
        int myInt = Integer.MAX_VALUE;
        long myLong = Long.MAX_VALUE;
        float myFloat = Float.MAX_VALUE;
        double myDouble = Double.MAX_VALUE;
        char myChar = Character.MAX_VALUE;
        boolean myBoolean = true;
        LOG.debug("short {}, byte {}, int {}, long {}, float {}, double {}, char {}, boolean {}",
                myShort, myByte, myInt, myLong, myFloat, myDouble, myChar, myBoolean);
    }
}
