package build.dream.common.demo;

public class BuickEngine implements Engine {
    public BuickEngine() {
        System.out.println("别克引擎被创建！");
    }
    @Override
    public void start() {
        System.out.println("Buick Engine start");
    }

    @Override
    public void stop() {
        System.out.println("Buick Engine stop");
    }
}
