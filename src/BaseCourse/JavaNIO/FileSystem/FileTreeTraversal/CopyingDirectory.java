package BaseCourse.JavaNIO.FileSystem.FileTreeTraversal;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyingDirectory extends SimpleFileVisitor<Path> {

    private Path sourceRoot;
    private Path targetRoot;

    public CopyingDirectory(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    public static void main(String[] args) {
        Path copyPath = FileSystems.getDefault().getPath("src/basics/UdemyBaseCourse/JavaNIO/FileSystem" +
                "/TempFilesAndOneLevelTraversalAndSeparators/FileTree/Dir4/Dir2Copy");
        Path sourcePath = FileSystems.getDefault().getPath("src/basics/UdemyBaseCourse/JavaNIO/FileSystem" +
                "/TempFilesAndOneLevelTraversalAndSeparators/FileTree/Dir2");
        try {
            Files.walkFileTree(sourcePath, new CopyingDirectory(sourcePath, copyPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        //forming copyDir using class fields and Path methods
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("Relativized path for copy : " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy : " + copyDir);

        try {
            Files.copy(dir, copyDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("Relativized path for copy : " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy : " + copyDir);

        try {
            Files.copy(file, copyDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error :" + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
