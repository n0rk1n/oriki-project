package cn.oriki.commons.util;

import lombok.NonNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * 文件工具类
 *
 * @author oriki.wang
 */
public class Files {

    /**
     * 获取 路径 对象
     *
     * @param path 路径
     * @return Path 对象
     */
    public static Path getPath(String path, String... paths) {
        return Paths.get(path, paths);
    }

    /**
     * 转换 Path 对象为 File 对象
     *
     * @param path Path 对象
     * @return File 对象
     */
    public static File pathToFile(Path path) {
        return path.toFile();
    }

    /**
     * 转换 File 对象为 Path 对象
     *
     * @param file File 对象
     * @return Path 对象
     */
    public static Path fileToPath(File file) {
        return file.toPath();
    }

    /**
     * 读取某路径的文件所有内容
     *
     * @param path 路径字符串
     * @return 文件的所有内容的数组形式
     */
    public static byte[] readAllBytes(String path, String... paths) throws IOException {
        return java.nio.file.Files.readAllBytes(getPath(path, paths));
    }

    /**
     * 读取某路径的文件所有内容
     *
     * @param path Path 对象
     * @return 文件的所有内容的数组形式
     */
    public static byte[] readAllBytes(Path path) throws IOException {
        return java.nio.file.Files.readAllBytes(path);
    }

    /**
     * 读取文件的每一行，以字符串形式展现
     *
     * @param path Path 对象
     * @return 每一行以字符串形式展现
     * @throws IOException 读取过程中出现问题
     */
    public static List<String> readAllLines(Path path) throws IOException {
        return java.nio.file.Files.readAllLines(path);
    }

    /**
     * 写入 content 到 Path 所在路径文件中，默认会覆盖
     * <p>
     * 文件不存在会创建
     *
     * @param path    Path 对象
     * @param content 内容字符串
     * @throws IOException 写入异常
     */
    public static void writeReplace(@NonNull Path path, String content) throws IOException {
        java.nio.file.Files.write(path, content.getBytes());
    }

    /**
     * 写入 content 到 Path 所在路径文件中，默认为追加
     * <p>
     * 文件不存在会创建
     *
     * @param path    Path 对象
     * @param content 内容字符串
     * @throws IOException 写入异常
     */
    public static void writeAppend(Path path, String content) throws IOException {
        java.nio.file.Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
    }

    /**
     * 创建文件
     *
     * @param path Path 对象
     * @throws IOException 路径非法抛出的异常
     */
    public static void createFile(Path path) throws IOException {
        if (!java.nio.file.Files.exists(path)) {
            java.nio.file.Files.createFile(path);
        }
    }

    /**
     * 创建目录
     *
     * @param path Path 对象
     * @throws IOException 路径非法抛出的异常
     */
    public static void createDirectory(Path path) throws IOException {
        if (!java.nio.file.Files.exists(path)) {
            java.nio.file.Files.createDirectory(path);
        }
    }

    /**
     * 移动文件
     *
     * @param from 来源文件位置
     * @param to   目标文件位置
     * @throws IOException Path 地址非法抛出的异常
     */
    private static void move(Path from, Path to) throws IOException {
        java.nio.file.Files.move(from, to);
    }

    /**
     * 复制文件
     *
     * @param source 来源文件位置
     * @param target 目标文件位置
     * @throws IOException Path 地址非法抛出的异常
     */
    private static void copy(Path source, Path target) throws IOException {
        java.nio.file.Files.copy(source, target);
    }

    /**
     * 删除文件
     *
     * @param path Path 对象
     * @throws IOException path 地址非法抛出的异常
     */
    public static void delete(Path path) throws IOException {
        if (java.nio.file.Files.exists(path)) {
            java.nio.file.Files.delete(path);
        }
    }

}
