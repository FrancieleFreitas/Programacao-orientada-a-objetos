import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    // Instâncias pré-definidas
    Autor autor = new Autor("Jess", "Brasileira");
    Livro livro1 = new Livro("Java Basico", autor, "tecnologia", true);
    Livro livro2 = new Livro("Java Avançado", autor, "tecnologia", false);

    // Método 1: Teste do Construtor e Getters
    @Test
    void testConstrutorEGetters() {
        assertEquals("Java Basico", livro1.getTitulo());
        assertEquals("tecnologia", livro1.getGenero());
        assertTrue(livro1.isDisponivel());
        assertEquals(autor, livro1.getAutor());
    }

    // Método 2: Teste do setDisponivel() / setDisponibilidade()
    @Test
    void testSetDisponibilidade() {
        // Testa o livro que já está indisponível (livro2)
        assertFalse(livro2.isDisponivel());
        
        // Define como disponível e testa
        livro2.setDisponivel(true); 
        assertTrue(livro2.isDisponivel());

        // Define livro1 como indisponível (emprestado)
        livro1.setDisponivel(false); 
        assertFalse(livro1.isDisponivel());
    }

    // Método 3: Teste do setAutor()
    @Test
    void testSetAutor() {
        Autor novoAutor = new Autor("Mario", "Italiano");
        livro1.setAutor(novoAutor);
        assertEquals(novoAutor, livro1.getAutor());
    }

    // Método 4: Teste do setTitulo()
    @Test
    void testSetTitulo() {
        livro1.setTitulo("Java Intermediario");
        assertEquals("Java Intermediario", livro1.getTitulo());
    }
}

