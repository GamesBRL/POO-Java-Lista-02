package biblioteca.modelo;

public abstract class ItemBiblioteca {
    protected String titulo;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

}