package adt.bt;

import adt.bst.BSTNode;

public class Util {

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = null;

		if(!node.isEmpty()) {
			pivot = (BSTNode) node.getRight();
			pivot.parent = node.parent;
			node.parent = pivot;
			node.right = pivot.getLeft();
			pivot.left = node;
		}

		return pivot;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = null;
		
		if(!node.isEmpty()) {
			pivot = (BSTNode) node.getLeft();
			pivot.parent = node.parent;
			node.parent = pivot;
			node.left = pivot.getRight();
			pivot.right = node;
		}

		return pivot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}