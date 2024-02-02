/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author aleks
 */
public class BruteForce {

    

    

    public static void bruteForceAttack(String targetPassword, String characterSet, int maxLength) {
        char[] passwordAttempt = new char[maxLength];
        char[] characterArray = characterSet.toCharArray();

        for (int length = 1; length <= maxLength; length++) {
            System.out.println("Trying passwords of length " + length + "...");
            if (generatePassword(passwordAttempt, characterArray, 0, length, targetPassword)) {
                System.out.println("Password found: " + new String(passwordAttempt));
                return;
            }
        }

        System.out.println("Password not found");
    }

    private static boolean generatePassword(char[] passwordAttempt, char[] characterArray, int position, int maxLength, String targetPassword) {
        if (position == maxLength) {
            String currentAttempt = new String(passwordAttempt);
            System.out.println("Attempt: " + currentAttempt);
            return currentAttempt.equals(targetPassword);
        }

        for (int i = 0; i < characterArray.length; i++) {
            passwordAttempt[position] = characterArray[i];

            if (generatePassword(passwordAttempt, characterArray, position + 1, maxLength, targetPassword)) {
                return true;
            }
        }

        return false;
    }
}
