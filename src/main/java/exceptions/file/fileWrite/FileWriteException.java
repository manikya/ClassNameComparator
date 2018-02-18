package exceptions.file.fileWrite;

import java.io.IOException;

/**
 * Created by Manikya on 2/18/2018.
 */
public class FileWriteException extends Exception {
    private String _filePath;

    public String get_filePath() {
        return _filePath;
    }

    public FileWriteException(String message, String filePath, IOException e) {
        super(message,e);
        this._filePath =filePath;
    }
}
