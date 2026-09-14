class ExceptionDemo {
    public static void main(String[] args) {

        // ArithmeticException
        try {
            int a = 10 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Cannot divide by zero");
        }

        // NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException: String is null");
        }

        // ArrayIndexOutOfBoundsException
        try {
            int arr[] = {10, 20, 30};
            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: Invalid array index");
        }

        // NumberFormatException
        try {
            String s = "abc";
            int n = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Invalid number format");
        }
    }
}