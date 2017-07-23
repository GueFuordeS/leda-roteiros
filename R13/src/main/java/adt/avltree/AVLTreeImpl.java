package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int retorno = 0;
		
		if (node != null && !node.isEmpty()) {
			BSTNode<T> nodeLeft = (BSTNode<T>) node.getLeft();
			BSTNode<T> nodeRight = (BSTNode<T>) node.getRight();
			retorno = super.height(nodeLeft) - super.height(nodeRight);
		}
		
		return retorno;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);

		if (balance > 1) {
			if (this.calculateBalance((BSTNode<T>) node.getLeft()) < -1)
				Util.leftRotation((BSTNode<T>) node.getLeft());
			Util.rightRotation(node);
		} else if (balance < -1) {
			if (this.calculateBalance((BSTNode<T>) node.getRight()) > 1)
				Util.rightRotation((BSTNode<T>) node.getRight());
			Util.leftRotation(node);
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			this.rebalance(node);
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
}