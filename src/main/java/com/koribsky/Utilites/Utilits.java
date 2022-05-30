package com.koribsky.Utilites;

import java.io.*;


public class Utilits {


    public String getStringFromByteArray(byte[] settingsData) {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(settingsData);
        Reader reader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        StringBuilder sb = new StringBuilder();
        int byteChar;

        try {
            while((byteChar = reader.read()) != -1) {
                sb.append((char) byteChar);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }


}
