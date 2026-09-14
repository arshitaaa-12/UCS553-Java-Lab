class NestedTryDemo {
    public static void main(String[] args) {

        try {
            System.out.println("Outer try block");

            try {
                System.out.println("Inner try block");

                int a = 10 / 0;
            }
            catch (ArithmeticException e) {
                System.out.println("Inner catch: Cannot divide by zero");
            }

            int arr[] = {10, 20, 30};
            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: Invalid array index");
        }

        System.out.println("Program continues...");
    }
}