package code.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceMain {
    public static void main(String[] args) {
//        tryFunction(a -> a + 1);
//        tryFunction(a -> a * 10);
//
//        trySupplier(() -> "ceva");
//        trySupplier(() -> "altceva");
//
//        tryConsumer(s -> System.out.println(s));
//
//        tryPredicate(i -> i < 10);
//        tryPredicate(i -> i % 2 == 0);

        tryMultiple(
                () -> "FastTrack",
                String::length,
                number -> number > 5,
                number -> System.out.println("Greater than 5")
        );
    }

    public static void tryMultiple(
            Supplier<String> supplier,
            Function<String, Integer> function,
            Predicate<Integer> predicate,
            Consumer<Integer> consumer
    ) {
        String s = supplier.get();
        Integer integer = function.apply(s);
        if (predicate.test(integer)) {
            consumer.accept(integer);
        } else {
            System.out.println("Not good");
        }
    }

    private static Integer tryFunction(Function<Integer, Integer> function) {
        Integer result = function.apply(4);
        System.out.println(result);
        return result;
    }

    private static void trySupplier(Supplier<String> stringSupplier) {
        String s = stringSupplier.get();
        if (s.startsWith("c")) {
            System.out.println("this is something");
        } else {
            System.out.println("this is nothing");
        }
    }

    public static void tryConsumer(Consumer<String> consumer) {
        consumer.accept("something");
        consumer.accept("something else");
    }

    public static void tryPredicate(Predicate<Integer> integerPredicate) {
        int a = 22;
        if (integerPredicate.test(22)) {
            System.out.println("WON");
        } else {
            System.out.println("LOSE");
        }
    }
}
