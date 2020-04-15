package helpers;

import java.util.Random;

public final class Utils {
    private static final String coreString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String randomString(int len) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(coreString.charAt(rnd.nextInt(coreString.length())));
        }
        return sb.toString();
    }
    public static String randString(int len){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(coreString.charAt(rnd.nextInt(coreString.length())));
        }
        return sb.toString();
    }
}