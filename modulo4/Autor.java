import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private String nacionalidade;
    private List<Livro> obrasPublicadas;
    private boolean isUsuario; // Novo campo da última atividade

    // Construtor ATUALIZADO para a atividade "Crescendo a aplicação"
    public Autor(String nome, String nacionalidade, boolean isUsuario) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.obrasPublicadas = new ArrayList<>();
        this.isUsuario = isUsuario; 
    }

    // Construtor antigo (para compatibilidade, assume isUsuario = false)
    public Autor(String nome, String nacionalidade) {
        this(nome, nacionalidade, false);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
    
    public boolean isUsuario() { // Getter para o novo campo
        return isUsuario;
    }

    public void setIsUsuario(boolean isUsuario) { // Setter para o novo campo
        this.isUsuario = isUsuario;
    }
    
    public List<Livro> getObrasPublicadas() {
        return obrasPublicadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void adicionarObra(Livro livro) {
        this.obrasPublicadas.add(livro);
    }
}

