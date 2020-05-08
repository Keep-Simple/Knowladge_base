package java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static List<Integer> stream() {

        var temp = Stream
                .iterate(1,i -> i <= 10, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .map(i -> i*i);

        return temp.collect(Collectors.toList());

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(stream());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://keep-simple.github.io/homepage/"))
                .build();

        HttpResponse<String> response = client
                .send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
