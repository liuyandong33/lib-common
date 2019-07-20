package build.dream.common.functions;

@FunctionalInterface
public interface SuppressThrowNoReturnFunction {
    void call() throws Exception;
}
