/**
 * file: driver.java
 * @authors Zach Stecher, Thusharika Nuthalapati, Bhargavi Madhunula
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
    Scanner input = new Scanner(System.in);
    String plainText = input.nextLine();
    String theKey = input.nextLine();
    String cipherText= "";
    int mSize = plainText.length();
    cipherText = ECBencrypt(plainText, theKey, mSize);
    ECBdecrypt(cipherText, theKey, mSize);
    
    input.close();
  }
  
  /*
   * Method: ECBencrypt
   * 
   * Parameters:
   *   s - the plaintext
   *   k - the key (in hex form)
   *   mSize - the size of the plaintext
   *
   * This method handles byte padding and encryption for any size message.
   * If not exactly 1 block long, will split into multiple blocks(if larger) 
   * and pad to fill the block size, encrypting each block separately.
   */
  public static String ECBencrypt(String s, String k, int mSize){
    AES cipher = new AES();
    String cText = "";
    int padSize = 0;
    int blocks = 0;
    String cTextHolder = "";
    
    if (mSize < 32){
      cipher.aesRoundKeys(k);
      padSize = ((32 - mSize) / 2);
      for (int i = 0; i < padSize; i++){
        if (Integer.toHexString(padSize).length() < 2){
          s = s + ("0" + Integer.toHexString(padSize));
        }
        else{
          s = s + Integer.toHexString(padSize); 
        }
      }
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
    
    blocks = ((mSize + (padSize*2)) / 32);
    for (int i = 0; i < blocks; i++){
      cipher.aesRoundKeys(k);
      cText = cipher.aesEncrypt(s.substring((i * 32), (32*(i+1))), cipher.W);
      System.out.print(cText);
      cTextHolder = cTextHolder + cText;
    }
    System.out.println("");
    return cTextHolder;
  }
  
  /*
   * Method: ECBdecrypt
   * 
   * Parameters:
   *   s - the ciphertext
   *   k - the key (in hex form)
   *   mSize - the size of the plaintext
   *
   * This method handles byte trimming and decryption for any size message.
   * If not exactly 1 block long, will split into multiple blocks(if larger) 
   * and pad to fill the block size, decrypting each block separately.
   */
  public static String ECBdecrypt(String s, String k, int mSize){
    des1 decrypt = new des1();
    String pText = "";
    int padSize = 0;
    int blocks = 0;
    
    if (mSize < 32){
      padSize = ((32 - mSize) / 2);
      decrypt.aesRoundKeys(k);
      pText = decrypt.aesDecrypt(s, decrypt.W);
    }
    
    if (mSize > 32){
      if (mSize % 32 != 0){
        padSize = (32 - (mSize % 32)) / 2;
      }
    }
    
    blocks = ((mSize + (padSize*2)) / 32);
    for (int i = 0; i < blocks; i++){
      decrypt.aesRoundKeys(k);
      pText = decrypt.aesDecrypt(s.substring((i * 32), (32*(i+1))), decrypt.W);
      if (i == (blocks-1)){
        pText = pText.substring(0, pText.length() - (padSize*2));
      }
      System.out.print(pText);
    }
    
    return s;
  }
}
