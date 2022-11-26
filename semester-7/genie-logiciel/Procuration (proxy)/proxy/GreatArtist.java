public enum GreatArtist {
    PATRICK("Patrick Sebastien", "img/seb.jpg"),
    CINDY("Cindy Sander", "img/cindy.jpg"),
    CARLOS("Carlos", "img/carlos.jpg"),
    RENE("Rene la taupe", "img/rene.jpg");

    private final String _name;
    private final String _path;

    GreatArtist( String name, String path ) {
        _name = name;
        _path = path;
    }

    @Override
    public String toString() {
        return _name;
    }

    public String getPath() {
        return SystemValues.PROJECT_PATH + _path;
    }
}
