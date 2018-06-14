package build.dream.common.demo;

import java.io.Serializable;
import java.util.UUID;

public class Test implements Serializable {
    private static final String NAME = UUID.randomUUID().toString();
    private static final String SUCCESS = "SUCCESS";

    private String code;

    private int age;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Test() {

    }

    public Test(String code) {
        this.code = code;
    }
}
