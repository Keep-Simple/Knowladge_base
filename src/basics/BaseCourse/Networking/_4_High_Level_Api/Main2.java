package basics.BaseCourse.Networking._4_High_Level_Api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            //configurations before calling connect()
            urlConnection.setDoOutput(true); //no use here, just showing
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line = "";
            while(line !=null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();
//            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
//
//            String line = "";
//            while(line !=null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
