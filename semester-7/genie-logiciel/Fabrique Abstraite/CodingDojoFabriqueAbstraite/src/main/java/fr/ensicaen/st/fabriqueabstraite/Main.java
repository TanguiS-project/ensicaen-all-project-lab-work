package main.java.fr.ensicaen.st.fabriqueabstraite;

import main.java.fr.ensicaen.st.fabriqueabstraite.fabrique.AbstractFabric;
import main.java.fr.ensicaen.st.fabriqueabstraite.fabrique.ConcreteFabricLinux;
import main.java.fr.ensicaen.st.fabriqueabstraite.fabrique.ConcreteFabricWindows;
import javax.script.ScriptEngineManager;


public class Main {
    public static void main(String[] args) {
        String windows = "C:\\Windows\\Documents\\hello.dll";
        String linux = "/user/share/hello.rc";
        AbstractFabric fabricWindows = new ConcreteFabricWindows();
        fabricWindows.createOSParser().fileNameParser(windows);
        fabricWindows.createFolderCounter().countFolder(windows);
        fabricWindows.createNameSourceFolderParser().nameSourceFolder(windows);
        AbstractFabric fabricLinux = new ConcreteFabricLinux();
        fabricLinux.createOSParser().fileNameParser(linux);
        fabricLinux.createFolderCounter().countFolder(linux);
        fabricLinux.createNameSourceFolderParser().nameSourceFolder(linux);

    }
}