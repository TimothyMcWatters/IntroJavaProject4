/**
This program extends Project 3 Password.java:
Moves the encryption of a password to a user defined class  
Has a test class

@author Timothy McWatters
@version 1.0

COP2253    Project 4
File Name: Encryption.java
File 1 of 2
*/

public class Encryption {
   //instance variables
   private int key = 0;
   private String encryptedPassword = "";
   
   /**
   Constructs the Encryption object with default values for instance fields
   */
   public Encryption() {
      key = 0;
      encryptedPassword = "";
   } //end of constructor
   
   /**
   Constructs the Encryption object 
   @param key: The key used for encryption
   @param clearPassword: The non-encrypted password for encryption
   */   
   public Encryption(int key, String clearPassword) {
      this.key = key;
      encrypt(clearPassword);
   } //end of constructor
   
   
   /**
   Encrypts a password using a key
   @param clearPassword: The non-encrypted password for encryption
   */   
   public void encrypt(String clearPassword) {
      for (int i = 0; i < clearPassword.length(); i++) {
         int shiftedASCIICharactersNumber = (clearPassword.charAt(i) + key);
         if (shiftedASCIICharactersNumber < 123) {
            encryptedPassword += (char)(shiftedASCIICharactersNumber);
         } 
         else {
            encryptedPassword += (char)((shiftedASCIICharactersNumber % 122) + 32);
         }
      }
   } // end of encrypt method
   
   /**
   Returns true if the password being checked is the same as the encrypted password 
   @param clearPassword: The non-encrypted password for testing
   @returns a boolean representation of is the passed password valid, or the same as the encrypted password
   */   
   public boolean isValidPassword(String clearPassword) {
      String encryptedPasswordUnderTest = "";
      for (int i = 0; i < clearPassword.length(); i++) {
         int shiftedASCIICharactersNumber = (clearPassword.charAt(i) + key);
         if (shiftedASCIICharactersNumber < 123) {
            encryptedPasswordUnderTest += (char)(shiftedASCIICharactersNumber);
         } 
         else {
            encryptedPasswordUnderTest += (char)((shiftedASCIICharactersNumber % 122) + 32);
         }
      }
      return encryptedPassword.equals(encryptedPasswordUnderTest);
   } // end of isValidPassword method
   
   /**
   Returns the encrypted password 
   @return the encrypted password
   */   
   public String getEncryptedPassword() {
      return encryptedPassword;
   } // end of getEncryptedPassword method
   
   /**
   Sets a password encryption using a key on a new clear password 
   @param key: The key used for encryption
   @param clearPassword: The non-encrypted password for encryption
   */   
   public void setPassword(int key, String clearPassword) {
      this.key = key;
      encrypt(clearPassword);
   } // end of setPassword method
   
   /**
   Returns the key 
   @return the key used for encryption
   */   
   public int getKey() {
      return key;
   } // end of getKey method
   
   /**
   Sets the key 
   @param key: The key used for encryption
   */   
   public void setKey(int key) {
      this.key = key;
   } // end of setKey method
   
   /**
   Returns a String explaining the password and key 
   @return a String explaining the password and key
   */   
   public String toString() {
      String passwordAndKeyString = "The encrypted password is " + getEncryptedPassword() + ". The key used to generate this password is " + getKey() + ".";
      return passwordAndKeyString;
   } // end of toString method
} // end of Encryption class