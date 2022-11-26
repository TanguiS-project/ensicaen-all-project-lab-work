package main.java.fr.ensicaen.st.fabriqueabstraite.fabrique;

import main.java.fr.ensicaen.st.fabriqueabstraite.countFolder.CountFolder;
import main.java.fr.ensicaen.st.fabriqueabstraite.countFolder.CountFolderLinux;
import main.java.fr.ensicaen.st.fabriqueabstraite.fileNameParser.FileNameParser;
import main.java.fr.ensicaen.st.fabriqueabstraite.fileNameParser.ParseFileNameLinux;
import main.java.fr.ensicaen.st.fabriqueabstraite.nameSourceFolder.NameSourceFolder;
import main.java.fr.ensicaen.st.fabriqueabstraite.nameSourceFolder.NameSourceFolderLinux;

public class ConcreteFabricLinux implements AbstractFabric {
    @Override
    public FileNameParser createOSParser() {
        return new ParseFileNameLinux();
    }

    @Override
    public CountFolder createFolderCounter() {
        return new CountFolderLinux();
    }

    @Override
    public NameSourceFolder createNameSourceFolderParser() {
        return new NameSourceFolderLinux();
    }
}
