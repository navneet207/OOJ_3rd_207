// Define the custom exception class WrongAge
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Father class with constructor that throws WrongAge exception
class Father {
    protected int fatherAge;

    public Father(int fatherAge) throws WrongAge {
        if (fatherAge < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        this.fatherAge = fatherAge;
        System.out.println("Father's age is: " + fatherAge);
    }
}

// Son class which inherits from Father and throws an exception if son's age >= father's age
class Son extends Father {
    private int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);  // Call Father constructor
        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative!");
        }
        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age!");
        }
        this.sonAge = sonAge;
        System.out.println("Son's age is: " + sonAge);
    }
}

// Main class to demonstrate the program
public class exception {
    public static void main(String[] args) {
        try {
            // Try with valid ages
            Son son1 = new Son(40, 18); // Valid case
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Try with invalid father's age
            Father father1 = new Father(-5); // Invalid father's age
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Try with son's age greater than or equal to father's age
            Son son2 = new Son(40, 40); // Invalid case
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Try with invalid son's age
            Son son3 = new Son(30, -10); // Invalid son's age
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}






