package com.creatshare.answerapi.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class ParseXML {

    public static Object parseXmlString(String xml,String quId) throws DocumentException {

        Document doc = DocumentHelper.parseText(xml);
        Element result = doc.getRootElement();
        List<Element> elements = result.elements();
        for (Element e:elements
             ) {
            System.out.println(e.element("quId").getText());
            System.out.println(e.element("quAnswer").getText());
            if(e.element("quId").getText().equals(quId)){
                return e.element("quAnswer").getText();
            }
        }
        return null;
    }

}
