package build.dream.common.functions;

@FunctionalInterface
public interface NoThrowNoReturnFunction {
    void call() throws Exception;
}
