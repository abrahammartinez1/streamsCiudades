class ciudad {
    private final String nombre;
    private final String provincia;
    private final int habitantes;
    private final int extension;

    public ciudad(String nombre, String provincia, int habitantes, int extension) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public int getExtension() {
        return extension;
    }
}

