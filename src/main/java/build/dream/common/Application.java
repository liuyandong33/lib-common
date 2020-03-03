package build.dream.common;

import build.dream.common.annotations.Transient;
import build.dream.common.basic.BasicDomain;
import build.dream.common.domains.saas.Tenant;
import build.dream.common.exceptions.CustomException;
import build.dream.common.utils.DatabaseUtils;
import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.NamingStrategyUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
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
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.BIGINT, Long.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.FLOAT, Double.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.VARCHAR, String.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.DATE, Date.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.TIMESTAMP, Date.class.getSimpleName());
        DATABASE_TYPE_JAVA_TYPE_MAP.put(Types.DECIMAL, Double.class.getSimpleName());
    }

    public static void main(String[] args) throws IOException, InterruptedException {
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

        System.out.println(new String(new byte[]{38, 61}));

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("python3 /Users/liuyandong/Desktop/test.py");
        process.waitFor();
        String result = IOUtils.toString(process.getInputStream());

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);
        System.out.println();

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            stringBuilder.append("[").append(entry.getKey()).append(String.format("]%n"));
            List<Map<String, String>> value = (List<Map<String, String>>) entry.getValue();
            for (Map<String, String> map : value) {
                stringBuilder.append(map.get("key")).append("=").append(map.get("value")).append(String.format("%n"));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * @param a: 补给站到家的距离
     * @param b: 补给站可以补给的能量
     * @param c: 初始能量
     * @param d: 家到学校的距离
     * @return
     */
    public static int test(int[] a, int[] b, int c, int d) {
        if (c >= d) {
            return 0;
        }

        if (c < a[0]) {
            return -1;
        }

        int total = 0;
        int position = 0;
        for (int index = 0; index < a.length; index++) {
            int end = obtainEnd(a, c, position);
            if (end == -1) {
                return -1;
            }
            int maxValue = obtainMaxValue(a, position, end);
            c += maxValue;
            total += 1;
        }
        return total;
    }

    public static int obtainEnd(int[] a, int b, int start) {
        for (int index = start; index < a.length; index++) {
            if (b < a[index] - a[start]) {
                return index;
            }
        }
        return -1;
    }

    public static int obtainMaxValue(int[] b, int start, int end) {
        int maxValue = 0;
        for (int index = start; index < end; index++) {
            if (maxValue < b[index]) {
                maxValue = b[index];
            }
        }
        return maxValue;
    }

    public void generateTupleCode(int size) {
        System.out.print("public class Tuple" + size + "<");
        for (int index = 1; index <= size; index++) {
            if (index == size) {
                System.out.print("T" + index);
                continue;
            }
            System.out.print("T" + index + ", ");
        }
        System.out.print("> {");
        System.out.println();

        for (int index = 1; index <= size; index++) {
            System.out.println("private T" + index + " _" + index + ";");
        }

        System.out.print("public Tuple" + size + "(");
        for (int index = 1; index <= size; index++) {
            if (index == size) {
                System.out.println("T" + index + " _" + index + ") {");
                continue;
            }

            System.out.print("T" + index + " _" + index + ", ");
        }
        for (int index = 1; index <= size; index++) {
            System.out.println("this._" + index + " = " + "_" + index + ";");
        }

        System.out.println("}");

        for (int index = 1; index <= size; index++) {
            System.out.println("public T" + index + " _" + index + "() {return _" + index + ";}");
        }

        System.out.println("}");
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

            if (Objects.nonNull(field.getAnnotation(Transient.class))) {
                continue;
            }

            String fieldName = field.getName();
            String columnName = NamingStrategyUtils.lowerCamelCaseToUnderscore(field.getName());
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

            if (Objects.nonNull(field.getAnnotation(Transient.class))) {
                continue;
            }

            String fieldName = field.getName();
            String columnName = NamingStrategyUtils.lowerCamelCaseToUnderscore(field.getName());
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

                System.out.println("/**\n* " + columnNameCommentMap.get(columnName) + "*/\nprivate " + DATABASE_TYPE_JAVA_TYPE_MAP.get(columnType) + " " + NamingStrategyUtils.underscoreToLowerCamelCase(columnName) + ";\n");
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
