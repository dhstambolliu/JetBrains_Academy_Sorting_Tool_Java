import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        Double radius = scanner.nextDouble();
        Double area = Math.PI * radius * radius;
        System.out.println(area);
    }
}