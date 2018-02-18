package exceptions.file.fileRead;

import java.io.File;

/**
 * Created by Manikya on 2/18/2018.
 */
public class FileReadException extends Exception {
    private File _file;

    public File get_file() {
        return _file;
    }

    public FileReadException(String message, File file) {
        super(message);
        this._file= file;
    }
}
