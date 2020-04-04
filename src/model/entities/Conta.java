package model.entities;

import model.exception.ContaException;

public class Conta {

	private Integer numero;
	private String correntista;
	private Double saldo;
	private Double limiteSaque;

	public Conta() {

	}

	public Conta(Integer numero, String correntista, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.correntista = correntista;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCorrentista() {
		return correntista;
	}

	public void setCorrentista(String correntista) {
		this.correntista = correntista;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(Double deposito) {
		this.saldo += deposito;
	}
	
	@Override
	public String toString() {
		return "Conta [numero= " + numero + ", correntista= " + correntista + ", saldo= " + saldo + ", limiteSaque= "
				+ limiteSaque + "]";
	}

	public void saque(Double saque) throws ContaException {
		if (saque > this.limiteSaque) {
			throw new ContaException("Valor excede ao limite de saque de ->" + this.limiteSaque);
		} else if (saque > this.saldo) {
			throw new ContaException("Valor excede ao saldo ->" + this.saldo);
		} else {
			this.saldo -= saque;
		}
	}

}
