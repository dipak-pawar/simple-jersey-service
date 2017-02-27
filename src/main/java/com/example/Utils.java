package com.example;

public class Utils {

    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String base62(int value) {
//        return Integer.toString(value, 62);
        final StringBuilder sb = new StringBuilder(1);
        do {
            sb.insert(0, BASE62[value % 62]);
            value /= 62;
        } while (value > 0);
        return sb.toString();
    }
}
