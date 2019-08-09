package build.dream.common.tuples;

public class Tuple7<T1, T2, T3, T4, T5, T6, T7> extends Tuple6<T1, T2, T3, T4, T5, T6> {
    private T7 _7;

    public Tuple7() {
    }

    public Tuple7(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7) {
        super(_1, _2, _3, _4, _5, _6);
        this._7 = _7;
    }

    public T7 _7() {
        return _7;
    }
}
