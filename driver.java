
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
    des1 cipher = new des1();
    Scanner input = new Scanner(System.in);
    String theKey = input.nextLine();
    cipher.aesRoundKeys(theKey);
    String plainText = input.nextLine();
    cipher.aesEncrypt(plainText, cipher.W);
  }
}
