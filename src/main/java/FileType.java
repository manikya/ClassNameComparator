/**
 * Created by Manikya on 2/18/2018.
 */
public enum FileType{
    JAVA(".java"), TEXT(".txt");

    private String _extension;

    public String getExtension() {
        return _extension;
    }

    FileType(String extension) {
        this._extension=extension;
    }
}
