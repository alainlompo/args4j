import java.io.File;

public class Business {

    public String name;
    public File file;

    public void setFile(File f) {
        if (f.exists()) file = f;
    }

    public void run() {
        System.out.println("Business-Logic");
        System.out.println("- name: " + name);
        System.out.println("- file: " + ((file!=null)
                ? file.getAbsolutePath()
                : "null"));
    }

}