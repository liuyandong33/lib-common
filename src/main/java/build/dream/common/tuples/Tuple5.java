package build.dream.common.tuples;

public class Tuple5<T1, T2, T3, T4, T5> extends Tuple4<T1, T2, T3, T4> {
    private T5 _5;

    public Tuple5() {
    }

    public Tuple5(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
        super(_1, _2, _3, _4);
        this._5 = _5;
    }

    public T5 _5() {
        return _5;
    }
}
