package classes;

public class Funcionario extends Pessoa2 implements Pessoa {
	
	private String nome;
	private double salario;
	
	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String mostrarInformacoes() {
		return "FuncionarioFudido - Nome: " + nome + ", Dinero kk: " + salario;
	}

	@Override
	public String mostrarInformacoes2() {
		return "FuncionarioFudido - Nome: " + nome + ", Dinero kk: " + salario;
	}
}
