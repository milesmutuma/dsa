package recursion;

public class DecimalToBinary {

    private static String decimalToBinary(Integer input, String result){
        if (input == 0) {
            return result;
        }

        result = input % 2 + result;

        var item = "hey" + decimalToBinary(input / 2, result);

        return item;
    }

    public static void main(String[] args) {
        var binary = decimalToBinary(234,"");
    }
}
