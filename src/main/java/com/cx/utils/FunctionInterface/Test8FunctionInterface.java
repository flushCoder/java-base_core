package com.cx.utils.FunctionInterface;

        import java.util.function.Function;

public class Test8FunctionInterface implements A {
    @Override
    public void testA() {
        System.out.println("a");
    }

    @Override
    public void testB1() {
        System.out.println("b1");
    }

    @Override
    public void testB2() {
        System.out.println("b2");
    }

    public static void main(String args[]){
        Function<Integer, Integer> incre1 = x->x + 1;
        Function<Integer, Integer> incre2 = x->x * 2;
        int x = 2;
        System.out.println("f(x)="+incre1.apply(x));
        System.out.println("f(g(x))="+incre1.compose(incre2).apply(x));
        System.out.println("g(f(x))="+incre1.andThen(incre2).apply(x));
        System.out.println("f(g(x))="+incre1.compose(incre2).apply(x)+"  g(f(x))="+incre2.andThen(incre1).apply(x));

        Function<Integer, Function<Integer, Integer>> addMaker = z->y->z+y;
        Function<Integer, Integer> add1 = addMaker.apply(1);
        System.out.println("f(x)=x+1, when x="+x+", f(x)="+add1.apply(x));
        Function<Integer, Integer> add2 = addMaker.apply(5);
        System.out.println("f(x)=x+5, when x="+x+", f(x)="+add2.apply(x));

        Function<Integer, Function<Integer, Integer>> mul = z->y->z * y;
        Function<Integer, Integer> mult1 = mul.apply(5);
        System.out.println(mult1.apply(3));
    }
}
