import exceptions.file.fileWrite.FileWriteException;
import writers.file.Filewriter;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Manikya on 2/18/2018.
 */
public class StatementWriter {
    private File _tartgetDir;
    public StatementWriter(File targetDirectory) {
        _tartgetDir = targetDirectory;
    }


    public void writeStatements(FileType extension, Map<String, List<String>> uniqueStatements) {
        uniqueStatements.entrySet().forEach(i->{
            try {
                Filewriter.write(_tartgetDir+"/"+i.getKey()+ extension.getExtension(),
                        i.getValue().stream().collect(Collectors.joining("\n"))
                        );
            } catch (FileWriteException e) {
                e.printStackTrace();
            }

        });
    }

    public void writeKeys(FileType extension, Map<String, List<String>> uniqueStatements) {
        try {
            Filewriter.write(_tartgetDir+"/KEYS"+ extension.getExtension(),
                    uniqueStatements.keySet().stream().collect(Collectors.joining("\n"))
            );
        } catch (FileWriteException e) {
            e.printStackTrace();
        }

    }
}
