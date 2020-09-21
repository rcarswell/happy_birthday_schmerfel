package com.rsc.schmerfel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Encrypter {

    public static final String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private final int alphabetSize;
    private final Map<Character, Integer> charsToInts;
    private final Map<Integer, Character> intsToChars;

    public Encrypter() {
        this(DEFAULT_ALPHABET);
    }

    public Encrypter(final String alphabet) {
        alphabetSize = alphabet.length();
        charsToInts = new HashMap<>();
        intsToChars = new HashMap<>();
        char[] chars = alphabet.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charsToInts.put(chars[i], i);
            intsToChars.put(i, chars[i]);
        }
    }

    public String encrypt(final String unencryptedString, final int key) {
        final IntStream intStream = unencryptedString.chars().map(c -> this.encrypt((char) c, key));
        final StringBuilder sb = new StringBuilder();
        intStream.mapToObj(c -> (char)c).forEach(sb::append);
        return sb.toString();
    }

    public char encrypt(final char unencryptedChar, final int key) {
        // If char is not part of encryption alphabet, return char as is (e.g. for space character and punctuation)
        if(!charsToInts.containsKey(unencryptedChar)) return unencryptedChar;

        int vU = charsToInts.get(unencryptedChar);
        int vE = (vU * key) % alphabetSize;
        return intsToChars.get(vE);
    }

    public DecryptedOptionChart decrypt(final String encryptedString, final int key) {
        final DecryptedOptionChart chart = new DecryptedOptionChart();
        char[] characterArray = encryptedString.toCharArray();
        for (final char c : characterArray) {
            final Set<Character> possibleCharacters = decrypt(c, key);
            chart.addNextCharPossibilities(possibleCharacters);
        }
        return chart;
    }

    public Set<Character> decrypt(final char encryptedChar, final int key) {

        // If char is not part of encryption alphabet, return char as is (e.g. for space character and punctuation)
        if(!charsToInts.containsKey(encryptedChar)) return Stream.of(encryptedChar).collect(Collectors.toSet());
        final Set<Character> possibleChars = new HashSet<>();

        /*
            =======================================
            |
            |
            |   TODO: Implement
            |
            |
            =======================================
        */

        return possibleChars;

    }

}
