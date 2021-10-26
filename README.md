## Lab 8 - OO Design and GSON

**To use code Create Gson object using GsonBuilder.
Create a Gson object.
Tt is a reusable object Use fromJson() method to get the Object from the JSON Serialize Object to JSON.
Use toJson() method to get the JSON string representation of an object you have to download implementation 'com.google.code.gson:gson:2.8.8'**

The partners:
Dima Zeklam : created the TestJsonFileObject() method for testing .
Abdallah Hamoury : created the BookQuotes class.

And we solved together the main function and write the dataJsonR method .

## Lab 9 -  Web requests

This application will return the random quote from the Api .
first need to make connection with the URL using HttpURLConnection,
the Java HttpURLConnection class is http specific URLConnection,
you can retrieve information of any HTTP URL such as header information, status code, response code etc.
if there is a connection with the internet will return a random quote and will create a file to write this quote in it.
If the app goes offline the app will return the random quote from the file that was created that is included lines of quotes