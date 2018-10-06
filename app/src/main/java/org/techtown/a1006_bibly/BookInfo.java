package org.techtown.a1006_bibly;

import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

public class BookInfo implements Serializable {
    public int book; //책표지
    public String title;
    public String author;
    public String review;
    public float rate; //평점

    public BookInfo(int book) {
        this(book, "", "");
    }

    public BookInfo(int book, String title, String author) {
        this.book = book;
        this.title = title;
        this.author = author;
        this.review = "";
        this.rate = 1;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}