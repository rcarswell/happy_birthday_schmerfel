package com.rsc.schmerfel;

/**
 * Happy Birthday
 */
public class App {

    public static void main(String[] args) {

        final String original = "happy birthday schmerfels";
        final Encrypter encrypter = new Encrypter();
        final int key = 4543;
        final String encrypted = encrypter.encrypt(original, key);
        final DecryptedOptionChart decrypted = encrypter.decrypt(encrypted, key);

        System.out.println();
        System.out.println("\t================================================================");
        System.out.println("\t|");
        System.out.printf("\t|\tEncrypting\t\t'%s':%n", original);
        System.out.println("\t|");
        System.out.printf("\t|%s'%s'%n", "\t".repeat(5), encrypted);
        System.out.println("\t|");
        System.out.println("\t================================================================");
        System.out.println();
        System.out.println("\t================================================================");
        System.out.println("\t|");
        System.out.printf("\t|\tDecrypting\t\t'%s':%n", encrypted);
        System.out.println("\t|");
        decrypted.outputTo(line -> System.out.printf("\t|%s'%s'%n", "\t".repeat(5), line));
        System.out.println("\t|");
        System.out.println("\t================================================================");

    }



}
