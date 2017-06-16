package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		if (size >= 0) {
			this.array = (T[]) new Object[size];
			this.tail = -1;
		}
	}

	@Override
	public T head() {
		if (this.tail >= 0) {
			return this.array[0];
		};
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (tail < 0) {
			return true;
		};
		return false;
	}

	@Override
	public boolean isFull() {
		if (tail + 1 >= array.length) {
			return true;
		};
		return false;
	}

	private void shiftLeft() {
		for (int i = 0; i < tail; i++) {
			array[i] = array[i+1];
		};
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!this.isFull()) {
			array[++tail] = element;
		}
		else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (!isEmpty()) {
			result = array[0];
			this.shiftLeft();
			tail--;
		}
		else {
			throw new QueueUnderflowException();
		}
		return result;
	}
}