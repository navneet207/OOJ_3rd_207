// Generic class with a single parameter
class GenericSingle<T> {
    private T value;

    public GenericSingle(T value) {
        this.value = value;
    }

    public void displayValue() {
        System.out.println("Value: " + value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

public class SingleParameterDemo {
    public static void main(String[] args) {
        // Autoboxing: int to Integer
        GenericSingle<Integer> single = new GenericSingle<>(10);
        single.displayValue();

        // Unboxing: Integer to int
        int num = single.getValue();
        System.out.println("Unboxed Value: " + num);
    }
}
















