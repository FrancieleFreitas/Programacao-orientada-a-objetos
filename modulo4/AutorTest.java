import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    // INSTÂNCIAS DE SUPORTE ATUALIZADAS PARA USAR O NOVO CONSTRUTOR
    // Simulando Autor Tradicional (isUsuario = false)
    Autor autor = new Autor("Jess", "Brasileira", false); 
    // Simulando Autor que também é Usuário (isUsuario = true)
    Autor usuarioAutor = new Autor("Lucas", "Italiano", true);
    
    // Instâncias de Livro (dependem do construtor acima)
    Livro livro1 = new Livro("Java Basico", autor, "tecnologia", true);
    Livro livro2 = new Livro("Java Avancado", autor, "tecnologia", false);

    // Método 1: Teste do Construtor e Getters (INCLUI TESTE DO NOVO CAMPO)
    @Test
    void testConstrutorEGetters() {
        assertEquals("Jess", autor.getNome());
        assertEquals("Brasileira", autor.getNacionalidade());
        
        // Testa o novo campo 'isUsuario'
        assertFalse(autor.isUsuario()); 
        
        // Testa o construtor com valor true
        assertTrue(usuarioAutor.isUsuario());
        
        assertNotNull(autor.getObrasPublicadas()); 
    }
    
    // NOVO TESTE PARA COBRIR O CAMPO ADICIONADO (Ponto 2 da atividade)
    @Test
    void testSetIsUsuario() {
        // O Autor 'Jess' começa como false
        assertFalse(autor.isUsuario()); 
        
        // Altera o status usando o setter
        autor.setIsUsuario(true);
        
        // Verifica a alteração
        assertTrue(autor.isUsuario());
    }

    // Método 2: Teste do adicionarObra()
    @Test
    void testAdicionarObra() {
        // Este método não precisa de alteração
        autor.adicionarObra(livro1);
        autor.adicionarObra(livro2);

        List<Livro> obras = autor.getObrasPublicadas();
        
        assertEquals(2, obras.size()); 
        assertTrue(obras.contains(livro1));
        assertTrue(obras.contains(livro2));
    }

    // Método 3: Teste do setNacionalidade()
    @Test
    void testSetNacionalidade() {
        // Este método não precisa de alteração
        autor.setNacionalidade("Portuguesa");
        assertEquals("Portuguesa", autor.getNacionalidade());
    }

    // Método 4: Teste do setNome()
    @Test
    void testSetNome() {
        // Este método não precisa de alteração
        autor.setNome("Jessica");
        assertEquals("Jessica", autor.getNome());
    }
}

