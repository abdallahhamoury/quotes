package quotes;

import java.util.ArrayList;

public class Quote {
    String author;
    String likes;
    String text;

    public Quote(String author, String likes, String text) {
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "BookQuotes{" +
                " author='" + author + '\'' +
                ", likes=" + likes +
                ", text='" + text + '\'' +
                '}';
    }
}
