import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtigoTest {

    // Instância de Autor usando o novo construtor
    Autor autorArtigo = new Autor("Ada Lovelace", "Britânica", false); 

    @Test
    void testConstrutorEGetters() {
        // Artigo artigo = new Artigo("Entendendo Compiladores", autor, "tecnologia", true);
        Artigo artigo = new Artigo("Entendendo Compiladores", autorArtigo, "tecnologia", true);

        // Verifica os valores configurados pelo construtor
        assertEquals("Entendendo Compiladores", artigo.getTitulo());
        assertEquals("tecnologia", artigo.getGenero());
        assertEquals(autorArtigo, artigo.getAutor());
        assertTrue(artigo.isPublicado());
    }

    @Test
    void testSetPublicado() {
        Artigo artigo = new Artigo("Outro Artigo", autorArtigo, "ciencia", false);
        
        // Verifica o estado inicial
        assertFalse(artigo.isPublicado()); 

        // Altera o estado e testa
        artigo.setPublicado(true);
        assertTrue(artigo.isPublicado());
    }
}

