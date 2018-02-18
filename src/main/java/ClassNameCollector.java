import exceptions.file.fileRead.FileReadException;
import readers.file.FileReader;
import readers.file.RegxValues;
import readers.jarfile.JarReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manikya on 2/18/2018.
 */
public class ClassNameCollector {
    public static Map<String,List<String>> getClassNamesFromJars(File jarFolderPath) throws FileReadException {

        Map<String,List<String>> map = new HashMap<>();
        List<File> filesFromDirectory = FileReader.getFilesFromDirectory(jarFolderPath, RegxValues.ENDS_WITH_jar);
        for(File file:filesFromDirectory){
            ArrayList<String> classList = JarReader.getClassNamesFromJar(file.getAbsolutePath());
            map.put(file.getName(),classList);
        }
        return map;
    }


}
