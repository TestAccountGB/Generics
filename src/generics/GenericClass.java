package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {
	public static void main(String[] args) {
		
		//O que e uma classe generica? E uma classe onde ela aceita varios tipos de outras classes que queremos dar o
		//Mesmo tratamento, como assim? Imagine que a gente tenha que escrever um codigo onde a gente alugue um
		//Computador e um carro, o processo de alugar vai ser diferente, claro, mas o processo de por exemplo, adicionar,
		//Mostrar, remover de uma List, vai ser o exato mesmo codigo, a unica diferenca vai ser o tipo, como List<Carro> e
		//List<Computador>, entao para poupar linhas de codigo e memoria usamos uma classe generica que vai fazer
		//Essas tarefas, vamos ver na pratica que vai ficar muito mais facil de entender...
		
		System.out.println("Carro\n");
		List<Carro> carros = new ArrayList<>();
		//Possivelmente iriamos receber os objetos de um banco de dados, mas como eu nao tenho, vou criar 2 objetos
		//Pra brincar
		Carro carro = new Carro("BMW", "X1");
		Carro carro2 = new Carro("Mercedes", "A 200");
		carros.add(carro);
		carros.add(carro2);
		RentObjects<Carro> rentCar = new RentObjects<>(carros);//Dentro do diamonds botamos o tipo que vai ser e ele vai
		//Substituir todos os "T" da classe "RentObjects" pela classe "Carro" enquanto o codigo roda
		
		Carro carroAlugado = rentCar.rentAnObject();//Ele vai retornar um carro, pois todos os T sao substituidos pelo tipo
		//Que passa no diamond
		
		System.out.println("Usando o objeto: " + carroAlugado);
		System.out.println("Acabou o tempo :(\nDevolvendo o objeto...");
		
		//Imagine que ja acabou o tempo do alugamento kkk, e quero devolver o objeto
		rentCar.addAnRentableObject(carroAlugado);
		
		//E sabe o que e o mais incrivel? Agora o codigo base ja ta feito, podemos apenas trocar o tipo no diamonds que vai
		//Funcionar, imagine escrever esses metodos em todos as classes? O codigo ia ficar MUITO grande, mas claro,
		//Tenha em mente que so criamos classes genericas, para as classes que vamos dar o MESMO tratamento, vamos
		//Trocar pra computador pra fazer o teste...
		
		System.out.println("\n--------Computador--------\n");
		List<Computador> computadores = new ArrayList<>();
		
		Computador computador = new Computador("LG", "A530");
		Computador computador2 = new Computador("Asus", "X543");
		
		computadores.add(computador);
		computadores.add(computador2);
		
		RentObjects<Computador> rentPc = new RentObjects<>(computadores);
		//So mudamos a classe no diamonds
		
		Computador computadorAlugado = rentPc.rentAnObject();
		
		System.out.println("Usando o objeto: " + computadorAlugado);
		System.out.println("Acabou o tempo :(\nDevolvendo o objeto...");
		rentPc.addAnRentableObject(computadorAlugado);
		
		//Testando nossa condicao...
		
		//RentObjects<String> test;//Podemos ver que funciona, so aceita classes que extendem de "Super"
		
		//Obs.: Metodos genericos dentro de classes nao genericas
		//Como voce pode ver a nossa GenericClass nao e uma classe generica, mas podemos fazer um metodo generico
		//Desse jeito...
		
		System.out.println("\nTest...");
		metodoGenericoAleatorioVoid(2);
		double numero = (double) metodoGenericoAleatorioNoVoid(4);
		System.out.println(numero);
	}
	
////////////////////////////////////////////////////Apenas pra teste
	
	//Precisamos colocar nosso T no metodo mesmo eu sei que parece estranho, mas e assim mesmo .-.
	//Precisamos fazer isso pois nossa classe nao e uma classe generica e nao tem o T
	public static <T extends Number> void metodoGenericoAleatorioVoid(T a){
		System.out.println(a);
	}
	
	public static <T extends Number> T metodoGenericoAleatorioNoVoid(T a){
		return a;
	}
	//Tenha em mente que o <T extends Number> nao e o tipo do retorno e apenas o nosso T (type)
////////////////////////////////////////////////////Apenas pra teste
}

/////////////////////////Classes...

class Computador extends Super {
	
	public Computador(String nome, String modelo) {
		super(nome, modelo);
	}
	
}

class Carro extends Super {
	
	public Carro(String nome, String modelo) {
		super(nome, modelo);
	}
	
}

/////////////////Superclasse apenas pra economizar linha...

abstract class Super {//Apenas pra servir de modelo, pois as duas classes vao ser iguais no meu exemplo :)
	private String nome;
	private String modelo;
	
	public Super(String nome, String modelo) {
		this.nome = nome;
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", Modelo: " + getModelo();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}

/////////////////////Classe Generica...

class RentObjects<T extends Super> {
	//Aqui e nossa classe generica, e o que o "T" dentro dos diamonds significa? E o nosso tipo, sabe o List
	//Quando a gente cria ele, a gente bota List<String>, ali a gente bota o tipo que vai ser, aqui e a mesma coisa, mas ali
	//Eu botei uma condicao que o nosso T (tipo/type), precisa extender a classe Super, assim, nao vou deixar ele criar
	//Essa classe, como por exemplo de String (RentObject<String>) xD
	
	//Muda alguma coisa se eu mudar o nome do T? Nao, e como uma variavel, voce bota o nome que quiser, mas no java
	//Nos temos uma boa pratica de botar o T quando se trata de tipo, segue uma lista abaixo de outras praticas...
	
	/*
	 * T is meant to be a Type
	 * E is meant to be an Element (List<E>: a list of Elements)
	 * K is Key (in a Map<K,V>)
	 * V is Value (as a return value or mapped value)
	 */
	
	//Obs.: Tambem podemos botar mais de um elemento como:
	//class RentObjects<T, X> , mas tome cuidado a fazer isso:
	//<T, X extends Super>, so vai valer pro X, para fazer uma condicao pro T tambem, precisamos fazer isso:
	//<T extends Super, X extends Super>, podemos colocar condicoes diferentes :)
	
	private List<T> rentableObjects;
	//Viu o poder de uma classe generica? Aqui vamos criar uma lista que vamos receber todos os objetos que podem ser
	//Alugados, se esse fosse um caso real, iriamos receber os objetos de um banco de dados, por isso criamos um
	//Construtor abaixo para receber esses objetos
	
	//Vou falar uma coisa antes, viu que a gente ta colocando List e nao ArrayList? Por que? Porque assim nossa classe vai
	//Aceitar todos os tipos de LIst, essa e a importancia de trabalhar com interfaces e superclasses, polimorfismo no
	//Geral
	
	public RentObjects(List<T> rentableObjects) {
		this.rentableObjects = rentableObjects;
	}
	//Aqui no construtor vamos receber o T, que por enquanto so pode ser 2 classes, Carro e Computador, pois elas
	//Extendem Super
	
	public T rentAnObject() {//Aqui vamos retornar um objeto T, pode ser Carro ou Computador (Que bagulho incrivel)
		
		//Como eu to com preguica de usar algo mais elaborado, vamos colocar que vamos sempre alugar o primeiro
		//Elemento da lista xD
		
		if(rentableObjects.isEmpty()) {
			return null;
		}
		
		T object = rentableObjects.remove(0);//Caso voce nao saiba, o remove pode retornar o objeto removido, ou seja,
		//Aqui estamos "alugando" o primeiro objeto e vamos remover da lista, pois ele vai estar alugado, tendeu?
		
		System.out.println("Objeto alugado: " + object.getNome());
		System.out.print("Objetos disponiveis: ");
		for(T object2 : rentableObjects) {//Foreach pra ficar bonitinho, tambem podemos usar o T no foreach :0
			System.out.println(object2.getNome());//Como as classes sempre vao extender a classe Super, logo 
			//Todas as classes vao ter o metodo "getNome()". Como o java e incrivel :0
		}
		
		return object;
	}
	
	public void addAnRentableObject(T object) {//Podemos tambem receber um objeto T
		
		System.out.println("Adicionando objeto...");
		rentableObjects.add(object);
		System.out.println("Objetos disponiveis: " + rentableObjects);
	}
}

//Se quiser um video e tambem mais conhecimentos sobre generics olhe o link:
//https://www.youtube.com/watch?v=VIce-6b7kas&ab_channel=EduardoGuerra

//Mas vou logo avisando que normalmente se tratando de generics, voce so vai usar basicamente mexendo com Lists
//Ou usando tudo que eu mostrei acima, mas se quiser aprender mais ou ainda estiver com duvida, olhe o video acima
