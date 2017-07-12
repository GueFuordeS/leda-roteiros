package adt.bst.extended;

import adt.bst.BST;

/**
 * BST que contem um metodo para calcular a profundidade minima da arvore. 
 * A profundidade minima eh o tamanho do menor caminho entre a raiz e uma 
 * folha da arvore. Pode tambem ser entendida como a menor distancia entre 
 * a raiz e uma folha.
 * @author Adalberto
 *
 * @param <T>
 */
public interface MinimumDepthtBST<T extends Comparable<T>> extends BST<T> {
	/**
	 * Retorna a altura minima da arvore. Se a arvore eh vazia ou se a raiz eh
	 * folha entao retorna 0. Caso contrario retorna a minima distancia 
	 * entre a raiz e uma folha. Note que, se a raiz so tem um filho entao a 
	 * profundidade minima eh calculada nesse filho (o filho inexistente eh ignorado)
	 * 
	 * Restricoes:
	 *  - Seu algoritmo deve ter complexidade O(n)
	 *  - Seu algoritmo deve ser recursivo
	 * @return
	 */
	public int minimumDepth();
		
}
