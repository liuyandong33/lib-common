package build.dream.common.orm;

import java.util.List;

public interface IdGenerator<T> {
    T nextId();

    List<T> nextManyIds(int number);
}
