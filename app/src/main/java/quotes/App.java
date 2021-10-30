package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.Random;

public class App {

    public static void main(String[] args) throws IOException {
// lab 8
//        try {
//            FileReader fileReader = new FileReader("app/src/test/resources/recentquotes.json");
//            ArrayList<Quote> readFromArrayJson = dataJsonR(fileReader);
//            int randomNum = (int) (Math.random() * (readFromArrayJson.size()));
//            System.out.println(readFromArrayJson.get(randomNum));
//        } catch (FileNotFoundException error) {
//            error.printStackTrace();
//        }
//
//    public static ArrayList<Quote> dataJsonR(FileReader fileReader) {
//        Gson gson = new Gson();
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        // we use TypeToken to convert json file to list Objest
//        ArrayList<Quote> readFromArrayJson = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Quote>>() {
//                }.getType());
//        try {
//            bufferedReader.close();
//        } catch (IOException error) {
//           error.printStackTrace();
//        }
//        return readFromArrayJson;
//    }
//        //// lab 9 - Web requests
        String ApiUrl = " http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        sendGetRequest(ApiUrl);
    }


    static void sendGetRequest(String urlString) throws IOException {
        //Creates an instance of a URL from the String representation.
        URL url = new URL(urlString);
        // The Java HttpURLConnection class is http specific URLConnection
        // you can retrieve information of any HTTP URL such as header information, status code, response code etc.
        HttpURLConnection connection =setUpConnectionObject( url);
        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();//200 Ok Crate

        } catch (Exception e) {
            connection.disconnect();
        }
        if (responseCode == 200) {
            // It reads bytes and decodes them into characters using a specified charset.
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            //Java BufferedReader class is used to read the text from a character-based input stream.
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String quoteReader = bufferReader.readLine();
//                System.out.println(quoteReader);
            bufferReader.close();
            Gson gson = new Gson();
            QuoteHttp QuoteConvert = gson.fromJson(quoteReader, QuoteHttp.class);
            System.out.println(QuoteConvert.toString());
            // write on file
            Writer writer = new FileWriter("ApiData.txt", true);

            gson.toJson(QuoteConvert);
            String str = gson.toJson(QuoteConvert);
            writer.write("[" + str + "]");
            writer.write("\n");
            writer.close();

        } else {
            Gson gson = new Gson();
            BufferedReader fileReader = new BufferedReader(new FileReader("ApiData.txt"));
            ArrayList<String> quotes = new ArrayList<>();
            String line = fileReader.readLine();

            while (line != null) {
                quotes.add(line);
                line = fileReader.readLine();
            }

            Random randomNumber = new Random();
            int i = randomNumber.nextInt(quotes.size());

            System.out.println("The quote is : " + quotes.get(i).toString());
        }

    }

    static HttpURLConnection setUpConnectionObject(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();//200 Ok Crate

        } catch (Exception e) {
            connection.disconnect();
        }

        return connection;
    }
}//App class