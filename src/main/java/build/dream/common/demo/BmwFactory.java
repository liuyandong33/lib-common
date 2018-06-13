package build.dream.common.demo;

public class BmwFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new BmwEngine();
    }

    @Override
    public AirConditioner createAirConditioner() {
        return new BmwAirConditioner();
    }
}
