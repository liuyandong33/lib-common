package build.dream.common.tuples;

public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> {
    private T3 _3;

    public Tuple3(T1 _1, T2 _2, T3 _3) {
        super(_1, _2);
        this._3 = _3;
    }

    public T3 _3() {
        return _3;
    }
}
