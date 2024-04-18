package ict.ihu.gr.metadataphotomanager;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Context;
import android.widget.TextView;
import android.widget.EditText;
import android.util.Xml;

import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Profession {


    protected void createProfession(EditText txv){

    }




    // Method to process XML file
    protected void processXml(InputStream inputStream) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);

            doc.getDocumentElement().normalize();

            NodeList professionNodes = doc.getElementsByTagName("professionList");

            for (int i = 0; i < professionNodes.getLength(); i++) {
                Element professionElement = (Element) professionNodes.item(i);
                String professionId = professionElement.getAttribute("id");
                System.out.println("Profession ID: " + professionId);

                NodeList imageNodes = professionElement.getElementsByTagName("image");
                for (int j = 0; j < imageNodes.getLength(); j++) {
                    Element imageElement = (Element) imageNodes.item(j);
                    String imId = imageElement.getAttribute("imId");
                    System.out.println("Image ID: " + imId);

                    NodeList childNodes = imageElement.getChildNodes();
                    for (int k = 0; k < childNodes.getLength(); k++) {
                        if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                            String tagName = childNodes.item(k).getNodeName();
                            String textContent = childNodes.item(k).getTextContent();
                            System.out.println(tagName + ": " + textContent);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
