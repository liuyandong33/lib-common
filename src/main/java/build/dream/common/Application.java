package build.dream.common;

import build.dream.common.annotations.Transient;
import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.constants.HttpHeaders;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.NamingStrategyUtils;
import build.dream.common.utils.WebUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, InvalidKeyException, SignatureException, KeyManagementException {
        /*String packageName = "build.dream.common.catering.domains";
        List<Class<?>> classes = obtainAllClass(packageName);
        for (Class<?> clazz : classes) {
            generateFieldNameInnerClassCode(clazz);
        }*/

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(path);
        path = path.replace("out/production/classes", "src/main/java");
        path = path + Tenant.class.getName().replaceAll("\\.", "/") + ".java";
        System.out.println(path);

        String sourcePath = Tenant.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(sourcePath);

//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\liuyandong\\Desktop\\机构收单私钥.pfx");

        /*char[] password = "111111".toCharArray();
        keyStore.load(fileInputStream, password);
//        fileInputStream.close();

        Enumeration<String> enumeration = keyStore.aliases();
        String keyAlias = null;
        if (enumeration.hasMoreElements())// we are readin just one certificate.
        {
            keyAlias = enumeration.nextElement();
            System.out.println("alias=[" + keyAlias + "]");
        }

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias, password);
        Certificate certificate = keyStore.getCertificate(keyAlias);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(UUID.randomUUID().toString().getBytes(Constants.CHARSET_UTF_8));
        System.out.println(signature.sign());*/


        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Message><head><BizTrackNo>40AA1806222018062202265874694457</BizTrackNo><ChannelNbr>03</ChannelNbr><ChnlId>40</ChnlId><ClientIp>127.0.0.1</ClientIp><MerNbr>010020170801000001</MerNbr><ReqSeqNo>180622AA00000033</ReqSeqNo><ReqTime>20180622022658746</ReqTime><Summery/><TrsCode>qr0001</TrsCode></head><body><AuthCode>081lXf3u0zRVcc15cv4u0W1f3u0lXf3M</AuthCode><CurrencyCd>CNY</CurrencyCd><MerSeqNbr>2018062255555210</MerSeqNbr><MerTransDateTime>20180622022658</MerTransDateTime><MerUrl>http://web.clearing.com/notify/union</MerUrl><OrderTitle>测试商户2-商品购买</OrderTitle><PayTypCd>C</PayTypCd><SubMerchantId>AA2010010100002</SubMerchantId><SubMerchantName>测试商户2</SubMerchantName><TransAmt>0.01</TransAmt><Signature>Z3i1XPB8LrY59H/g/MoJIVjsVT8q9fGnG/0ICF/P0M2Xu0NUyTC9vmUs/31EfvS9ir9Ri9LNSJcU8HwICvFPywrmPBKVG7uesnoDIjedBGp0sfKCmJkG5Q417TPcXQnV4/8EbTpQ0+KFm2c0sfbtkS30RdTzcL568uGxkrPRVcY=</Signature></body></Message>";

        SSLSocketFactory sslSocketFactory = WebUtils.initSSLSocketFactory(fileInputStream, "111111", Constants.PKCS12, Constants.TRUST_MANAGERS);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, "application/xml;charset=UTF-8");

        WebResponse webResponse = WebUtils.doPostWithRequestBody("http://221.176.112.3:8033/qrcode/QrCodeGateWay.do", headers, requestBody, null);
        System.out.println(webResponse.getResult());
    }

    public static List<Class<?>> obtainAllClass(String packageName) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(packageName.replaceAll("\\.", "/"));
        String path = url.getPath();
        File directory = new File(path);
        File[] files = directory.listFiles();

        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.contains("$")) {
                continue;
            }
            String className = packageName + "." + fileName.substring(0, fileName.length() - 6);
            classes.add(Class.forName(className));
        }
        return classes;
    }

    public static void printArray(int array[]) {
        int length = array.length;
        for (int index = 0; index < length; index++) {
            System.out.print(array[index]);
            if (index != length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static int[] buildRandomArray(int length, int maxValue) {
        int[] array = new int[length];
        for (int index = 0; index < length; index++) {
            array[index] = Double.valueOf(Math.random() * maxValue).intValue();
        }
        return array;
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int array[]) {
        int length = array.length;
        for (int index = 0; index < length - 1; index++) {
            for (int innerIndex = 0; innerIndex < length - 1 - index; innerIndex++) {
                if (array[innerIndex] < array[innerIndex + 1]) {
                    int temp = array[innerIndex];
                    array[innerIndex] = array[innerIndex + 1];
                    array[innerIndex + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 假设数组的长度为: length
     * 第一次循环，选出索引从 array[0]~array[length - 1] 中选出最大值或最小值与array[0]交换
     * 第二次循环，选出索引从 array[1]~array[length - 1] 中选出最大值或最小值与array[1]交换
     * 第三次循环，选出索引从 array[2]~array[length - 1] 中选出最大值或最小值与array[2]交换
     * ...
     *
     * @param array
     */
    public static void selectionSort(int array[]) {
        int length = array.length;
        for (int index = 0; index < length; index++) {
            int position = index;
            for (int innerIndex = index; innerIndex < length; innerIndex++) {
                if (array[innerIndex] < array[position]) {
                    position = innerIndex;
                }
            }

            if (index != position) {
                int temp = array[index];
                array[index] = array[position];
                array[position] = temp;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertionSort(int array[]) {
        int length = array.length;

        for (int index = 1; index < length; index++) {
            for (int innerIndex = index; innerIndex > 0 && array[innerIndex] > array[innerIndex - 1]; innerIndex--) {
                int temp = array[innerIndex];
                array[innerIndex] = array[innerIndex - 1];
                array[innerIndex - 1] = temp;
            }
        }
    }

    private static String obtainFileContent(File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

        char[] buffer = new char[1024];
        int length = -1;
        while ((length = inputStreamReader.read(buffer, 0, 1024)) != -1) {
            stringBuilder.append(buffer, 0, length);
        }

        inputStreamReader.close();
        inputStream.close();
        return stringBuilder.toString();
    }

    /**
     * 生成列名常量类代码
     *
     * @param domainClass
     * @throws IOException
     */
    private static void generateFieldNameInnerClassCode(Class<?> domainClass) throws IOException {
        // 生成列名常量类代码
        StringBuilder fieldNameInnerClassCode = new StringBuilder("public static final class FieldName extends BasicDomain.FieldName {");
        Field[] fields = domainClass.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                continue;
            }

            if (field.getAnnotation(Transient.class) != null) {
                continue;
            }

            String fieldName = field.getName();
            String columnName = NamingStrategyUtils.camelCaseToUnderscore(field.getName());
            fieldNameInnerClassCode.append("public static final String ").append(columnName.toUpperCase()).append(" = ").append("\"").append(fieldName).append("\";");
        }
        fieldNameInnerClassCode.append("}");
        writeCode(domainClass, fieldNameInnerClassCode.toString());
    }

    /**
     * 生成列名常量类代码
     *
     * @param domainClass
     * @throws IOException
     */
    public static void generateColumnNameInnerClassCode(Class<?> domainClass) throws IOException {
        StringBuilder columnNameInnerClassCode = new StringBuilder("public static final class ColumnName extends BasicDomain.ColumnName {");
        Field[] fields = domainClass.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                continue;
            }

            if (field.getAnnotation(Transient.class) != null) {
                continue;
            }

            String fieldName = field.getName();
            String columnName = NamingStrategyUtils.camelCaseToUnderscore(field.getName());
            columnNameInnerClassCode.append("public static final String ").append(columnName.toUpperCase()).append(" = ").append("\"").append(columnName).append("\";");
        }
        columnNameInnerClassCode.append("}");
        writeCode(domainClass, columnNameInnerClassCode.toString());
    }

    /**
     * 生成建造者模式代码
     *
     * @param domainClass
     */
    public static void generateBuildPatternCode(Class<?> domainClass) throws IOException {
        Class<?> cloneDomainClass = domainClass;
        String simpleName = domainClass.getSimpleName();
        StringBuilder code = new StringBuilder("public static class Builder {private final " + simpleName + " instance = new " + simpleName + "();");
        while (cloneDomainClass != Object.class) {
            Field[] fields = cloneDomainClass.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }
                String name = field.getName();
                code.append("public Builder " + name + "(" + field.getType().getSimpleName() + " " + name + ") { instance.set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(" + name + ");return this;}");
            }
            cloneDomainClass = cloneDomainClass.getSuperclass();
        }
        code.append("public " + simpleName + " build() {");
        String variableName = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
        code.append(simpleName).append(" ").append(variableName).append(" = ").append("new ").append(simpleName).append("();");

        cloneDomainClass = domainClass;
        while (cloneDomainClass != Object.class) {
            Field[] fields = cloneDomainClass.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }

                String name = field.getName();
                String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                String getMethodName = null;
                if (field.getType() == boolean.class) {
                    getMethodName = "is" + name.substring(0, 1).toUpperCase() + name.substring(1);
                } else {
                    getMethodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                }
                code.append(variableName).append(".").append(setMethodName).append("(").append("instance.").append(getMethodName).append("());");
            }
            cloneDomainClass = cloneDomainClass.getSuperclass();
        }

        code.append("return ").append(variableName).append(";}}");
        code.append("public static Builder builder() {return new Builder();}");
        writeCode(domainClass, code.toString());
    }

    public static void writeCode(Class<?> domainClass, String code) throws IOException {
        String sourcePath = domainClass.getProtectionDomain().getCodeSource().getLocation().getPath();
        File file = new File(sourcePath);
        String fileContent = obtainFileContent(file);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.write(fileContent.substring(0, fileContent.lastIndexOf("}")));
        printWriter.println(code);
        printWriter.println("}");
        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }

    private static void testSort() {
        int array[] = buildRandomArray(10, 100);
        System.out.print("排序前：");
        printArray(array);

//        bubbleSort(array);
//        selectionSort(array);
        insertionSort(array);

        System.out.print("排序后：");
        printArray(array);
    }
}
