/**
 * file: Driver.java
 * @author Zach Stecher
 * Class: MSCS630 - Security Algorithms and Protocols
 * Assignment: Lab 2 & Lab 3
 * Due Date: February 23rd, 2016; March 29th, 2016
 * 
 * This file passes the key and plaintext from its .txt file 
 * into the aescipher class to generate the round keys and
 * encrypt the text.
 *
 */

import java.util.Scanner;

public class Driver {
  public static void main(String[] args){
    AEScipher cipher = new AEScipher();
    Scanner input = new Scanner(System.in);
    String theKey = input.nextLine();
    cipher.aesRoundKeys(theKey);
    String plainText = input.nextLine();
    cipher.aes(plainText, cipher.W);
  }
}
