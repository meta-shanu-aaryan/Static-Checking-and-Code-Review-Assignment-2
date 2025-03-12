import java.util.*;
import java.lang.Math;

class HexCalc {
    private HashMap<Character, Integer> hexMpp = new HashMap<>(); // hashmap for hexadecimal to decimal number
    private char[] decMpp = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' }; // decimal
                                                                                                                // to
                                                                                                                // hexadecimal
                                                                                                                // reference

    public HexCalc() {

        // mapping the character of hexadecimal to decimal when constructor is called
        hexMpp.put('0', 0);
        hexMpp.put('1', 1);
        hexMpp.put('2', 2);
        hexMpp.put('3', 3);
        hexMpp.put('4', 4);
        hexMpp.put('5', 5);
        hexMpp.put('6', 6);
        hexMpp.put('7', 7);
        hexMpp.put('8', 8);
        hexMpp.put('9', 9);
        hexMpp.put('A', 10);
        hexMpp.put('B', 11);
        hexMpp.put('C', 12);
        hexMpp.put('D', 13);
        hexMpp.put('E', 14);
        hexMpp.put('F', 15);
    }

    // getters
    public int getHexaValue(char hex) {
        return hexMpp.get(hex);
    }

    public char getDecValue(int dec) {
        return decMpp[dec];
    }

    // functions

    // To convert hexadecimal to decimal
    public int calculateDecimal(String hex) {

        int size = hex.length();
        int result = 0;

        for (int i = 0; i < size; i++) {
            char temp = hex.charAt(size - i - 1);
            result += getHexaValue(temp) * Math.pow(16, i);
        }

        return result;
    }

    // To convert decimal to hexadecimal
    public String calculateHexaDecimal(int dec) {

        String result = "";
        while (dec != 0) {
            int temp = dec % 16;
            result = getDecValue(temp) + result;
            dec = dec / 16;
        }

        return result;
    }

    // To compare with equal operator
    public boolean equals(String a, String b) {

        int c = calculateDecimal(a);
        int d = calculateDecimal(b);

        return (c == d);
    }

    // To compare with greater operator
    public boolean greater(String a, String b) {

        int c = calculateDecimal(a);
        int d = calculateDecimal(b);

        return (c > d);
    }

    // To compare with smaller operator
    public boolean smaller(String a, String b) {

        int c = calculateDecimal(a);
        int d = calculateDecimal(b);

        return (c < d);
    }

    // To calculate Sum
    public String add(String a, String b) {

        int c = calculateDecimal(a);
        int d = calculateDecimal(b);
        String result = calculateHexaDecimal(c + d);
        return result;
    }

    // To calculate Subtraction
    public String subtract(String a, String b) {

        int c = calculateDecimal(a);
        int d = calculateDecimal(b);

        if (c < 0 || d < 0) {
            throw new ArithmeticException("Can't calculate -ve integer for now");
        } else if (c < d) {
            return "First argument should be greater than second";
        }

        String result = calculateHexaDecimal(c - d);
        return result;
    }

    // To calculate product
    public String multiply(String a, String b) {
        int c = calculateDecimal(a);
        int d = calculateDecimal(b);

        if (c < 0 || d < 0) {
            throw new ArithmeticException("Can't calculate -ve integer for now");
        }
        String result = calculateHexaDecimal(c * d);
        return result;
    }

    // To calculate Division
    public String divide(String a, String b) {

        int dec1 = calculateDecimal(a);
        int dec2 = calculateDecimal(b);

        if (dec2 == 0) {
            throw new ArithmeticException("Can't divide aything by zero");
        } else if (dec1 % dec2 != 0) {
            throw new ArithmeticException("Can't Calculate floating point division for now");

        }
        String result = calculateHexaDecimal(dec1 / dec2);
        return result;
    }
}

public class HexaDecimalConversion {

    public static void main(String[] args) {

        HexCalc hx = new HexCalc();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welome to Hexadecimal Conversion and Arithmatic System...\nWhat do you want to do?");
            System.out.println(
                    "For Conversion press 1\nFor Comparision Press 2\n For Arithmatic Press 3\nTo Exit Press 4");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(
                            "Hexadecimal Conversion...\n Press 1 for Hexadecimal to Decimal\n Press 2 for Decimal to Hexadecimal");
                    int conversionChoice = sc.nextInt();
                    switch (conversionChoice) {
                        case 1:
                            System.out.print("Enter the Hexadecimal Number:- ");
                            String hex = sc.next();
                            System.out.println(hex + " decimal value is " + hx.calculateDecimal(hex));
                            break;
                        case 2:
                            System.out.println("Enter the Decimal Number:- ");
                            int num = sc.nextInt();
                            System.out.println(num + " Hexadecimal value is " + hx.calculateHexaDecimal(num));
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println(
                            "Comparision Operation... \n Press 1 for equal operation\n Press 2 for greater Operation\n Press 3 for smaller operation");
                    int comparisionChoice = sc.nextInt();
                    switch (comparisionChoice) {
                        case 1:
                            System.out.print("Enter 1st hexadecimal- ");
                            String hexa1 = sc.next();
                            System.out.println("Enter the 2nd hexadecimal- ");
                            String hexa2 = sc.next();
                            if (hx.equals(hexa1, hexa2)) {
                                System.out.println("Both are equal...");
                            } else {
                                System.out.println("Both are not equal...");
                            }
                            break;

                        case 2:
                            System.out.print("Enter 1st hexadecimal- ");
                            hexa1 = sc.next();
                            System.out.println("Enter the 2nd hexadecimal- ");
                            hexa2 = sc.next();
                            if (hx.greater(hexa1, hexa2)) {
                                System.out.println(hexa1 + " is greater than " + hexa2);
                            } else {
                                System.out.println(hexa1 + " is smaller than " + hexa2);
                            }
                            break;

                        case 3:
                            System.out.print("Enter 1st hexadecimal- ");
                            hexa1 = sc.next();
                            System.out.println("Enter the 2nd hexadecimal- ");
                            hexa2 = sc.next();
                            if (hx.smaller(hexa1, hexa2)) {
                                System.out.println(hexa1 + " is smaller than " + hexa2);
                            } else {
                                System.out.println(hexa1 + " is greater than " + hexa2);
                            }
                            break;

                        default:
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Arithmatic Operation...");
                    System.out.println(
                            "For addition Press 1\nFor subtraction Press 2\n For Multiplication Press 3\n For Division Press 4");
                    int arithmaticChoice = sc.nextInt();
                    switch (arithmaticChoice) {
                        case 1:
                            System.out.println("Enter the 1st Hexadecimal number");
                            String hexa1 = sc.next();
                            System.out.println("Enter the 2nd Hexadecimal number");
                            String hexa2 = sc.next();

                            System.out.println(hexa1 + "+" + hexa2 + " is " + hx.add(hexa1, hexa2));
                            break;
                        case 2:
                            System.out.println("Enter the 1st Hexadecimal number");
                            hexa1 = sc.next();
                            System.out.println("Enter the 2nd Hexadecimal number");
                            hexa2 = sc.next();

                            System.out.println(hexa1 + "-" + hexa2 + " is " + hx.subtract(hexa1, hexa2));
                            break;
                        case 3:
                            System.out.println("Enter the 1st Hexadecimal number");
                            hexa1 = sc.next();
                            System.out.println("Enter the 2nd Hexadecimal number");
                            hexa2 = sc.next();

                            System.out.println(hexa1 + "*" + hexa2 + " is " + hx.multiply(hexa1, hexa2));
                            break;
                        case 4:
                            System.out.println("Enter the 1st Hexadecimal number");
                            hexa1 = sc.next();
                            System.out.println("Enter the 2nd Hexadecimal number");
                            hexa2 = sc.next();

                            System.out.println(hexa1 + "/" + hexa2 + " is " + hx.divide(hexa1, hexa2));
                            break;

                        default:
                            break;
                    }
                    break;
                default:
                    break;

            }
            if (choice == 4) {
                break;
            }
        }

        sc.close();

    }
}