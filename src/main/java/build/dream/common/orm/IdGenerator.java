package build.dream.common.orm;

public interface IdGenerator<T> {
    T nextId();
}
