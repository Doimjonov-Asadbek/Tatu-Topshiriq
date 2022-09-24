package com.student.studentapp;

public class Constructor {
    String id, title, youword, wordprice, meaning, notes, check, product;

    public Constructor(String id, String title, String youword, String wordprice, String meaning, String notes, String check, String product) {
        this.id = id;
        this.title = title;
        this.youword = youword;
        this.wordprice = wordprice;
        this.meaning = meaning;
        this.notes = notes;
        this.check = check;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYouword() {
        return youword;
    }

    public String getWordprice() {
        return wordprice;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getNotes() {
        return notes;
    }

    public String getCheck() {
        return check;
    }

    public String getProduct() {
        return product;
    }

}
