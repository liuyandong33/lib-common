package build.dream.common.tuples;

public class Tuple2<T1, T2> extends Tuple1<T1> {
    private T2 _2;

    public Tuple2() {
    }

    public Tuple2(T1 _1, T2 _2) {
        super(_1);
        this._2 = _2;
    }

    public T2 _2() {
        return _2;
    }
}
