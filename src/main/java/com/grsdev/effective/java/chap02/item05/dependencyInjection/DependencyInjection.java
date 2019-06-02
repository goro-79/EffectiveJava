package com.grsdev.effective.java.chap02.item05.dependencyInjection;


import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class DependencyInjection {

    public static void main(String[] args) {
        Dictionary dictionary = new DictionaryImpl();
        System.out.println(new SpellChecker(Dictionary::getDefaultInstance).isValidWord("applee"));
    }
}

class SpellChecker {

    private final Dictionary dictionary;

    SpellChecker(Supplier<Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValidWord(String word) {
        return word == null ? false : dictionary.getWords().contains(word.toLowerCase());
    }

}

interface Dictionary {

    List<String> getWords();

    static Dictionary getDefaultInstance() {
        return new DictionaryImpl();
    }
}

class DictionaryImpl implements Dictionary {

    private List<String> words = asList("apple", "mango", "car", "mobile");

    public List<String> getWords() {
        return words;
    }
}