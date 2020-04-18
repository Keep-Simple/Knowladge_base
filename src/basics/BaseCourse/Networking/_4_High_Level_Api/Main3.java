package basics.BaseCourse.Networking._4_High_Level_Api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            //configurations before calling connect()
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

            headerFields.forEach((s, strings) -> {
                System.out.println("-----key = " + s);
                strings.forEach(s2 -> System.out.println("value = " + s2));
            });

        } catch (Exception e) {
        }
    }
}
