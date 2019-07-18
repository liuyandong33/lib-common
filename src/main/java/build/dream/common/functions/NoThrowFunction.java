package build.dream.common.functions;

@FunctionalInterface
public interface NoThrowFunction<T> {
    T call() throws Exception;
}
