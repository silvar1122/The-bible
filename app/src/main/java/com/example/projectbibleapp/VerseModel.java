package com.example.projectbibleapp;

public class VerseModel  {
    String verse;
    int verse_number;

    public VerseModel(String verse, int verse_number) {
        this.verse = verse;
        this.verse_number = verse_number;
    }

    public String getVerse() {
        return verse;
    }

    public int getVerse_number() {
        return verse_number;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public void setVerse_number(int verse_number) {
        this.verse_number = verse_number;
    }
}
