package code.lambda;

import java.util.function.Function;

public class LambdaExpressions {
    public static void main(String[] args) {
        // trySomething("Hello", input -> input.toUpperCase());
        // trySomething("HELLO", input -> input.toLowerCase());

        System.out.println(doMathStuff(4, a -> a + 1));

        doMathStuff(4, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        });

        System.out.println(doMathStuff(4, a -> a * 2));

        System.out.println(doMathStuffAdvanced(5, 4, (a, b) -> a * b));
    }

    private static Integer doMathStuffAdvanced(int input1, int input2, MyFunctionalInterface function) {
        return function.applyThis(input1, input2);
    }

    private static Integer doMathStuff(Integer request, Function<Integer, Integer> function) {
        return function.apply(request);
    }

    public static void trySomething(String input, Function<String, String> function) {
        System.out.println("test");
        System.out.println(function.apply(input));
    }

    public static void trySomethingWithUpper(String input) {
        System.out.println(input.toUpperCase());
    }
}
