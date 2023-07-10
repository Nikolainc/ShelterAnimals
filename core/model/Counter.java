package core.model;

public class Counter implements AutoCloseable {

    private static int sum = 0;

    public static void add() {
        sum++;
    }

    @Override
    public void close() {
        System.out.println("Счетчик закрыт");
    }
}