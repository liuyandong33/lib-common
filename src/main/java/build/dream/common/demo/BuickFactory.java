package build.dream.common.demo;

public class BuickFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new BuickEngine();
    }

    @Override
    public AirConditioner createAirConditioner() {
        return new BuickAirConditioner();
    }
}
