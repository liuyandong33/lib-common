package build.dream.common.classloaders;

public class CustomClassLoader extends ClassLoader {
    public Class<?> defineClassa(String name, byte[] bytes, int off, int length) throws ClassFormatError {
        return defineClass(name, bytes, off, length);
    }
}
