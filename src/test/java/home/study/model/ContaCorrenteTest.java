package home.study.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContaCorrenteTest implements ContaInterface {

	private double saldo;
	private double limite;

	public ContaCorrenteTest() {
		this.saldo = 0;
		this.limite = 0;
	}

	public void sacar(double valor) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (valor < 0) {
			throw new IllegalArgumentException("Valor de saque negativo.");
		} else if (valor > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		} else if (valor > limite) {
			throw new IllegalArgumentException("Limite de saque excedido.");
		}
		
		this.saldo -= valor;
		System.out.println("Saque de R$ "+valor+" realizado com sucesso.");
	}

	public void depositar(double valor) {
		// TODO Auto-generated method stub
		if(valor <= 0){
			throw new IllegalArgumentException("Valor de depósito inválido.");
		}
		this.saldo += valor;
		System.out.println("Depósito de R$ "+valor+" realizado com sucesso.");
	}

	/**
	 * Calcula Fatorial
	 * */
	public int fatorial(int i) {
		int result = 1;

		if (i < 0) {
			throw new IllegalArgumentException("Não existe fatorial negativo.");
		}

		if (i < 2 && i >= 0) {
			return 1;
		}

		for (int j = i; j > 0; j--) {
			result *= j;
		}

		return result;
	}

	/**
	 * Testes do sacar
	 * */
	
	@Test
	public void testarSacar(){
		this.setSaldo(100);
		this.setLimite(40);
		this.sacar(35);
		assertEquals(65,this.saldo,0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenUseNegativeNumberToSacar() {
		this.sacar(-100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenValorParaSacarMaiorQueSaldo() {
		this.sacar(100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenValorParaSacarMaiorQueLimite() {
		this.setLimite(500);
		this.sacar(1000);
	}

	/**
	 * Testes do Deposito
	 * */
	
	@Test(expected=IllegalArgumentException.class)
	public void whenDepositarValorMenorOuIgualAZero(){
		this.depositar(-500);
		this.depositar(0);
		assertEquals(0,this.saldo,0.0001);
	}
	
	@Test
	public void whenDepositar(){
		this.depositar(500);
		assertEquals(500,this.saldo,0.0001);
	}
	
	/**
	 * Testes do Fatorial
	 * */

	@Test(expected = IllegalArgumentException.class)
	public void testaFatorialNegativo() {
		assertEquals(-120, fatorial(-5));
	}

	@Test
	public void shouldReturnOneWhenZero() {
		assertEquals(1, fatorial(0));
	}

	@Test
	public void shouldReturnOneWhenOne() {
		assertEquals(1, fatorial(1));
	}

	@Test
	public void shouldReturnTwo() {
		assertEquals(2, fatorial(2));
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}