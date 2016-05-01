
/**
 * file: driver.java
 * @author Zach Stecher
 * Class: MSCS630 - Security Algorithms and Protocols
 * Assignment: Final Project
 * 
 * This file passes the key and plaintext from its .txt file 
 * into the AES class to generate the round keys and
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
    ECB(plainText, cipher.W);
    
    String theKey = "2b7e151628aed2a6abf7158809cf4f3c";		// Delete at end
    String plainText = "3ad77bb40d7a3660a89ecaf32466ef97";	// Delete at end
    decrypt.aesRoundKeys(theKey);
    decrypt.aesDecrypt(plainText, decrypt.W);
    
    input.close();
  }
  public static String ECB(String s, String k){
	AES cipher = new AES();
    int mSize = s.length();
    int padSize = 0;
    int blocks = 0;
    
    if (mSize < 32){
      padSize = ((32 - mSize) / 2);
      for (int i = 0; i < padSize; i++){
        if (Integer.toHexString(padSize).length() < 2){
          s = s + ("0" + Integer.toHexString(padSize));
        }
        else{
          s = s + Integer.toHexString(padSize);	
        }
      }
      
      cipher.aesEncrypt(s, cipher.W);
    }
    
    if (mSize > 32){
      if (mSize % 32 != 0){
        padSize = (32 - (mSize % 32)) / 2;
        for (int i = 0; i < padSize; i++){
          if (Integer.toHexString(padSize).length() < 2){
            s = s + ("0" + Integer.toHexString(padSize));
          }
          else{
              s = s + Integer.toHexString(padSize);	
          }
        }
      }
    }
    
    blocks = (mSize / 32);
    for (int i = 0; i < blocks; i++){
    	cipher.aesRoundKeys(k);
        cipher.aesEncrypt(s.substring((i * 32), (32*(i+1))), cipher.W);
        System.out.println("");
    }
    
    return s;
  }
}
