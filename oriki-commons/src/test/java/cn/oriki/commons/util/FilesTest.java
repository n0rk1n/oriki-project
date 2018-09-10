package cn.oriki.commons.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesTest {

    private static final String FILE_NAME = "test.txt";
    private static final String FILE_NAME2 = "test.txt";
    private static final String DIRECTORY_NAME = "directory";

    @Test
    public void getPath() {
        Path path = Files.getPath(FILE_NAME);
        Assert.assertEquals(FILE_NAME, path.toString());
    }

    @Test
    public void pathToFile() {
        Path path = Files.getPath(FILE_NAME);
        File file = Files.pathToFile(path);
        File file1 = new File(FILE_NAME);
        Assert.assertEquals(file, file1);
    }

    @Test
    public void fileToPath() {
        File file = new File(FILE_NAME);
        Path path = Files.fileToPath(file);
        Path path1 = Paths.get(FILE_NAME);

        Assert.assertEquals(path, path1);
    }

    @Test
    public void readAllBytes() throws IOException {
        Files.delete(Files.getPath(FILE_NAME));
        Files.createFile(Files.getPath(FILE_NAME));
        Files.writeReplace(Files.getPath(FILE_NAME), "abcd");

        Path path = Files.getPath(FILE_NAME);
        byte[] bytes = Files.readAllBytes(path);
        String s = new String(bytes);
        Assert.assertEquals("abcd", s);

        Files.delete(Files.getPath(FILE_NAME));
    }

    @Test
    public void readAllBytes1() throws IOException {
        Files.delete(Files.getPath(FILE_NAME));
        Files.createFile(Files.getPath(FILE_NAME));
        Files.writeReplace(Files.getPath(FILE_NAME), "abcd");

        byte[] bytes = Files.readAllBytes(FILE_NAME);
        String s = new String(bytes);
        Assert.assertEquals("abcd", s);

        Files.delete(Files.getPath(FILE_NAME));
    }

    @Test
    public void readAllLines() throws IOException {
        Files.delete(Files.getPath(FILE_NAME));
        Files.createFile(Files.getPath(FILE_NAME));
        Files.writeReplace(Files.getPath(FILE_NAME), "abcd");


        List<String> strings = Files.readAllLines(Files.getPath(FILE_NAME));
        Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(strings.size()));
        for (String string : strings) {
            System.out.println(string);
        }

        Files.delete(Files.getPath(FILE_NAME));
    }

    @Test
    public void writeReplace() throws IOException {
        Files.writeReplace(Files.getPath(FILE_NAME2), "abcd1");

        Files.delete(Files.getPath(FILE_NAME2));
    }

    @Test
    public void writeAppend() throws IOException {
        Files.delete(Files.getPath(FILE_NAME));
        Files.createFile(Files.getPath(FILE_NAME));

        Files.writeAppend(Files.getPath(FILE_NAME2), "abcd");

        Files.delete(Files.getPath(FILE_NAME2));
    }

    @Test
    public void createFile() throws IOException {
        Files.createFile(Files.getPath(FILE_NAME));
        Files.delete(Files.getPath(FILE_NAME));
    }

    @Test
    public void createDirectory() throws IOException {
        Files.createDirectory(Files.getPath(DIRECTORY_NAME));

        Files.delete(Files.getPath(DIRECTORY_NAME));
    }

    @Test
    public void delete() throws IOException {
        Files.delete(Files.getPath(DIRECTORY_NAME));
    }

}