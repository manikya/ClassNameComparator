package readers.file;

import exceptions.file.fileRead.FileReadException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Manikya on 2/18/2018.
 */
public class FileReader {
    public static List<File> getFilesFromDirectory(File dir, String fileNameRegx) throws FileReadException {
        if (!dir.isDirectory())
            throw new FileReadException("Path is not a directory", dir);
        if (fileNameRegx == null)
            fileNameRegx = RegxValues.DEFAULT;

        List<File> listOfFiles = new ArrayList<>();
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listOfFiles.addAll(getFilesFromDirectory(file, fileNameRegx));
            } else {
                listOfFiles.add(file);
            }
        }
        String finalFileNameRegx = fileNameRegx;
        return listOfFiles.stream().filter(i -> i.getName().matches(finalFileNameRegx)).collect(Collectors.toList());
    }

    public static List<String> getLinesOfFile(File file, String regx) throws FileReadException, IOException {
        if (file.isDirectory())
            throw new FileReadException("Given path does not represent a file", file);
        if (regx == null || regx.isEmpty())
            regx = RegxValues.DEFAULT;

        List<String> lines = new ArrayList<>();
        String finalRegx = regx;
        List<String> collect = Files.lines(file.toPath()).filter(i -> i.matches(finalRegx)).collect(Collectors.toList());

        return collect;

    }
}
