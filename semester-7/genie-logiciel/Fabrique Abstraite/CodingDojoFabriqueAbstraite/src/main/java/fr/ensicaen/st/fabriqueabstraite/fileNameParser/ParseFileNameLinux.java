package main.java.fr.ensicaen.st.fabriqueabstraite.fileNameParser;

public class ParseFileNameLinux implements FileNameParser {
    @Override
    public void fileNameParser(String path) {
        int index = path.lastIndexOf("/");
        String r = path.substring(index+1);
        System.out.println(r);
    }
}
