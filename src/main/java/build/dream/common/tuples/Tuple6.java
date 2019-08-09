package build.dream.common.tuples;

public class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple5<T1, T2, T3, T4, T5> {
    private T6 _6;

    public Tuple6() {
    }

    public Tuple6(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
        super(_1, _2, _3, _4, _5);
        this._6 = _6;
    }

    public T6 _6() {
        return _6;
    }
}
