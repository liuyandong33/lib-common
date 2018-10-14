package build.dream.common.jobs;

import java.io.Serializable;

public interface JobWrapper extends Serializable {
    void execute();
}
