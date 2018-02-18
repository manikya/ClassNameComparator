package mani.classhierachy.test.unit;

import exceptions.file.fileWrite.FileWriteException;
import org.junit.Assert;
import org.junit.Test;
import writers.file.Filewriter;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Manikya on 2/18/2018.
 */
public class FileWriteTest {
    private String _basepath = "src/test/resources/WriteTest";
    @Test
    public void create_new_file_if_not_exist(){
        File[] files = new File(_basepath).listFiles();
        if(files !=null)
            Arrays.stream(files).forEach(i-> i.delete());

        try {
            String targetFile = _basepath+"/test.txt";
            Filewriter.write(targetFile,"Content");
            Assert.assertTrue(new File(targetFile).exists());
        } catch (FileWriteException e) {
            e.printStackTrace();
        }

    }
}
