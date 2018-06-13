package build.dream.common.demo;

public class EngineFactory {
    public Engine createEngine(Class<? extends Engine> engineClass) throws IllegalAccessException, InstantiationException {
        return engineClass.newInstance();
    }
}
