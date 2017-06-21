package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if (this.data == null) {
			empty = true;
		}
		return empty;
	}

	@Override
	public int size() {
		int result = 0;
		if (this.isEmpty()) {
			result = 1;
		}
		else {
			result = 1 + this.next.size();
		}
		return result;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.data.equals(element)) {
					result = this.data;
				}
				else {
					result = this.next.search(element);
				}
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
			}
			else {
				this.next.insert(element);
			}
		}
	}

	//TODO
	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.data.equals(element)) {
					
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[1];
		if (!this.isEmpty()) {
			result[0]  = this.data;
			result = this.next.toArray();
		}
		else {
			result[this.size()] = this.data;
		}
		return result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}