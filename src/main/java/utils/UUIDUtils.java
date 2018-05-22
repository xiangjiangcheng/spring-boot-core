package utils;

import java.util.Random;

public class UUIDUtils {
    public static String getGUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    public static String getRandomNum(int length) {
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        char[] ch = "0123456789".toCharArray();
        int index, len = ch.length;
        for (int i = 0; i < length; i++) {
            index = r.nextInt(len);
            sb.append(ch[index]);
        }
        return sb.toString();
    }

    public static String createSn() {
        return System.nanoTime() + getRandomNum(6);
    }
}
