package build.dream.common.utils;

import org.springframework.util.ReflectionUtils;
import sun.management.VMManagement;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class JvmUtils {
    private static MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    private static RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    private static VMManagement vmManagement;

    static {
        Field field = ReflectionUtils.findField(memoryMXBean.getClass(), "jvm");
        ReflectionUtils.makeAccessible(field);
        vmManagement = (VMManagement) ReflectionUtils.getField(field, memoryMXBean);
    }

    public static List<String> getVmArguments() {
        return vmManagement.getVmArguments();
    }

    public static String getVmId() {
        return vmManagement.getVmId();
    }

    public static int getProcessId() {
        String vmId = vmManagement.getVmId();
        return Integer.parseInt(vmId.substring(0, vmId.indexOf("@")));
    }

    public static String getVmName() {
        return runtimeMXBean.getVmName();
    }

    public static String getVmVendor() {
        return runtimeMXBean.getVmVendor();
    }

    public static String getVmVersion() {
        return runtimeMXBean.getVmVersion();
    }

    public static String getSpecName() {
        return runtimeMXBean.getSpecName();
    }

    public static String getSpecVendor() {
        return runtimeMXBean.getSpecVendor();
    }

    public static String getSpecVersion() {
        return runtimeMXBean.getSpecVersion();
    }

    public static String getManagementSpecVersion() {
        return runtimeMXBean.getManagementSpecVersion();
    }

    public static String getClassPath() {
        return runtimeMXBean.getClassPath();
    }

    public static String getLibraryPath() {
        return runtimeMXBean.getLibraryPath();
    }

    public static boolean isBootClassPathSupported() {
        return runtimeMXBean.isBootClassPathSupported();
    }

    public static String getBootClassPath() {
        return runtimeMXBean.getBootClassPath();
    }

    public static List<String> getInputArguments() {
        return runtimeMXBean.getInputArguments();
    }

    public static long getUptime() {
        return runtimeMXBean.getUptime();
    }

    public static long getStartTime() {
        return runtimeMXBean.getStartTime();
    }

    public static Map<String, String> getSystemProperties() {
        return runtimeMXBean.getSystemProperties();
    }
}
