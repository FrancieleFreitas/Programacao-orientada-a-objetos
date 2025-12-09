import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    // Instâncias de suporte
    Usuario usuarioMenor = new Usuario("Lucas", 16);
    Usuario usuarioMaior = new Usuario("Gabriel", 21);
    
    Autor autor = new Autor("Anonimo", "N/A");

    // Livro impróprio para menores (Gênero 'Terror')
    Livro livroRestrito = new Livro("Misterios", autor, "Terror", true); 
    // Livro adequado (Gênero 'Tecnologia')
    Livro livroAdequado = new Livro("POO", autor, "Tecnologia", true); 
    
    // Método 1: Teste do Construtor e Getters
    @Test
    void testConstrutorEGetters() {
        assertEquals("Gabriel", usuarioMaior.getNome());
        assertEquals(21, usuarioMaior.getIdade());
        assertNotNull(usuarioMaior.getHistoricoEmprestimos());
        assertTrue(usuarioMaior.getHistoricoEmprestimos().isEmpty());
    }
    
    // Método 2: Teste de Apto para Empréstimo (Idade e Gênero)
    @Test
    void testVerificarAptoEmprestimo_IdadeGenero() {
        // Usuario MAIOR de idade (21) pegando livro RESTRITO (Terror) -> DEVE ser apto
        assertTrue(usuarioMaior.verificarAptoEmprestimo(livroRestrito));

        // Usuario MENOR de idade (16) pegando livro RESTRITO (Terror) -> NÃO DEVE ser apto
        assertFalse(usuarioMenor.verificarAptoEmprestimo(livroRestrito));

        // Usuario MENOR de idade (16) pegando livro ADEQUADO (Tecnologia) -> DEVE ser apto
        assertTrue(usuarioMenor.verificarAptoEmprestimo(livroAdequado));
    }

    // Método 3: Teste de Apto para Empréstimo (Com Livros Vencidos)
    // OBS: Assume-se que um método para adicionar empréstimo ao histórico e verificar vencimento existe
    @Test
    void testVerificarAptoEmprestimo_ComVencidos() {
        // Adiciona um empréstimo VENCIDO (assumimos que o objeto Emprestimo tem o status 'vencido')
        Emprestimo emprestimoVencido = new Emprestimo(new Date(), new Date(), livroAdequado, usuarioMaior);
        emprestimoVencido.setStatusVencido(true); // Método que simula o vencimento
        usuarioMaior.adicionarEmprestimoAoHistorico(emprestimoVencido);

        // Se o usuário tem livro vencido, NÃO DEVE ser apto
        assertFalse(usuarioMaior.verificarAptoEmprestimo(livroAdequado));

        // Tira o empréstimo vencido (ou muda o status)
        emprestimoVencido.setStatusVencido(false);
        
        // Agora DEVE ser apto
        assertTrue(usuarioMaior.verificarAptoEmprestimo(livroAdequado));
    }
}

