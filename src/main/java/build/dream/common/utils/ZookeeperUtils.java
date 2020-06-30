package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.Objects;

public class ZookeeperUtils {
    private static CuratorFramework curatorFramework;

    private static CuratorFramework obtainCuratorFramework() {
        if (Objects.isNull(curatorFramework)) {
            curatorFramework = ApplicationHandler.getBean(CuratorFramework.class);
        }
        return curatorFramework;
    }

    public static boolean exists(String path) {
        return ApplicationHandler.callMethodSuppressThrow(() -> Objects.nonNull(obtainCuratorFramework().checkExists().forPath(path)));
    }

    public static boolean notExists(String path) {
        return !exists(path);
    }

    public static String create(String path, String value) {
        return ApplicationHandler.callMethodSuppressThrow(() -> obtainCuratorFramework().create().withMode(CreateMode.PERSISTENT).forPath(path, value.getBytes(Constants.CHARSET_UTF_8)));
    }

    public static String create(String path) {
        return create(path, "");
    }

    public static void notExistsCreate(String path, String value) {
        if (notExists(path)) {
            create(path, value);
        }
    }

    public static void notExistsCreate(String path) {
        notExistsCreate(path, "");
    }

    public static Stat setData(String path, String value) {
        return ApplicationHandler.callMethodSuppressThrow(() -> obtainCuratorFramework().setData().forPath(path, value.getBytes(Constants.CHARSET_UTF_8)));
    }

    public static List<String> getChildren(String path) {
        return ApplicationHandler.callMethodSuppressThrow(() -> obtainCuratorFramework().getChildren().forPath(path));
    }

    public static String getData(String path) {
        return ApplicationHandler.callMethodSuppressThrow(() -> new String(obtainCuratorFramework().getData().forPath(path), Constants.CHARSET_UTF_8));
    }

    public static void delete(String path) {
        ApplicationHandler.callMethodSuppressThrow(() -> obtainCuratorFramework().delete().forPath(path));
    }
}
