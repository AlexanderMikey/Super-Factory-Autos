package iterator;

import java.util.ArrayList;

public class FIFO<T> implements Iterator<T> {

	private ArrayList<T> list;
	private int curr;
	
	public FIFO(ArrayList<T> list) {
		this.list = list;
		this.curr = 0;
	}

	@Override
	public T getNext() {
		return this.list.get(curr++);
	}

	@Override
	public boolean hasNext() {
		return (this.curr < this.list.size());
	}

}
