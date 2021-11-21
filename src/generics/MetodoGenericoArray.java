package generics;

import classes.Funcionario;
import classes.Gerente;
import classes.Pessoa;

public class MetodoGenericoArray {
	public static void main(String[] args) {
		
		Funcionario[] arrayFuncionario = {new Funcionario("Augusto", 2000), new Funcionario("Cesar", 3000)};
		Gerente[] arrayGerente = {new Gerente("Augusto so que Gerente", 3000, 1500), new Gerente("Cesar so que "
				+ "Gerente", 4000, 2000)};
		
		sysoutPessoa(arrayFuncionario);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		sysoutPessoa(arrayGerente);
		//Por que isso funciona? Porque em um array podemos criar um array de uma SuperClasse ou interfaces e criar
		//Subclasses dentro deles, assim...
		
		Pessoa[] pessoa = {arrayFuncionario[0], arrayGerente[0]};
		
		//E assim ele consegue puxar o metodo de boa, porque eles vao ter os metodos de Pessoa
		pessoa[0].mostrarInformacoes();
		pessoa[1].mostrarInformacoes();
		//Ele esta fazendo isso
	}
	
	public static void sysoutPessoa(Pessoa[] pessoas) {
		for(Pessoa pessoa : pessoas) {
			System.out.println(pessoa.mostrarInformacoes());
		}
	}
}
