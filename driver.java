
/**
 * file: driver.java
 * @author Zach Stecher
 * Class: MSCS630 - Security Algorithms and Protocols
 * Assignment: Final Project
 * 
 * This file passes the key and plaintext from its .txt file 
 * into the aes class to generate the round keys and
 * encrypt the text.
 *
 */

import java.util.Scanner;

public class driver {
  public static void main(String[] args){
    des1 decrypt = new des1();
    Scanner input = new Scanner(System.in);
    String theKey = input.nextLine();
    cipher.aesRoundKeys(theKey);
    String plainText = input.nextLine();
    cipher.aesEncrypt(plainText, cipher.W);
    
    String theKey = "2b7e151628aed2a6abf7158809cf4f3c";
    String plainText = "3ad77bb40d7a3660a89ecaf32466ef97";
    decrypt.aesRoundKeys(theKey);
    decrypt.aesDecrypt(plainText, decrypt.W);
  }
}
