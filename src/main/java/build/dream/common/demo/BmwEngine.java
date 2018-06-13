package build.dream.common.demo;

public class BmwEngine implements Engine {
    public BmwEngine() {
        System.out.println("宝马引擎被创建！");
    }
    @Override
    public void start() {
        System.out.println("Bmw Engine start");
    }

    @Override
    public void stop() {
        System.out.println("Bmw Engine stop");
    }
}
