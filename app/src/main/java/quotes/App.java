/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class App {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("abdallah.json");

            ArrayList<Quote> readFromAraayJson = dataJsonR(fileReader);
            int randomNum = (int) (Math.random() * (readFromAraayJson.size()));
            System.out.println(readFromAraayJson.get(randomNum).toString());
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
        String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        sendGetRequst(url);
       }

    public static ArrayList<Quote> dataJsonR(FileReader fileReader) {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Quote> readFromAraayJson = gson.fromJson(bufferedReader,new TypeToken<ArrayList<Quote>>(){}.getType());
         try {
            bufferedReader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
        return readFromAraayJson;
    }

    public static void sendGetRequst(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = setUpConnectionObject(url);
            if(connection.getResponseCode()== 200){
                BufferedReader in = getBufferedReaderFromConnection(connection);
                printBufferedReaderContect(in);
                in.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static HttpURLConnection setUpConnectionObject(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        return connection;
    }

    static BufferedReader getBufferedReaderFromConnection(HttpURLConnection connection) throws IOException{
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);
        return in;
    }

    static void printBufferedReaderContect(BufferedReader in) throws IOException{
//        String line = in.readLine();
//        while (line!=null){
//            System.out.println(line);
//            line = in.readLine();
//        }
        Gson gson =new Gson();
        QuoteHttp savedata = gson.fromJson(in,QuoteHttp.class);
        System.out.println(savedata.getQuoteText());
        System.out.println(savedata.getQuoteAuthor());
        System.out.println(savedata.getQuoteLink());
    }


}