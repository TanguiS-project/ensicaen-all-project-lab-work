package main.java.fr.ensicaen.st.fabriqueabstraite.fabrique;

import main.java.fr.ensicaen.st.fabriqueabstraite.countFolder.CountFolder;
import main.java.fr.ensicaen.st.fabriqueabstraite.countFolder.CountFolderWindows;
import main.java.fr.ensicaen.st.fabriqueabstraite.fileNameParser.FileNameParser;
import main.java.fr.ensicaen.st.fabriqueabstraite.fileNameParser.ParseFileNameWindows;
import main.java.fr.ensicaen.st.fabriqueabstraite.nameSourceFolder.NameSourceFolder;
import main.java.fr.ensicaen.st.fabriqueabstraite.nameSourceFolder.NameSourceFolderWindows;

public class ConcreteFabricWindows implements AbstractFabric {
    @Override
    public FileNameParser createOSParser() {
        return new ParseFileNameWindows();
    }

    @Override
    public CountFolder createFolderCounter() {
        return new CountFolderWindows();
    }

    @Override
    public NameSourceFolder createNameSourceFolderParser() {
        return new NameSourceFolderWindows();
    }
}