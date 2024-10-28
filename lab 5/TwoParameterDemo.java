// Base generic class
class GenericPair<T, U> {
    private T first;
    private U second;

    public GenericPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public void displayPair() {
        System.out.println("First: " + first + ", Second: " + second);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

// Derived class extending GenericPair
class NumericPair extends GenericPair<Integer, Double> {
    public NumericPair(Integer first, Double second) {
        super(first, second);
    }

    public double calculateSum() {
        return getFirst() + getSecond();
    }
}

public class TwoParameterDemo {
    public static void main(String[] args) {
        NumericPair pair = new NumericPair(10, 20.5);
        pair.displayPair();
        
        double sum = pair.calculateSum();
        System.out.println("Sum of Pair: " + sum);
    }
}
