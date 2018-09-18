package build.dream.common.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\liuyandong\\Desktop\\智汇方象密钥";
        File directory = new File(path);
        File[] files = directory.listFiles();
        Map<String, File> fileMap = new HashMap<String, File>();
        for (File file : files) {
            fileMap.put(file.getName(), file);
        }

        StringBuilder stringBuilder = new StringBuilder("INSERT INTO new_land_org_info(org_no, private_key, md5_key) VALUES ");
        for (File file : files) {
            String name = file.getName();
            if (name.endsWith("pem")) {
                stringBuilder.append("(");
                String orgNo = name.substring(0, name.indexOf("_"));
                stringBuilder.append("'").append(orgNo).append("', ");

                String privateKey = obtainFileContent(file);
                privateKey = privateKey.substring(27, privateKey.length() - 25);

                stringBuilder.append("'").append(privateKey).append("', ");

                String md5Key = obtainFileContent(fileMap.get(orgNo + "_md5key.txt"));
                md5Key = md5Key.substring(md5Key.indexOf("【") + 1, md5Key.indexOf("】"));

                stringBuilder.append("'").append(md5Key).append("'), ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(";");
        System.out.println(stringBuilder.toString());
    }

    private static String obtainFileContent(File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        return stringBuilder.toString();
    }
}
