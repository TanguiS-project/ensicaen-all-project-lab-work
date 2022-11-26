package main.java.fr.ensicaen.st.fabriqueabstraite.countFolder;

public class CountFolderWindows implements CountFolder {
    @Override
    public void countFolder(String path) {
        String[] tmp = path.split( "\\\\" );
        System.out.println( tmp.length - 2 );
    }
}
