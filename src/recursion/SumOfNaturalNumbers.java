package recursion;

public class SumOfNaturalNumbers {

    public static int sum(int input) {
        if (input == 1) {
            return input;
        }

        var sum =  input + sum(input - 1);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}
