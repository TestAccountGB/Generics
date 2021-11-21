package classes;

public class Gerente implements Pessoa {
	
	private String nome;
	private double salario;
	private double pnl;
	
	public Gerente(String nome, double salario, double pnl) {
		this.nome = nome;
		this.salario = salario;
		this.pnl = pnl;
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
	
	public double getPnl() {
		return pnl;
	}

	public void setPnl(double pnl) {
		this.pnl = pnl;
	}
	
	@Override
	public String mostrarInformacoes() {
		return "GerenteBurguês - Nome: " + nome + ", Dinero kk: " + salario + ", Pnl: " + pnl + "\nTotal: " + (salario+pnl);
	}

}
