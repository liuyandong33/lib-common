package build.dream.common;

import aj.org.objectweb.asm.Opcodes;
import build.dream.common.classloaders.CustomClassLoader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        ClassWriter classWriter = new ClassWriter(0);
        String className = "build/dream/common/HelloWorld";
        classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);


        MethodVisitor constructorMethodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructorMethodVisitor.visitCode();
        constructorMethodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        constructorMethodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "V()");
        constructorMethodVisitor.visitInsn(Opcodes.RETURN);
        constructorMethodVisitor.visitMaxs(1, 1);
        constructorMethodVisitor.visitEnd();

        classWriter.visitEnd();
        byte[] code = classWriter.toByteArray();

        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class exampleClass = customClassLoader.defineClassa("build.dream.common.HelloWorld", code, 0, code.length);
        System.out.println(exampleClass);
    }
}
