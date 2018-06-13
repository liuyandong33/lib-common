package build.dream.common.demo;

public class BmwAirConditioner implements AirConditioner {
    public BmwAirConditioner() {
        System.out.println("宝马空调被创建！");
    }
    @Override
    public void start() {
        System.out.println("Bmw Air Conditioner start");
    }

    @Override
    public void stop() {
        System.out.println("Bmw Air Conditioner stop");
    }
}
