package com.nagihome.ej.ch02;

import java.util.*;

public class Item05 {

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(new HashMap<>());
        spellChecker.isValid("Nagi");
    }

    static class SpellChecker {
        private static Map<String, String> dictionary;

        public SpellChecker(Map<String, String> dictionary) {
            this.dictionary = dictionary;
        }

        public boolean isValid(String input) {
            return dictionary.containsKey(input);
        }

        public List<String> suggestions(String typo) {
            return new ArrayList<>();
        }
    }

}
