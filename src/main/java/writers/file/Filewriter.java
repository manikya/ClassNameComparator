package writers.file;


import exceptions.file.fileWrite.FileWriteException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Manikya on 2/18/2018.
 */
public class Filewriter {

    public static void write(String filePath,String content) throws FileWriteException {
        FileWriter fw= null;
        File file =null;
        try {
            file=new File(filePath);
            if(!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new FileWriteException("Error in writing to file",filePath,e);
        }
    }
}
