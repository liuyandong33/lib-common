package build.dream.common.utils;

import java.io.File;

public class FileUtils {
    public static void createDirectoryIfNotExists(String path) {
        createDirectoryIfNotExists(new File(path));
    }

    public static void createDirectoryIfNotExists(File directory) {
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
