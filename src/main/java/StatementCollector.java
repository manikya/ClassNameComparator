import exceptions.file.fileRead.FileReadException;
import readers.file.FileReader;
import readers.file.RegxValues;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static readers.file.FileReader.getLinesOfFile;


public class StatementCollector {
    private File _directory;
    private FileType _fileType;
    private String _lineRegx;

    public StatementCollector(File directory, FileType filetype, String lineRegx) {
        this._directory = directory;
        this._fileType = filetype;
        this._lineRegx = lineRegx;
    }

    public Map<String,List<String>> getUniqueStatements() throws FileReadException, IOException {
        Map<String,List<String>> map = new HashMap<>();
        List<File> filesFormDirectory = FileReader.getFilesFromDirectory(_directory, RegxValues.ENDS_WITH_java);
        for (File file:filesFormDirectory) {
            List<String> linesOfFile = FileReader.getLinesOfFile(file, RegxValues.STARTS_WITH_import);
            addToMap(map,file,linesOfFile);
        }
        return  map;
    }

    private void addToMap(Map<String, List<String>> map, File file, List<String> linesOfFile) {
        for (String line:linesOfFile){
            if(map.containsKey(line)){
                map.get(line).add(file.getAbsolutePath());
            }else{
                ArrayList ar = new ArrayList();
                ar.add(file.getPath());
                map.put(line,ar);
            }
        }
    }

    public static Map<String,List<String>> getImportstatementClassNames(File folderPath) throws IOException, FileReadException {
        StatementCollector statementCollector = new StatementCollector(folderPath, FileType.JAVA, RegxValues.STARTS_WITH_import);
        Map<String, List<String>> uniqueStatements = statementCollector.getUniqueStatements();

        Map<String, List<String>> newMap =new HashMap<>();
        for(Map.Entry<String, List<String>> entry : uniqueStatements.entrySet()) {
            String key= entry.getKey();
            List<String> value =entry.getValue();
            String newKey = key.replace("import ","");
            newMap.put(newKey, value );
        }
        return newMap;
    }
}
