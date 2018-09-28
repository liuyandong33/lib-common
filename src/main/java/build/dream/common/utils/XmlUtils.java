package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlUtils {
    public static Map<String, String> xmlStringToMap(String xmlString) throws DocumentException {
        Document document = DocumentHelper.parseText(xmlString);
        return xmlDocumentToMap(document);
    }

    public static Map<String, String> xmlInputStreamToMap(InputStream inputStream) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        return xmlDocumentToMap(document);
    }

    private static Map<String, String> xmlDocumentToMap(Document document) {
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        Map<String, String> returnValue = new HashMap<String, String>();
        for (Element element : elements) {
            returnValue.put(element.getName(), element.getText());
        }
        return returnValue;
    }

    public static String mapToXmlString(Map<String, String> map) {
        StringBuilder xml = new StringBuilder("<xml>");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            xml.append("<").append(key).append(">");
            xml.append(String.format(Constants.CDATA_FORMAT, entry.getValue()));
            xml.append("</").append(key).append(">");
        }
        xml.append("</xml>");
        return xml.toString();
    }
}
