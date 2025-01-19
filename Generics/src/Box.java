public class Box<T extends  Comparable<T>> {
    private T first;
    private T second;
    private boolean isCurrentlyLocked = false;

    public Box(T first, T second) {

            if (first.compareTo(second) > 0) {
                this.first = first;
                this.second = second;
            } else {
                this.first = second;
                this.second = first;
            }
        }



    public T getFirst() {
        checkState();
        return first;
    }

    public T getSecond() {
        checkState();
        return second;
    }

    public void lock() {
        isCurrentlyLocked = true;
    }
    public void unlock() {
        isCurrentlyLocked = false;
    }

    public boolean isLocked() {
        return isCurrentlyLocked;
    }

    public void checkState() {
        if(isCurrentlyLocked) {
            throw new LockedException("The box is currently locked");
        }
    }

    @Override
    public String toString() {
            checkState();
            return "Value is " + first + "\nValue is " + second;
    }

}

