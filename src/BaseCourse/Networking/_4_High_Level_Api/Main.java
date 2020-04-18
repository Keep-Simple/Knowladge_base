package BaseCourse.Networking._4_High_Level_Api;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    /**
     * This is old classes of Java.net package.
     * Consider using new classes that were introduced in java 11
     */
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI relativeUri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri = baseUri.resolve(relativeUri);
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Fragment = " + uri.getFragment());

            URL url = uri.toURL();
            System.out.println("URL = " + url);

            URL url1 = resolvedUri.toURL();
//            System.out.println("URL = " + url1);
        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax : " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

}
