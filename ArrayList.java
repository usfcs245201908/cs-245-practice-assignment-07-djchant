import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	T[] a;
	int size;

	public ArrayList() {
		a = (T[]) new Object[10];
		size = 0;
	}

	public void add(T item) {
		if(size == -1) {
			System.out.println("Invalid poistion");
			return;
		}

		if(size + 1 == a.length) {
			grow_array();
		}


		a[size++] = item;
	}

	public void add(int pos, T item) {
		if(size + 1 == a.length) {
			grow_array();
		}

		if(pos < 0 || pos > size) {
			System.out.println("Invalid poistion");
			return;
		}

		for(int i = size; i > pos; i--) {
			a[i] = a[i - 1];
		}
		a[pos] = item;
		size++;
	}

	public T get(int pos) {
		if(pos < 0 || pos > size) {
			System.out.println("Invalid Position.");
			return null;
		}

		return(a[pos]);
	}

	public T remove(int pos) {
		if(size == -1) {
			System.out.println("The array is empty");
			return null;
		}

		if(pos < 0 || pos > size) {
			System.out.println("Invalid Position.");
			return null;
		}

		T temp = a[pos];
		for(int i = pos; i < size - 1; i++) {
			a[i] = a[i + 1];
			a[size - 1] = null;
		}

		size--;
		return temp;
	}

	public int size() {
		return size;
	}

	public void grow_array() {
		T[] new_array = (T[]) new Object[a.length * 2];

		for(int i = 0; i < a.length; i++) {
			new_array[i] = a[i];
		}
		a = new_array;
	}
}