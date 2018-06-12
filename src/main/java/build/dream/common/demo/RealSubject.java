package build.dream.common.demo;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("request");
    }

    @Override
    public void alert() {
        request();
        System.out.println("alert");
    }
}
