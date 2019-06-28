public class printfExample {
    public static void main(String[] args) {
        String s = "Cookies";
        double b = 3.20;
        System.out.printf("%-10s%10.2f\n", s + ": ", b); //works
        System.out.printf("%05.2f\n" , b); // need .f for double variable
        System.out.printf("%5d\n", (int)b); //"%d" only works for integer. need to cast
        String B = Double.toString(b);
        System.out.printf("%10s\n", B); //error
        System.out.printf("%-10s\n", B);
        

    }



}
