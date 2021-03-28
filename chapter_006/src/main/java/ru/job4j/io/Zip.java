package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packSingleFile(Path source, Path target) {
        packFiles(List.of(source), target);
    }

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile().getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgZip argZip = new ArgZip(args);
        if (!argZip.valid()) {
            return;
        }
        Search search = new Search();
        List<File> files = search.files(argZip.directory(), Arrays.asList(argZip.exclude().split(",")));
        for (File file: files) {
            new Zip().packSingleFile(file.toPath(), new File("./chapter_006/pom.zip").toPath());
        }
    }
}