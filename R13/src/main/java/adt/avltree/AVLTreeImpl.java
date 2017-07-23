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
		if (node != null && !node.isEmpty()) {
			boolean isRoot = false;
			if (node.getParent().isEmpty()) {
				isRoot = true;
			}
			int balance = this.calculateBalance(node);
	
			if (balance > 1) {
				if (super.height((BSTNode<T>)node.getLeft().getLeft()) > -1
						|| super.height((BSTNode<T>)node.getLeft().getRight()) > 0) {
					if (this.calculateBalance((BSTNode<T>) node.getLeft()) < -1)
						Util.leftRotation((BSTNode<T>) node.getLeft());
					if (isRoot) {
						this.root = Util.rightRotation(node);
					}
					else {
						if (this.isChildPerLeft(node)) {
							node.getParent().setLeft(Util.rightRotation(node));
						}
						else {
							node.getParent().setRight(Util.rightRotation(node));
						}
					}
				}
			} else if (balance < -1) {
				if (super.height((BSTNode<T>)node.getRight().getRight()) > -1
						|| super.height((BSTNode<T>)node.getRight().getLeft()) > 0) {
					if (this.calculateBalance((BSTNode<T>) node.getRight()) > 1)
						Util.rightRotation((BSTNode<T>) node.getRight());
					if (isRoot) {
						this.root = Util.leftRotation(node);
					}
					else {
						if (this.isChildPerLeft(node)) {
							node.getParent().setLeft(Util.leftRotation(node));
						}
						else {
							node.getParent().setRight(Util.leftRotation(node));
						}
					}
				}
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			this.rebalance(node);
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
	
	private boolean isChildPerLeft(BSTNode<T> node) {
		boolean retorno = false;
		if (node != null && !node.isEmpty()) {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			if (parent.getLeft().equals(node)) {
				retorno = true;
			}
		}
		return retorno;
	}

	public static void main(String[] args) {
		AVLTreeImpl<Integer> avl = new AVLTreeImpl<>();
		avl.insert(5);
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
	}
	
	@Override
	public void insert(T element) {
		super.insert(element);
		BSTNode<T> node = this.search(element);
		this.rebalanceUp(node);
	}
}