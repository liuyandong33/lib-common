package build.dream.common;

import build.dream.common.annotations.Transient;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.models.umpay.ActiveScanCodeOrderModel;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.DatabaseUtils;
import build.dream.common.utils.NamingStrategyUtils;
import build.dream.common.utils.UmPayUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    private static final Map<Integer, String> DATABASE_TYPE_JAVA_TYPE_MAP = new HashMap<Integer, String>();

    static {
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.TINYINT, Integer.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.INTEGER, Integer.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.BIGINT, BigInteger.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.FLOAT, BigDecimal.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.VARCHAR, String.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.DATE, Date.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.TIMESTAMP, Date.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.DECIMAL, BigDecimal.class.getSimpleName());
    }

    public static void main(String[] args) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
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

        String url = "jdbc:mysql://node1:3306/catering-db?serverTimezone=GMT%2B8&useSSL=true";
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "root";
        String tableName = "assemble_activity";
//        reverseJavaCode(url, driverClassName, user, password, tableName);

        ActiveScanCodeOrderModel activeScanCodeOrderModel = ActiveScanCodeOrderModel.builder()
                .merId("60000100")
                .privateKey("MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMboog7ZX3znQzD6bJlNBK9JTjpM/4R8+GzK1+ko66BWGELCgFqZhLeRs8sO44OqNvTwzO42F+Yy+a1AJzb7jLMYyjr1JYqitji+iTCs205JhPNpLyHbH4TbFZVKLvUuTNamNTJ2J/PuS/hztgQOBt3Uy/bxotxIVNHXQGJWvPaxAgMBAAECgYA740cH2YLahHbChGO2NG44qIWZIB2+sjHJ77jaRqvK9qEPWKh0nsxKyN+tP6pYtiMd1HKfNkIz2R07gJlOAKb3rY7w8w9aOLeafAQ6OpGBjBVUBGZjYFseK32XZyOxm5vXv87mOvc7tV7awBzQS3rKBftKrABMuYpkbHe/nnFKwQJBAOcX5nhSHiFwifPEeZ2y1FFZz8SmougxgpAM0qw8mQvf1LGhqf5uKJI2g1jLeci0zC9gCMFVuKte7sYwiK9mPoUCQQDcWLndgMos3dm26MDUx3uBcklZJl1WRuzGSfSH5yQLatYbuRQyok2Os1JZP4ocfaQ9nR5onwVIR1ZXU3gCjx09AkEAs6oZPKJbWpQsLKEsDDbkavrwVWtYbD1RzLyrbc0PD/RNYGzXxT/Pux02sOpBHJGzzYFUTTtf/5wm9170ZamQIQJBAKpnp54IqtIV4/hTekVT3EzYkKb0R3ygrx4ONaEgfTyjK+AWuusJn8c7IPVKcUnlVK4do1WvnUsveDNips371dUCQDYpYmpDELYilNu6DR+6a9uXcVJLFmfQAbnsIkyzoiSLiAnWdjBGhG5BBgRKdzjZsF1GRcLmZiYj7KrPtHB8BRE=")
                .platformCertificate("MIIDNDCCAp2gAwIBAgICLVkwDQYJKoZIhvcNAQEFBQAwPTEOMAwGA1UEBhMFQ0hJTkExKzApBgNVBAMTIkNISU5BVEVMRUNPTSBDRVJUSUZJQ0FURSBBVVRIT1JJVFkwHhcNMDEwMzIxMTA0NzEzWhcNMDMwMzIxMTA0NzEzWjBcMQswCQYDVQQGEwJDTjERMA8GA1UEChMItPPBrLXn0MUxETAPBgNVBAgTCFNoZW55YW5nMRQwEgYDVQQDEwsxOTIuMTY4LjIuMjERMA8GA1UEBxMIU2hlbnlhbmcwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAMZYC7inporVKJCo0pPWdOBjADxzPRF1719G2YskDHVDEuqt6sBRWX+65dXs1AVKROKmi6jdzAQSlp7z3brsB4skHMo9sqdQgPolgZvCersKJFHgTbjjNyCoTyOjwOeRsfcqSJaiehQwPW4fLpNQW/lbvOuFrP8Tn0xWZvOunVPDAgMBAAGjggEiMIIBHjAJBgNVHRMEAjAAMEYGA1UdHwQ/MD0wO6A5oDeGNWxkYXA6Ly8yMDIuMTAzLjY1LjE4L291PWNhLG91PXN5c3RlbSxvdT1jYTEsbz1jdCxjPUNOMC8GCCsGAQUFBwEBBCMwITAfBggrBgEFBQcwAYYTLDIwMi4xMDMuNjUuMTg6OTAwMzAPBghghkgBhvhDDAQDAgEBMBIGCGCGSAGG+EMOBAYWBDI3RjkwGQYIYIZIAYb4QxAEDRYLMTkyLjE2OC4yLjIwEAYIYIZIAYb4QxEEBBYCTlQwGgYIYIZIAYb4QxkEDhYMOTe9ybfRt/7O8cb3MBkGCGCGSAGG+EMbBA0WCzE5Mi4xNjguMi4yMA8GCGCGSAGG+EMaBAMCAQMwDQYJKoZIhvcNAQEFBQADgYEAckkH/Vem5+kXPSGgkowjPwv47XXNbD0hGRMTVXm5PC2kY/wNApQh3lv7Tf5k3UQEoFBACxf6XJtuxf6S0uKBS4ySMKdpbMbOUvtwu6ycQUQTRAs1EBgoh1zyuafU2D3iyHQM8etHxaSePXZOZXFkkvBJemyPz23HAyIn5SKQ2Es=")
                .topic("")
                .goodsInf("订单支付")
                .orderId("aaaaaaaa")
                .amount(1)
                .scanCodeType(Constants.UM_PAY_SCAN_CODE_TYPE_WECHAT)
                .build();
        Map<String, String> result = UmPayUtils.activeScanCodeOrder(activeScanCodeOrderModel);
        int a = 100;

        String aa = UmPayUtils.encrypt("aaa", activeScanCodeOrderModel.getPlatformCertificate());
        System.out.println(aa);
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

    private static void reverseJavaCode(String url, String driverClassName, String user, String password, String tableName) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + tableName + " LIMIT 1");

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet1 = databaseMetaData.getColumns(null, "catering-db", tableName, "%");

            Map<String, String> columnNameCommentMap = new HashMap<String, String>();
            int count = resultSet1.getMetaData().getColumnCount();
            while (resultSet1.next()) {
                for (int index = 1; index <= count; index++) {
                    columnNameCommentMap.put(resultSet1.getString("COLUMN_NAME"), resultSet1.getString("REMARKS"));
                }
            }

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int index = 1; index <= columnCount; index++) {
                String columnName = resultSetMetaData.getColumnName(index);
                int columnType = resultSetMetaData.getColumnType(index);
                if (BasicDomain.ColumnName.ID.equals(columnName)) {
                    continue;
                }

                if (BasicDomain.ColumnName.CREATED_TIME.equals(columnName)) {
                    continue;
                }

                if (BasicDomain.ColumnName.CREATED_USER_ID.equals(columnName)) {
                    continue;
                }

                if (BasicDomain.ColumnName.UPDATED_TIME.equals(columnName)) {
                    continue;
                }

                if (BasicDomain.ColumnName.UPDATED_USER_ID.equals(columnName)) {
                    continue;
                }

                if (BasicDomain.ColumnName.UPDATED_REMARK.equals(columnName)) {
                    continue;
                }

                if (BasicDomain.ColumnName.DELETED_TIME.equals(columnName)) {
                    continue;
                }

                if (BasicDomain.ColumnName.DELETED.equals(columnName)) {
                    continue;
                }

                System.out.println("/**\n* " + columnNameCommentMap.get(columnName) + "*/\nprivate " + DATABASE_TYPE_JAVA_TYPE_MAP.get(columnType) + " " + NamingStrategyUtils.underscoreToCamelCase(columnName) + ";\n");
            }
        } catch (Exception e) {
            if (e instanceof CustomException) {
                CustomException customException = (CustomException) e;
                throw customException;
            } else {
                throw new RuntimeException(e);
            }
        } finally {
            DatabaseUtils.closeResultSet(resultSet);
            DatabaseUtils.closeStatement(statement);
            DatabaseUtils.closeConnection(connection);
        }
    }
}
