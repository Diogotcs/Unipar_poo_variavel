public class ContaCorrente {
    private double saldo;

    public ContaCorrente() {
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean saque(double valor) {
        double taxa = 5;
        double valorTotal = valor + taxa;

        if (valor > 0 && this.saldo >= valorTotal) {
            this.saldo -= valorTotal;
            return true;
        }
        return false;
    }

    public double obterSaldo() {
        return this.saldo;
    }
}


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContaCorrenteTest {

    private ContaCorrente conta;

    @Before
    public void setUp() {
        conta = new ContaCorrente();
    }

    @Test
    public void testDeposito() {
        conta.depositar(1000d);
        assertEquals(1000, conta.obterSaldo(), 0);
    }

    @Test
    public void testSaqueSucesso() {
        conta.depositar(1000d);
        boolean validacao = conta.saque(500d);
        assertTrue(validacao);
        assertEquals(495, conta.obterSaldo(), 0);
    }

    @Test
    public void testSaqueMaiorSaldoContaCorrente() {
        conta.depositar(3000d);
        boolean validacao = conta.saque(4500d);
        assertFalse(validacao);
        assertEquals(3000, conta.obterSaldo(), 0);
    }

    @Test
    public void testSaqueInvalido() {
        conta.depositar(3000d);
        boolean validacao = conta.saque(2996d);
        assertFalse(validacao);
        assertEquals(3000, conta.obterSaldo(), 0);
    }
}
