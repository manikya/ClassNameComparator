package readers.jarfile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Manikya on 2/18/2018.
 */
public class JarReader {
    @SuppressWarnings("resource")
    public static ArrayList<String> getClassNamesFromJar(String jarName) {
        ArrayList<String> listofClasses = new ArrayList<>();
        try {
            JarInputStream crunchifyJarFile = new JarInputStream(new FileInputStream(jarName));
            JarEntry jarEntry;

            while (true) {
                jarEntry = crunchifyJarFile.getNextJarEntry();
                if (jarEntry == null) {
                    break;
                }
                if ((jarEntry.getName().endsWith(".class"))) {
                    String className = jarEntry.getName().replaceAll("/", "\\.");
                    String myClass = className.substring(0, className.lastIndexOf('.'));
                    listofClasses.add(myClass);
                }
            }


        } catch (Exception e) {
            System.out.println("Oops.. Encounter an issue while parsing jar" + e.toString());
        }
        return listofClasses;
    }
}



