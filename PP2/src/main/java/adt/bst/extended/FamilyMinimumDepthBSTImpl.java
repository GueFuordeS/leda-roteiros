package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class FamilyMinimumDepthBSTImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements FamilyBST<T>, MinimumDepthtBST<T> {

	@Override
	public int minimumDepth() {
		int retorno = 0;
		if (!root.isEmpty() && !(root.getLeft().isEmpty() && root.getRight().isEmpty())) {
			retorno =  this.minimumDepth(root);
		}
		return retorno;
	}

	public int minimumDepth(BTNode<T> node) {
		int retorno = 0;

		if (!node.isEmpty()) {
			retorno += 1;
			
			if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
				retorno += Math.min(this.minimumDepth(node.getLeft()), this.minimumDepth(node.getRight()));
			}
			else if (!node.getLeft().isEmpty()) {
				retorno += this.minimumDepth(node.getLeft());
			}
			else if (!node.getRight().isEmpty()) {
				retorno += this.minimumDepth(node.getRight());
			}
		}
		
		return retorno;
	}

	@Override
	public boolean primosPrimeiroGrau(T elem1, T elem2) {
		boolean retorno = false;
		if (elem1 != null && elem2 != null) {
			BSTNode<T> no1 = search(elem1);
			BSTNode<T> no2 = search(elem2);

			if (!no1.isEmpty() && !no2.isEmpty()) {
				if (!no1.getParent().isEmpty() && !no2.getParent().isEmpty()) {
					if (!no1.getParent().getParent().isEmpty() && !no2.getParent().getParent().isEmpty()) {
						if (no1.getParent().getParent().equals(no2.getParent().getParent())) {
							retorno = true;
						}
					}
				}
			}
		}
		return retorno;
	}

	@Override
	public boolean primosSegundoGrau(T elem1, T elem2) {
		boolean retorno = false;
		if (elem1 != null && elem2 != null) {
			BSTNode<T> no1 = search(elem1);
			BSTNode<T> no2 = search(elem2);
			
			if (!no1.getParent().isEmpty() && !no2.getParent().isEmpty()) {
				if (this.primosPrimeiroGrau(no1.getParent().getData(), no2.getData())) {
					retorno = this.primosPrimeiroGrau(no1.getParent().getData(), no2.getData());
				}
				else if (this.primosPrimeiroGrau(no1.getData(), no2.getParent().getData())) {
					retorno = this.primosPrimeiroGrau(no1.getData(), no2.getParent().getData());
				}
			}
		}
		return retorno;
	}
}