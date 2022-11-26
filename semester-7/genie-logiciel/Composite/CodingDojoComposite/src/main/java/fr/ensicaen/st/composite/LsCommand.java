package main.java.fr.ensicaen.st.composite;

import main.java.fr.ensicaen.st.composite.lsComposite.FileComposite;
import main.java.fr.ensicaen.st.composite.lsComposite.MyFolder;

import java.io.File;

public final class LsCommand {
    public static void main( String[] args ) {
        String folderName = ".";
        File folder = new File(folderName);
        System.out.println("ls " + folder.getAbsolutePath());
        FileComposite fileComposite = new MyFolder(folder);
        fileComposite.print();
    }
}