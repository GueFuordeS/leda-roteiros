package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		if (size >= 0) {
			this.array = (T[]) new Object[size];
			this.top = -1;
		}
	}

	@Override
	public T top() {
		return this.array[top];
	}

	@Override
	public boolean isEmpty() {
		if (this.top < 0) {
			return true;
		};
		return false;
	}

	@Override
	public boolean isFull() {
		if (this.top + 1 >= this.array.length) {
			return true;
		};
		return false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		};
		
		this.array[++top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		};
		
		return this.array[top--];
	}
}