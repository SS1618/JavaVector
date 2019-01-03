public class ArrayVector<T>{
	T[] array;
	boolean[] mod;
	int sizeReal;
	ArrayVector(int size){
		array = (T[])new Object[size];
		sizeReal = size;
		mod = new boolean[size];
	}
	public int size(){
		return sizeReal;
	}
	public T add(T foo){
		T[] arrayStore = array;
		int sizeStore = array.length;
		array = (T[])new Object[sizeStore+1];
		for(int i = 0; i<sizeStore; i++){
			array[i] = arrayStore[i];
		}
		sizeReal = sizeStore+1;
		array[sizeStore] = foo;
		return foo;
	}
	public T add(int pos, T foo){
		T[] arrayStore = (T[])new Object[sizeReal+1];
		int posTwo = 0;
		for(int i = 0; i<sizeReal; i++){
			if(i == pos){
				posTwo++;
			}
			arrayStore[posTwo] = array[i];
			posTwo++;
		}
		arrayStore[pos] = foo;
		array = (T[])new Object[sizeReal+1];
		array = arrayStore;
		sizeReal = array.length;
		return foo;
	}
	public void set(int pos, T val){
		array[pos] = val;
	}
	public T get(int n){
		return array[n];
	}
	public T remove(int n){
		T store = get(n);
		for(int i = n; i<sizeReal-2; i++){
			array[i] = array[i+1];
		}
		T[] storeArray = array;
		array = (T[])new Object[sizeReal-1];
		for(int i = 0; i<array.length; i++){
			array[i] = storeArray[i];
		}
		sizeReal = array.length;
		return store;
	}
}