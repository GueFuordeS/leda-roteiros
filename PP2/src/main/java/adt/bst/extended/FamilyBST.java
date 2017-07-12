package adt.bst.extended;

import adt.bst.BST;

/**
 * BST que verifica propriedades de nos: se sao primos em primeiro grau 
 * ou se sao primos em segundo grau. 
 * @author Adalberto
 *
 * @param <T>
 */
public interface FamilyBST<T extends Comparable<T>> extends BST<T> {

	/**
	 * Diz se dois elementos de uma BST sao primos em primeiro grau.
	 * Pense nas condicoes para estabelecer essa restricao e implemente.
	 * 
	 * @param elem1
	 * @param elem2
	 * @return
	 */
	public boolean primosPrimeiroGrau(T elem1, T elem2);
	
	/**
	 * Diz se dois elementos de uma BST sao primos em segundo grau.
	 * Pense nas condicoes para estabelecer essa restricao e implemente.
	 * Dica: primos em primeiro grau de nossos pais sao nossos primos 
	 * em segundo grau.
	 * 
	 * @param elem1
	 * @param elem2
	 * @return
	 */
	public boolean primosSegundoGrau(T elem1, T elem2);
	
}
