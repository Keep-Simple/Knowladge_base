package BaseCourse.JavaNIO.FileSystem.FileTreeTraversal;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TraversingDirectoryWithNames extends SimpleFileVisitor<Path> {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("src/basics/UdemyBaseCourse/JavaNIO/" +
                "FileSystem/Third/FileTree/Dir2");
        try {
            Files.walkFileTree(path, new TraversingDirectoryWithNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
