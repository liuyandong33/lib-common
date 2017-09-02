package build.dream.common.utils;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PackageUtils {
    public static List<Class<?>> getAllClasses(Package pack, boolean childPackage) throws IOException {
        String packagePath = pack.getName().replaceAll("\\.", File.separator);
        Enumeration<URL> urls = PackageUtils.class.getClassLoader().getResources(packagePath);
        List<Class<?>> classes = new ArrayList<Class<?>>();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                classes.addAll(getClassesByFilePath(url, packagePath, childPackage));
            } else if ("jar".equals(protocol)) {
                classes.addAll(getClassesByJarPath(url, packagePath, childPackage));
            }
        }
        return classes;
    }

    public static List<Class<?>> getClassesByFilePath(URL url, String packagePath, boolean childPackage) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String path = url.getPath();
        int classPathLength = path.length() - packagePath.length();
        File file = new File(path);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                if (childPackage) {
                    classes.addAll(getClassesByFilePath(url, packagePath, childPackage));
                }
            } else {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    String className = childFilePath.substring(classPathLength, childFilePath.lastIndexOf(".")).replaceAll(File.separator, ".");
                    try {
                        classes.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {}
                }
            }
        }
        return classes;
    }

    public static List<Class<?>> getClassesByJarPath(URL url, String packagePath, boolean childPackage) throws IOException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            String entryName = jarEntry.getName();
            if (entryName.startsWith(packagePath) && entryName.endsWith(".class")) {
                String className = null;
                if (childPackage) {
                    className = entryName.substring(0, entryName.lastIndexOf(".")).replaceAll(File.separator, ".");
                } else {
                    if (entryName.split(File.separator) == packagePath.split(File.separator)) {
                        className = entryName.substring(0, entryName.lastIndexOf(".")).replaceAll(File.separator, ".");
                    }
                }
                if (StringUtils.isNotBlank(className)) {
                    try {
                        classes.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {}
                }
            }
        }
        return classes;
    }
}
