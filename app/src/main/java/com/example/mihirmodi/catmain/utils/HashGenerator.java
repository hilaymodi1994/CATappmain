package com.example.mihirmodi.catmain.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by mihir modi on 1/11/2016.
 */
public class HashGenerator {
    private static HashGenerator ourInstance = new HashGenerator();
    private static String key = "578wefhjw824bfa78r3j4brdfuo3b87fsja839rwqbwe8w3brwe8fb39";

    public static HashGenerator getInstance() {
        return ourInstance;
    }

    private HashGenerator() {
    }

    public static void main(String args[]){
        System.out.print("Im working");


    }

    public static String getHashFromString(String _stringToConvert) throws Exception {
        String hash = "";

        Mac mac = Mac.getInstance("hmacSHA256");
        SecretKeySpec secret = new SecretKeySpec(key.getBytes("ASCII"), mac.getAlgorithm());
        mac.init(secret);
        byte[] digest;
        digest = mac.doFinal(_stringToConvert.getBytes());
        hash = com.example.mihirmodi.catmain.utils.Base64.encodeBytes(digest);
        return hash;
    }
}



