package com.Group1;

import java.util.Random;

/**
 * This class is to encrypt our passwords
 */
public class Encryption {
    public static String encryptPassword(String password){
        Random rnd = new Random ();
        int number;
        StringBuilder stringBuilder = new StringBuilder ();
        char c;
        for (int i = 0; i <password.length () ; i++) {
            for (int j = 0; j <3 ; j++) {
                do {
                    number =rnd.nextInt (94)+33;
                }while ((number>=48 && number<=57) || number ==44);//don't create a number
                c =(char)number;
                stringBuilder.append (c);
            }
            stringBuilder.append (((int)password.charAt (i))-19);
        }
        return stringBuilder.toString ();
    }
    public static String decryptPassword(String encryptedPassword){
        char c;
        StringBuilder stringBuilder = new StringBuilder ();
        StringBuilder stringBuilder1 = new StringBuilder ();
        for (int i = 0; i < encryptedPassword.length () ; i++) {
            c = encryptedPassword.charAt(i);
            if(c > 47 && c < 58){
                do {
                    stringBuilder.append (c);
                    i++;
                    if (i < encryptedPassword.length ())
                        c = encryptedPassword.charAt(i);
                    else
                        break;
                }while(c > 47 && c < 58);
                stringBuilder1.append ((char)(Integer.parseInt (stringBuilder.toString ())+19));
                stringBuilder=new StringBuilder ();
            }
        }
        return stringBuilder1.toString ();
    }
}
