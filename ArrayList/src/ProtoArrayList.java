public class ProtoArrayList<T> {
    private int size;
    private static final int STARTING_CAPACITY = 2;
    private Object[] array;

    public ProtoArrayList() {
        array = new Object[STARTING_CAPACITY];
        size = 0;
    }
    public void add(T addition) {
        if (size == array.length) {
            Object[] doubleArray = new Object[array.length * 2];
            System.arraycopy(array,0,doubleArray,0,array.length);
            array = doubleArray;
        }
        array[size++] = addition;
    }
    public void outOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        outOfBounds(index);
        T removedElement = (T) array[index];
        System.arraycopy(array,index +1,array,index,size - index - 1);
        array[size - 1] = null;
        size--;
        return removedElement;
    }


    @SuppressWarnings("unchecked")
    public T get(int index) {
       outOfBounds(index);
        return (T) array[index];
    }

    @Override
    public String toString(){
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size - 1; i++ ) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");
        return sb + "\n" + size + "\n" + currentCapacity();
    }
    public int currentCapacity() {
        return array.length;
    }


}
