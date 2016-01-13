package com.example.mihirmodi.catmain;

import android.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by mihir modi on 1/11/2016.
 */
public class HashGenerator {
    private static HashGenerator ourInstance = new HashGenerator();

    public static HashGenerator getInstance() {
        return ourInstance;
    }

    private HashGenerator() {
    }

    public static void main(String args[]){
        System.out.print("Im working");


    }
}



