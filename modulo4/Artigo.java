public class Artigo {
    private String titulo;
    private Autor autor;
    private String genero;
    private boolean publicado;

    // Construtor conforme a estrutura solicitada
    public Artigo(String titulo, Autor autor, String genero, boolean publicado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publicado = publicado;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
}

