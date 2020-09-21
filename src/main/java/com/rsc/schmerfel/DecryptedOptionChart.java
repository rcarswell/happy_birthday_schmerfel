package com.rsc.schmerfel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class DecryptedOptionChart {

    private final List<List<Character>> lines = new ArrayList<>();
    private int currentSize = 0;

    public void addNextCharPossibilities(final Collection<Character> possibleChars) {
        while(lines.size() < possibleChars.size()) {
            lines.add(new ArrayList<>());
        }

        final List<Character> possibleCharList = new ArrayList<>(possibleChars);
        for (int i = 0; i < possibleChars.size(); i++) {
            final List<Character> line = lines.get(i);
            while(line.size() < currentSize) {
                line.add(null);
            }
            lines.get(i).add(possibleCharList.get(i));
        }

        currentSize++;
    }

    public void outputTo(final Consumer<String> lineOutput) {
        for (final List<Character> line : lines) {
            final StringBuilder sb = new StringBuilder();
            line.forEach(c -> sb.append(c != null ? c : " "));  // Append space where there's no char
            lineOutput.accept(sb.toString());
        }
    }
}
