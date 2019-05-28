package build.dream.common.orm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UUIDIdGenerator implements IdGenerator<String> {
    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public List<String> nextManyIds(int number) {
        List<String> ids = new ArrayList<String>(number);
        for (int index = 0; index < number; index++) {
            ids.add(nextId());
        }
        return ids;
    }
}
