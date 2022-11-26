package main.java.fr.ensicaen.st.composite.lsComposite;

import java.io.File;
import java.util.Objects;

public class MyFile implements FileComposite {
    private final File _file;

    public MyFile(File folder) {
        _file = folder;
    }

    @Override
    public String toString() {
        return ">" + _file.getName();
    }

    @Override
    public void print() {
        if ( _file.getParent() == null ) {
            System.out.println(this);
        }
        String preFix = " | ".repeat(Math.max(0, Objects.requireNonNull(_file.getParent()).split("/").length)) +
                this;
        System.out.println(preFix);
    }
}
