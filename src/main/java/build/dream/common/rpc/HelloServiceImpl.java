package build.dream.common.rpc;

import java.util.UUID;

public class HelloServiceImpl implements IHello {
    @Override
    public String sayHello(String string) {
        return UUID.randomUUID().toString();
    }
}
