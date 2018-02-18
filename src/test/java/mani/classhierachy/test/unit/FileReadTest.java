package mani.classhierachy.test.unit;

import exceptions.file.fileRead.FileReadException;
import org.junit.Assert;
import org.junit.Test;
import readers.file.FileReader;
import readers.file.RegxValues;

import java.io.File;
import java.util.List;

/**
 * Created by Manikya on 2/18/2018.
 */
public class FileReadTest {
    private String _basepath = "src/test/resources/JavaFilesSourceDirectory";
    @Test
    public void Should_Retun_One_Java_File() throws FileReadException {
        File folderPath = new File(_basepath+"/DirectoryWithOneJavaFile");
        List<File> filesFormDirectory = FileReader.getFilesFromDirectory(folderPath, RegxValues.ENDS_WITH_java);
        Assert.assertEquals(filesFormDirectory.size(),1);
        Assert.assertEquals(filesFormDirectory.get(0).getPath(),"src\\test\\resources\\JavaFilesSourceDirectory\\DirectoryWithOneJavaFile\\ContextBind.java");

    }
    @Test
    public void Should_Retun_Two_Java_File() throws FileReadException {
        File folderPath = new File(_basepath+"/JavaFilesInSubDirectories(4Files)");
        List<File> filesFormDirectory = FileReader.getFilesFromDirectory(folderPath,RegxValues.ENDS_WITH_java);
        Assert.assertEquals(filesFormDirectory.size(),4);

    }

}
