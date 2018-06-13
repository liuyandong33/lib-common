package build.dream.common.demo;

public class Customer {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        EngineFactory engineFactory = new EngineFactory();
        Engine engine = engineFactory.createEngine(BuickEngine.class);
        engine.start();
        engine.stop();

        CarFactory carFactory = new BuickFactory();
        carFactory.createEngine();
        carFactory.createAirConditioner();
    }
}
