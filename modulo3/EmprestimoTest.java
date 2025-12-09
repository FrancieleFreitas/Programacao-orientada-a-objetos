import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoTest {

    // Instâncias pré-definidas (Datas)
    Calendar cal = Calendar.getInstance();
    Date dataRetirada = cal.getTime();

    // Define dataDevolucao 15 dias no futuro para a previsão
    cal.add(Calendar.DAY_OF_MONTH, 15);
    Date dataDevolucaoPrevista = cal.getTime();

    // Instâncias pré-definidas (Objetos)
    Autor autor = new Autor("Alan Turing", "Inglês");
    Livro livro = new Livro("Java Basics", autor, "Tecnologia", true);
    Usuario usuario = new Usuario("Gabriel", 21);

    // Instância do Emprestimo que será testada
    Emprestimo emprestimo = new Emprestimo(dataRetirada, dataDevolucaoPrevista, livro, usuario);

    // Método 1: Teste do Construtor
    @Test
    void testConstrutor() {
        assertEquals(dataRetirada, emprestimo.getDataRetirada());
        assertEquals(dataDevolucaoPrevista, emprestimo.getDataDevolucaoPrevista());
        assertEquals(livro, emprestimo.getLivro());
        assertEquals(usuario, emprestimo.getUsuario());
        assertNull(emprestimo.getDataDevolucaoReal()); // Data de devolução real deve ser nula inicialmente
    }
    
    // Método 2: Teste do registro de Empréstimo (Verifica o status do Livro)
    @Test
    void testRegistroEmprestimo() {
        // Ao construir, o Livro DEVE ter sido marcado como indisponível
        assertFalse(livro.isDisponivel());
    }

    // Método 3: Teste do registro de Devolução (Atualiza datas e status)
    @Test
    void testRegistrarDevolucao() {
        // 1. Simula a devolução
        Calendar calDevolucao = Calendar.getInstance();
        Date dataDevolucaoReal = calDevolucao.getTime();
        
        // Assume-se que o método registrarDevolucao() define a data e atualiza o livro.
        emprestimo.registrarDevolucao(dataDevolucaoReal); 

        // Verifica se a data de devolução real foi registrada
        assertEquals(dataDevolucaoReal, emprestimo.getDataDevolucaoReal());
        
        // Verifica se o Livro foi marcado como disponível
        assertTrue(livro.isDisponivel());
    }

    // Método 4: Teste de vencimento (Simula um cenário onde a devolução não ocorreu na data prevista)
    @Test
    void testVencido() {
        // Simula a data atual após a data de devolução prevista (ex: 20 dias depois)
        Calendar calVencimento = Calendar.getInstance();
        calVencimento.add(Calendar.DAY_OF_MONTH, 20); 
        Date hojeVencido = calVencimento.getTime();
        
        // Assume-se um método que verifica se o empréstimo está vencido
        assertTrue(emprestimo.estaVencido(hojeVencido));
        
        // Se o livro foi devolvido, não deve estar vencido
        emprestimo.registrarDevolucao(hojeVencido);
        assertFalse(emprestimo.estaVencido(hojeVencido));
    }
}

