import java.util.Scanner;

/**
This program extends Project 3 Password.java:
Moves the encryption of a password to a user defined class  
Has a test class

@author Timothy McWatters
@version 1.0

COP2253    Project 4
File Name: EncryptionTester.java
File 2 of 2
*/

public class EncyptionTester {
   public static void main(String[] args) {
      // creates a new instance of the Scanner class
      Scanner keyboard = new Scanner(System.in);
      
      // variables
      String clearPassword = "";
      String runAgain = "";
      int key = 0;
      
      // first do-while loop is to determine if you want to run the program again.
      do {  
      // second do-while loop is to ask for another user input for password if it isnt valid.
      // gets user input for the password to encrypt
         do {
            System.out.println("Enter a password at least 8 characters long: ");
            clearPassword = keyboard.next();  
            if (clearPassword.length() < 8) {
               System.out.printf("The password must be at least 8 characters long, your password is only %d characters long.\n", clearPassword.length());
            }
         } while (clearPassword.length() < 8);
      
      // third do-while loop is to ask for a new key if the input key isnt valid
      // gets the user input for the encryption key
         do {
            System.out.println("Type an integer number between 1 & 10 (inclusive) for your encryption key: ");
            key = keyboard.nextInt();
            if (!((key > 0) && (key < 11))) {
               System.out.printf("The key must be between 1 and 10, you entered %d.\n", key);
            }
         } while (!((key > 0) && (key < 11)));
      
      // creates 2 new instances of the Encryption class, one using default and the next using parameters
         Encryption passwordOne = new Encryption();
         Encryption passwordTwo = new Encryption(key, clearPassword);
      
      // calls the object's toString method
         System.out.println(passwordTwo.toString());
      
      // gets user to input a password to test against the encrypted password to determine if its valid (ie the same)
         System.out.println("Enter your password again.");
         String clearPasswordForTesting = keyboard.next();
         if (passwordTwo.isValidPassword(clearPasswordForTesting)) {
            System.out.println("Congratulations that is your valid password!");
         } 
         else {
            System.out.println("NOPE! Sorry that is NOT your valid password!");
         }
      
      // tests the keys getter and setter methods
      // fourth do-while loop is to ask for a new key if the input key isnt valid
      // gets the user input for the encryption key
         do {
            System.out.println("Testing the setKey method, please type an integer number between 1 & 10 (inclusive): ");
            key = keyboard.nextInt();
            if (!((key > 0) && (key < 11))) {
               System.out.printf("The key must be between 1 and 10, you entered %d.\n", key);
            }
         } while (!((key > 0) && (key < 11)));
         passwordTwo.setKey(key);
         System.out.println("The new key you entered is: " + passwordTwo.getKey());
      
      // tests the setPassword method
      // fith do-while loop is to ask for a new password to test the setPassword method
         do {
            System.out.println("Testing the setPassword method, enter a password at least 8 characters long: ");
            clearPassword = keyboard.next();  
            if (clearPassword.length() < 8) {
               System.out.printf("The password must be at least 8 characters long, your password is only %d characters long.\n", clearPassword.length());
            }
         } while (clearPassword.length() < 8);
      
      // sixth do-while loop is to test the setPassword method and ask for a new key if the input key isnt valid
      // gets the user input for the encryption key
         do {
            System.out.println("Testing the setPassword method, type an integer number between 1 & 10 (inclusive) for your encryption key: ");
            key = keyboard.nextInt();
            if (!((key > 0) && (key < 11))) {
               System.out.printf("The key must be between 1 and 10, you entered %d.\n", key);
            }
         } while (!((key > 0) && (key < 11)));
      
      // uses the setPassword method to set passwordOne's password instead of using the default.
         passwordOne.setPassword(key, clearPassword);
      // calls the object's toString method to verify passwordOne's password was changed.
         System.out.println(passwordOne.toString());
      
         System.out.println("Would you like to run the program again? (Y/N)");
         runAgain = keyboard.next();
      } while (runAgain.equalsIgnoreCase("Y"));
   }
}