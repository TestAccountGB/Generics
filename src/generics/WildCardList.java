package generics;

import java.util.ArrayList;
import java.util.List;
import classes.Funcionario;
import classes.Gerente;
import classes.Pessoa;
import classes.Pessoa2;

public class WildCardList {
	public static void main(String[] args) {
		
		//O que significa WildCard? Em uma traducao literal significa o curinga do baralho, e como isso se aplica no Java?
		//Vamos ver na pratica...
		
		List<Funcionario> funcionarioList = new ArrayList<>();
		List<Gerente> gerenteList = new ArrayList<>();
		List<Pessoa> pessoaList = new ArrayList<>();
		
		Funcionario pessoa = new Funcionario("Augusto", 2000);
		Funcionario pessoa0 = new Funcionario("Cesar", 3000);
		Gerente gerente = new Gerente("Augusto so que Gerente", 3000, 1500);
		Gerente gerente0 = new Gerente("Cesar so que Gerente", 4000, 2000);
		
		funcionarioList.add(pessoa);
		funcionarioList.add(pessoa0);
		gerenteList.add(gerente);
		gerenteList.add(gerente0);
		
//		sysoutPessoa(funcionarioList);
//		sysoutPessoa(gerenteList);
		
		//Por que nao funciona como o "MetodoGenericoArray"? Porque em uma lista nao tem como criar tipo um array
		//De pessoa e colocar todas as subclasses la, quando a gente cria um ArrayList de pessoa ele espera que apenas
		//Pessoas vao estar la, ele nao aceita subclasses, por que nao? Porque para que ele crie um ArrayList ele precise
		//Que todos os conteudos dentro dele tenham os mesmos metodos, mas entao nao podemos colocar 
		//Pessoa pessoa = new Funcionario? Sim, mas vamos perder metodos como setters e getters que nao estao na
		//Interface Pessoa, podemos criar um metodo com o WildCard, como usa isso? Vamos ver!!
		
		sysoutPessoaWildCard(funcionarioList);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		sysoutPessoaWildCard(gerenteList);
		
		Pessoa pessoaTest = new Funcionario("Augusto", 2000);
		Pessoa gerenteTest = new Gerente("Augusto so que Gerente", 3000, 1500);
		
		pessoaList.add(pessoaTest);
		pessoaList.add(gerenteTest);
		
		sysoutPessoaWildCard(pessoaList);
		
		//Se ainda estiver bastante confuso, recomendo dar uma olhada em polimorfismo entre superclasses e subclasses,
		//E como funciona seus casts, metodos etc. E tente fazer exercicios usando listas
	}
	
	public static void sysoutPessoa(List<Pessoa> pessoaList) {
		for(Pessoa pessoa : pessoaList) {
			System.out.println(pessoa.mostrarInformacoes());
		}
	}
	
	public static void sysoutPessoaWildCard(List<? extends Pessoa> pessoaList) {//O que a gente ta fazendo aqui? Qual e
		//A carta curinga? A carta curinga e o proprio ponto de interrogacao, ou seja, ele vai aceitar qualquer coisa, mas
		//Depois da interrogacao colocamos uma condicao, que foi o "extends Pessoa", ou seja, toda list que for usar esse
		//Metodo, precisa extender Pessoa, ue, mas Pessoa nao e uma interface? Sim, mas nao podemos usar a palavra
		//"implements" no generic, mas podemos usar o extends tanto pra classe e interface.
		
		for(Pessoa pessoa : pessoaList) {
			System.out.println(pessoa.mostrarInformacoes());
		}
		
		//Funcionario funcionario = new Funcionario("Funcionario", 2000);
		//pessoaList.add(funcionario);
		
		//Por que nao podemos adicionar um Funcionario na List, mesmo que ela implementa Pessoa? Porque o java nao
		//Tem certeza de que a gente vai adicionar objetos que tem os mesmos atributos ou pelo menos compativeis,
		//Mas como a gente arruma isso? Podemos usar a palavra "super", para que ai assim o java vai ter a certeza que
		//As classes sao compativeis, imagine assim, temos a classe que tem 4 atributos e 2 sao da superclasse, ou seja,
		//Vamos poder adicionar a lista, uma classe que tem 4 atributos no maximo e suas superclasses, e assim
		//Podemos ter a certeza de que tudo que vamos adicionar vai ser "compativel", mas se a gente quiser colocar
		//Outra classe que extende dessa superclasse, essa pode ter 5 atributos, ai ja nao vai ser compativel, por isso
		//O Java nao tem a certeza, ou seja, nao podemos colocar classes com diferentes numeros de atributos, apenas
		//Se eles for iguais ou menores, maiores nao podem, porque assim as classes que tem menos atributos
		//Vao ficar com null, e as que tem mais atributos o java nao vai conseguir botar na List. Ficou confuso? Ate eu to
		//kkk, mas olhe o exemplo abaixo, pra ajudar 2% a mais
	}
	
	//Esse metodo e apenas de test, nao use ela
	public static void sysoutPessoaOrFuncionario(List<? super Funcionario> list) {//Ou seja, ele vai aceitar Funcionario
		//E suas superclasses (Pessoa2), mas nao vai aceitar outras classes que extendem de Pessoa2
		
		@SuppressWarnings("unused")
		Gerente gerente = new Gerente("Gerente", 1500, 2000);
		Funcionario funcionario = new Funcionario("Funcionario", 2000);
		Pessoa2 pessoa = new Pessoa2();
		
		//Agora o java deixa a gente adicionar
		list.add(funcionario);
		//Podemos usar o cast de classe como foi mostrado no Polimorfismo
		list.add((Funcionario) pessoa);
		//list.add(gerente);
		//Gerente nao funciona, porque ele nao e nenhuma super classe de Funcionario e nao e Funcionario
		
		//E como ta no seus parametros, aceitamos um Funcionario e todas as suas superclasses, e quais sao suas
		//Superclasses? "Pessoa2" e "Object", porque como que voce sabe todas as classes sao filhas de "Object"
		List<Pessoa2> test = null;
		List<Funcionario> test2 = null;
		List<Object> test3 = null;
		@SuppressWarnings("unused")
		List<Gerente> test4 = null;
		sysoutPessoaOrFuncionario(test);
		sysoutPessoaOrFuncionario(test2);
		sysoutPessoaOrFuncionario(test3);
		//sysoutPessoaOrFuncionario(test4);
		//Com gerente nao funciona
	}
	
}
