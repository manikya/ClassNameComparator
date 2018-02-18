import exceptions.file.fileRead.FileReadException;
import org.json.JSONObject;
import readers.file.FileReader;
import readers.file.RegxValues;
import readers.jarfile.JarReader;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Manikya on 2/18/2018.
 */
public class main {
    public static void main(String[] args) throws FileReadException, IOException {
        //Detect A Folder
        File folderPath = new File("C:\\Repos\\tomcat-trunk\\modules");
        Map<String, List<String>> map = StatementCollector.getImportstatementClassNames(folderPath);

        File targetDirectory = new File("C:\\Output");
        StatementWriter statementWriter = new StatementWriter(targetDirectory);
        statementWriter.writeStatements(FileType.TEXT,map);
        statementWriter.writeKeys(FileType.TEXT,map);

        File jarFolderPath = new File("C:\\Repos\\classhierachy\\src\\test\\resources\\JarFileSourceDirectory");
        Map<String, List<String>> jarMap = ClassNameCollector.getClassNamesFromJars(jarFolderPath);

        File jarTargetDirector = new File("C:\\JarOutput");
        StatementWriter jarWriter = new StatementWriter(jarTargetDirector);
        jarWriter.writeStatements(FileType.TEXT,jarMap);










        System.out.println();
    }




}
