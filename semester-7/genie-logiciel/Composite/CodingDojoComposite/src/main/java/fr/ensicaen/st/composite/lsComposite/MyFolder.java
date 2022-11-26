package main.java.fr.ensicaen.st.composite.lsComposite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyFolder implements FileComposite {
    private final File _folder;
    private final List<FileComposite> _list = new ArrayList<>();

    public MyFolder( File folder ) {
        _folder = folder;
        File[] listFile = folder.listFiles();
        if (listFile == null) {
            return;
        }
        for (File file : listFile) {
            if (file.isFile()) {
                _list.add(new MyFile(file));
            } else {
                _list.add(new MyFolder(file));
            }
        }
    }

    @Override
    public String toString() {
        return "-" + _folder.getName();
    }

    @Override
    public void print() {
        if ( _folder.getParent() == null ) {
            System.out.println(this);
            popPrint();
            return;
        }
        String preFix = " | ".repeat(Math.max(0, _folder.getParent().split("/").length)) + this;
        System.out.println(preFix);
        popPrint();
    }

    private void popPrint() {
        while ( !_list.isEmpty() ) {
            _list.remove(0).print();
        }
    }
}
