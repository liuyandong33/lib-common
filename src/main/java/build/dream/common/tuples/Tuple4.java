package build.dream.common.tuples;

public class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3> {
    private T4 _4;

    public Tuple4() {
    }

    public Tuple4(T1 _1, T2 _2, T3 _3, T4 _4) {
        super(_1, _2, _3);
        this._4 = _4;
    }

    public T4 _4() {
        return _4;
    }
}
