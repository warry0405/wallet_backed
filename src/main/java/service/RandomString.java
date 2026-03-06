package service;

import java.util.UUID;

public class RandomString {

    public static String getRandomString() {
        return UUID.randomUUID().toString();
    }
}