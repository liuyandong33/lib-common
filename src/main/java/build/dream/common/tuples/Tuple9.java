package build.dream.common.tuples;

public class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> {
    private T9 _9;

    public Tuple9(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9) {
        super(_1, _2, _3, _4, _5, _6, _7, _8);
        this._9 = _9;
    }

    public T9 _9() {
        return _9;
    }
}
