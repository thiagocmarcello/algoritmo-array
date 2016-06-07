
public class Main {

    private static int[] arrayStack = initArray();
    private static int[] arrayApache = initArray();
    private static long timeToStack = 0;
    private static long timeToApache = 0;


    public static void main(String[] args) {
        reverseStack(arrayStack);
        reverseApache(arrayApache);
        printStack();
        printApache();
    }

    private static int[] initArray() {
        int sizeArray = 77777777;
        int[] numbers = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    // http://stackoverflow.com/questions/2137755/how-do-i-reverse-an-int-array-in-java
    private static void reverseStack(int[] numeros) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < numeros.length / 2; i++) {
            int temp = numeros[i];
            numeros[i] = numeros[numeros.length - i - 1];
            numeros[numeros.length - i - 1] = temp;
        }
        long elapsed = System.currentTimeMillis() - start;
        timeToStack = elapsed;
    }

    // https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/src-html/org/apache/commons/lang/ArrayUtils.html#line.1541
    public static void reverseApache(int[] array) {
        long start = System.currentTimeMillis();
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
        long elapsed = System.currentTimeMillis() - start;
        timeToApache = elapsed;
    }

    private static void printStack() {
        System.out.println("Stack performance: " + timeToStack);
        System.out.println(" --- ");
    }

    private static void printApache() {
        System.out.println("Apache performance: " + timeToApache);
        System.out.println(" --- ");
    }
}
