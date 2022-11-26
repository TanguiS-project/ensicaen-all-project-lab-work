package main.java.fr.ensicaen.st.fabriqueabstraite.nameSourceFolder;

public class NameSourceFolderLinux implements NameSourceFolder {
    @Override
    public void nameSourceFolder(String path) {
        String[] tmp = path.split( "/" );
        System.out.println(tmp[tmp.length - 2 ]);
    }
}
