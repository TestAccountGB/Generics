package generics;

import java.util.ArrayList;
import java.util.List;

public class Explicacao {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		//O que sao generics? Imagine essa situacao... Temos uma lista e la so queremos botar String para nao ter problemas
		//Que tipo de problemas? Esses...
		
		List lista = new ArrayList();

		lista.add(12);
		lista.add("Augusto");
		lista.add(new Explicacao());
		
		//Como podemos ver, conseguimos adicionar todo tipo de bagulho dentro dai, mas normalmente um progamador
		//Nunca vai criar uma lista pra usar dois tipos nelas, mesmo nao tendo um tipo especifico pra ela, ele nunca vai
		//Botar varios tipos dentro dela, por que? Por que quando ele for mecher dentro da lista ele vai ter que fazer
		//Algo mais ou menos assim...
		
		for(Object obj : lista) {//Por que Object? Porque nao sabemos que tipo de arquivo tem ai
			if(obj instanceof String)
				System.out.println(obj);
			if(obj instanceof Integer)  //Quando temos apenas um comando depois do if, nao precisamos usar as chaves
				System.out.println(obj);
			if(obj instanceof Explicacao)
				System.out.println("Pode nao");
		}
		
		//Ta vendo a merda? Mas ue, se normalmente o progamador nunca vai usar outro tipo de arquivo na lista, entao qual
		//E o problema de nao especificar o tipo? Se ta ligado que existe todo tipo de ser humano e um grupo de
		//Progamadores pode nao se comunicar muito e um acabar fazendo merda, tendeu? Imagine isso usando em uma
		//Collection do tipo map kkk
		
		//Entao por isso o java criou o generics, mas claro, como o java pensa na retrocompatibilidade, eles tinham que
		//Pensar em um jeito de funcionar pra todas as versoes, entao por isso generics apenas checa no tempo de execucao
		//Como assim?
		
		ArrayList<String> listString = new ArrayList<String>();//Os "diamonds" sao as generics, depois do java 7 nao precisamos
		//Mais repitir o tipo novamente, fazer como ta o codigo acima, e redundante.
		
		//listString.add(2);//Como pode ver ele nao me deixa adicionar outro tipo, porque a List<String>, so tem UM metodo
		//add, ele nao e sobrecarregado e ele so aceita Strings, o mesmo pra outros tipos
		
		listString.add("Augusto");
		listString.add("Otsugua");
		
		add(listString, 12);//Se voce rodar o codigo voce vai ver que nao deu nenhum erro ao adicionar
		
		//for(String string : listString) {//Claramente vai dar erro, mas se a gente colocar "Object" no lugar de String vai
			//Funcionar? Sim, mas ai ja e problema do progamador, quando ele for fazer o loop for com o TIPO CERTINHO
			//Da Collection ele vai ver que deu uma exececao e vai sacar o erro na hora
			
			//System.out.println(string);
		//}
		
		//Type Erasure
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void add(List list, Integer numero) {
		
		list.add(numero); //O que vai acontecer aqui? Como nosso parametro e uma lista que aceita qualquer coisa, a gente
		//Consegue colocar qualquer coisa, entao se eu passar uma list de String como argumento, ele vai adicionar um
		//Numero? Sim, por que? Porque a generic so roda em tempo de execucao, ou seja, ele so vai fazer a vereficacao
		//Quando a gente for mexer diretamente com ela, como um loop for, esse foi um jeito que o Java conseguiu manter
		//A retrocompatibilidade
		
	}
}
