package build.dream.common.utils;

import build.dream.common.tuples.*;

public class TupleUtils {
    public static <T> Tuple1<T> buildTuple1(T t) {
        return new Tuple1<T>(t);
    }

    public static <T1, T2> Tuple2<T1, T2> buildTuple2(T1 t1, T2 t2) {
        return new Tuple2<T1, T2>(t1, t2);
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> buildTuple3(T1 t1, T2 t2, T3 t3) {
        return new Tuple3<T1, T2, T3>(t1, t2, t3);
    }

    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> buildTuple4(T1 t1, T2 t2, T3 t3, T4 t4) {
        return new Tuple4<T1, T2, T3, T4>(t1, t2, t3, t4);
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> buildTuple5(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return new Tuple5<T1, T2, T3, T4, T5>(t1, t2, t3, t4, t5);
    }

    public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> buildTuple6(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return new Tuple6<T1, T2, T3, T4, T5, T6>(t1, t2, t3, t4, t5, t6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> buildTuple7(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return new Tuple7<T1, T2, T3, T4, T5, T6, T7>(t1, t2, t3, t4, t5, t6, t7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> buildTuple8(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return new Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> buildTuple9(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
        return new Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> buildTuple10(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
        return new Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }
}
