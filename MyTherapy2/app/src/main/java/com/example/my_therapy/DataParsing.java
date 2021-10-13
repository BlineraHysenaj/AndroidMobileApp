package com.example.my_therapy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DataParsing extends AppCompatActivity {

    ArrayList<HashMap<String, String>> contactList;
    Button btnParseJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_parsing);
        contactList=new ArrayList<>();
        btnParseJson=findViewById(R.id.idBtnParseXML);
        btnParseJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginXMLParsing();
            }
        });
    }
    private void beginXMLParsing(){
        InputStream is = null;
        try{

            is=getAssets().open("data.xml");
        } catch (IOException e){
            e.printStackTrace();
        }
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder =null;

        try {
            documentBuilder=documentBuilderFactory.newDocumentBuilder();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }

        Document doc=null;
        try{
            doc=documentBuilder.parse(is);
        } catch(IOException | SAXException e){
            e.printStackTrace();
        }
        Element element=doc.getDocumentElement();
        element.normalize();

        NodeList nList=doc.getElementsByTagName("rootnode");

        for (int i=0; i<nList.getLength();i++){
            Node node=nList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element element2= (Element) node;
                String id= element2.getElementsByTagName("Id").item(0).getTextContent();
                String name= element2.getElementsByTagName("Name").item(0).getTextContent();
                String eclass= element2.getElementsByTagName("eclass").item(0).getTextContent();
                addingValueToHashMap(id,name,eclass);
            }
        }
        ListView lv=findViewById(R.id.idLvJson);
        ListAdapter adapter= new SimpleAdapter(DataParsing.this,contactList,
                R.layout.list_item, new String[] {"Id", "Name", "eclass"},
                new int[] {R.id.idSNO, R.id.idName, R.id.ideclass});
        lv.setAdapter(adapter);
    }

    private void addingValueToHashMap(String id, String name, String eclass) {
        HashMap<String, String> contact = new HashMap<>();
        contact.put("Id", id);
        contact.put("Name", name);
        contact.put("eclass", eclass);
        contactList.add(contact);
    }

}