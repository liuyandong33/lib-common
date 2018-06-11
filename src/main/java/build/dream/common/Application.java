package build.dream.common;

import aj.org.objectweb.asm.Opcodes;
import build.dream.common.classloaders.CustomClassLoader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        ClassWriter classWriter = new ClassWriter(0);
        String className = "build/dream/common/HelloWorld";
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);

        MethodVisitor constructorMethodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructorMethodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        //执行父类的init初始化
        constructorMethodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        //从当前方法返回void
        constructorMethodVisitor.visitInsn(Opcodes.RETURN);
        constructorMethodVisitor.visitMaxs(1, 1);

        MethodVisitor runMethodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "run", "()V", null, null);
        //先获取一个java.io.PrintStream对象
        runMethodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        //将int, float或String型常量值从常量池中推送至栈顶  (此处将message字符串从常量池中推送至栈顶[输出的内容])
        runMethodVisitor.visitLdcInsn(UUID.randomUUID().toString());
        //执行println方法（执行的是参数为字符串，无返回值的println函数）
        runMethodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        runMethodVisitor.visitInsn(Opcodes.RETURN);
        runMethodVisitor.visitMaxs(1, 1);
        runMethodVisitor.visitEnd();

        classWriter.visitEnd();
        byte[] code = classWriter.toByteArray();

        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class exampleClass = customClassLoader.defineClassa("build.dream.common.HelloWorld", code, 0, code.length);
        System.out.println(exampleClass);
    }
}
