/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
// lab 8
//    App classUnderTest = new App();
//    @Test void TestJsonFileObject(){
//        ArrayList<Quote> quotes= new ArrayList<>();
//        try {
//
//            FileReader fileReader = new FileReader("src/test/resources/recentquotes.json");
//            quotes = App.dataJsonR(fileReader);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Random random = new Random();
//        int randomBookQuotes = random.nextInt(quotes.size());
//        String expected =("BookQuotes{" +
//                " author='" +  quotes.get(randomBookQuotes).getAuthor() + '\'' +
//                ", likes=" + quotes.get(randomBookQuotes).getLikes() +
//                ", text='" + quotes.get(randomBookQuotes).getText() + '\'' +
//                '}');
//
//
//
//        assertEquals(expected,quotes.get(randomBookQuotes).toString());
//    }
    // lab 9
    @Test void TestConnection() throws IOException {
        String ApiUrl = " http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        URL url= new URL(ApiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = 0;
        responseCode = connection.getResponseCode();//200 Ok Crate
        assertEquals(200,responseCode);
    }
    @Test void QuoteHttpConstructor(){
        QuoteHttp quotes = new QuoteHttp("By accepting yourself and being fully what you are," +
                " your presence can make others happy.","Jane Roberts",
                "http://forismatic.com/en/d42f03c3d3/");
        String expected= "QuoteHttp{quoteText='By accepting yourself and being fully what you are, " +
                "your presence can make others happy.'," +
                " quoteAuthor='Jane Roberts', quoteLink='http://forismatic.com/en/d42f03c3d3/'}";
        assertEquals(expected,quotes.toString());
    }
}
