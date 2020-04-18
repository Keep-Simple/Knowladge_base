package BaseCourse.JavaNIO.ReadingAndWriting._2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("DATA.TXT");
        Files.write(path, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
        List<String> list = Files.readAllLines(path);
        System.out.println(list);
    }
}
