import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    // Instâncias de suporte
    Autor autor = new Autor("Jess", "Brasileira");
    Livro livro1 = new Livro("Java Basico", autor, "tecnologia", true);
    Livro livro2 = new Livro("Java Avancado", autor, "tecnologia", false);

    // Método 1: Teste do Construtor e Getters
    @Test
    void testConstrutorEGetters() {
        assertEquals("Jess", autor.getNome());
        assertEquals("Brasileira", autor.getNacionalidade());
        // Inicialmente, a lista de obras deve ser vazia ou não nula
        assertNotNull(autor.getObrasPublicadas()); 
    }
    
    // Método 2: Teste do adicionarObra()
    @Test
    void testAdicionarObra() {
        // Adiciona as obras
        autor.adicionarObra(livro1);
        autor.adicionarObra(livro2);

        List<Livro> obras = autor.getObrasPublicadas();
        
        // Verifica se o tamanho da lista está correto
        assertEquals(2, obras.size()); 
        
        // Verifica se os livros corretos estão na lista
        assertTrue(obras.contains(livro1));
        assertTrue(obras.contains(livro2));
    }

    // Método 3: Teste do setNacionalidade()
    @Test
    void testSetNacionalidade() {
        autor.setNacionalidade("Portuguesa");
        assertEquals("Portuguesa", autor.getNacionalidade());
    }

    // Método 4: Teste do setNome()
    @Test
    void testSetNome() {
        autor.setNome("Jessica");
        assertEquals("Jessica", autor.getNome());
    }
}

