public class printfExample {
    public static void main(String[] args) {
        String s = "Cookies";
        double b = 3.20;
        System.out.printf("%-10s%10.2f", s + ": ", b); //works
        System.out.printf("%05f" , b); //not print leading zero but tailing zero
        System.out.println("%05d" , b); //error
        String B = Double.toString(b);
        System.out.printf("%05s", B); //error

    }

}
