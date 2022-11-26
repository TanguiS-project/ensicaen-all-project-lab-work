package main.java.fr.ensicaen.st.fabriqueabstraite.fabrique;

import main.java.fr.ensicaen.st.fabriqueabstraite.countFolder.CountFolder;
import main.java.fr.ensicaen.st.fabriqueabstraite.fileNameParser.FileNameParser;
import main.java.fr.ensicaen.st.fabriqueabstraite.nameSourceFolder.NameSourceFolder;

public interface AbstractFabric {
    FileNameParser createOSParser();
    CountFolder createFolderCounter();
    NameSourceFolder createNameSourceFolderParser();
}
