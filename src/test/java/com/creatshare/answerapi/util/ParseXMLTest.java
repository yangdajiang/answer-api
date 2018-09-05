package com.creatshare.answerapi.util;

import org.dom4j.DocumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParseXMLTest {

    @Test
    public void parseXmlString() throws DocumentException {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                +"<answers>"
                +"  <answer>"
                +"      <quId>1</quId>"
                +"      <quAnswer>a</quAnswer>"
                +"  </answer>"
                +"  <answer>"
                +"      <quId>2</quId>"
                +"      <quAnswer>b</quAnswer>"
                +"  </answer>"
                +"  <answer>"
                +"      <quId>3</quId>"
                +"      <quAnswer>c</quAnswer>"
                +"  </answer>"
                +"</answers>";

        String answer = (String) ParseXML.parseXmlString(xml,"2");
        System.out.println(xml);
        System.out.println(answer);
    }
}