package build.dream.common.demo;

public class BuickAirConditioner implements AirConditioner {
    public BuickAirConditioner() {
        System.out.println("别克空调被创建！");
    }
    @Override
    public void start() {
        System.out.println("Buick Air Conditioner start");
    }

    @Override
    public void stop() {
        System.out.println("Buick Air Conditioner stop");
    }
}
