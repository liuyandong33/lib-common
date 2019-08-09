package build.dream.common.tuples;

public class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> extends Tuple7<T1, T2, T3, T4, T5, T6, T7> {
    private T8 _8;

    public Tuple8(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8) {
        super(_1, _2, _3, _4, _5, _6, _7);
        this._8 = _8;
    }

    public T8 _8() {
        return _8;
    }
}
