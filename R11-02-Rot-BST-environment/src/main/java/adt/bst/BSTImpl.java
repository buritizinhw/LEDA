package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return heightRecursive(this.root);
	}

	private int heightRecursive(BSTNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}
		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		return recursiveSearch(this.root, element);
	}

	private BSTNode<T> recursiveSearch(BSTNode<T> node, T element) {
		BSTNode<T> result = new BSTNode<T>();
		if (element != node.getData()) {
			if (element.compareTo(node.getData()) < 0) {
				result = recursiveSearch((BSTNode<T>) node.getLeft(), element);
			} else {
				result = recursiveSearch((BSTNode<T>) node.getRight(), element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		insertRecursive(this.root, element);
	}

	private void insertRecursive(BSTNode<T> node, T element) {
		BSTNode<T> newNode = new BSTNode<T>();
		if (this.root.isEmpty()) {
			this.root = newNode(element);
		}
		if (element.compareTo(node.getData()) < 0) {
			if (node.getLeft().isLeaf()) {
				newNode = newNode(element);
				node.setLeft(newNode);
				newNode.setParent(node);
			}
		} else {
			if (node.getRight().isLeaf()) {
				newNode = newNode(element);
				node.setRight(newNode);
				newNode.setParent(node);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximumRecursive(this.root);
	}

	private BSTNode<T> maximumRecursive(BSTNode<T> node) {
		BSTNode<T> result = new BSTNode<T>();
		if (!node.isLeaf()) {
			result = maximumRecursive((BSTNode<T>) node.getRight());
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimumRecursive(this.root);
	}

	private BSTNode<T> minimumRecursive(BSTNode<T> node) {
		BSTNode<T> result = new BSTNode<T>();
		if (!node.isLeaf()) {
			result = maximumRecursive((BSTNode<T>) node.getLeft());
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> result = new ArrayList<T>();

		preOrder(this.root, result);

		return (T[]) result.toArray(new Comparable[this.size()]);
	}

	private void preOrder(BSTNode current, ArrayList<T> list) {
		if (!current.isEmpty()) {
			list.add((T) current.getData());
			preOrder((BSTNode<T>) current.getLeft(), list);
			preOrder((BSTNode<T>) current.getRight(), list);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> result = new ArrayList<T>();

		order(this.root, result);

		return (T[]) result.toArray(new Comparable[this.size()]);
	}

	private void order(BSTNode current, ArrayList<T> list) {
		if (!current.isEmpty()) {
			order((BSTNode<T>) current.getLeft(), list);
			list.add((T) current.getData());
			order((BSTNode<T>) current.getRight(), list);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> result = new ArrayList<T>();

		postOrderRecursive(this.root, result);

		return (T[]) result.toArray(new Comparable[this.size()]);
	}

	private void postOrderRecursive(BSTNode current, ArrayList<T> list) {
		if (!current.isEmpty()) {
			postOrderRecursive((BSTNode<T>) current.getLeft(), list);
			postOrderRecursive((BSTNode<T>) current.getRight(), list);
			list.add((T) current.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return sizeRecursive(root);
	}

	private int sizeRecursive(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
