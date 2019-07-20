package build.dream.common.functions;

@FunctionalInterface
public interface SuppressThrowFunction<T> {
    T call() throws Exception;
}
