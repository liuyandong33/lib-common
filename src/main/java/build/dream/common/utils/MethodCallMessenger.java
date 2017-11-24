package build.dream.common.utils;

public class MethodCallMessenger {
    private String className;
    private String methodName;
    private Class<?>[] argumentTypes;
    private Object[] arguments;
    private Object target;
    private Object returnValue;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getArgumentTypes() {
        return argumentTypes;
    }

    public void setArgumentTypes(Class<?>[] argumentTypes) {
        this.argumentTypes = argumentTypes;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    public MethodCallMessenger invokeMethod() throws ClassNotFoundException, NoSuchMethodException {
        return (MethodCallMessenger) ApplicationHandler.invokeMethod(Class.forName(className), methodName, argumentTypes, arguments, target);
    }
}
