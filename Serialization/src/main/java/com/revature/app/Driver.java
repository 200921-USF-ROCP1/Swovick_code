package com.revature.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.classes.DemoClass;
import com.revature.classes.JsonClass;
import com.revature.classes.XmlClass;

public class Driver {
	public static void main(String[] args) {
		DemoClass demo = new DemoClass(), empty, empty2, empty3;
		demo.setB(true);
		demo.setI(10);
		demo.setS("Hello");
		String json = marshalToJson(demo);
		System.out.println(json);
		empty = unmarshalFromJson(json);
		System.out.println(empty.equals(demo));
		String xml = marshalToXml(demo);
		System.out.println(xml);
		empty2= unmarshalFromXml(xml);
		//System.out.println(empty2);
		System.out.println(empty2.equals(demo));
		BufferedReader jsonData = new BufferedReader(new StringReader(json));
		empty3 = unmarshalFromJson(jsonData);
		System.out.println(empty3.equals(empty));
	}
	public static DemoClass unmarshalFromJson(BufferedReader reader) {
		String json = reader.toString();
		DemoClass demoClass = unmarshalFromJson(json);
		return demoClass;
	}
	public static String marshalToJson(DemoClass demoClass) {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		try {
			result = mapper.writeValueAsString(demoClass);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static DemoClass unmarshalFromJson(String Json) {
		DemoClass demoClass = new DemoClass();
		ObjectMapper mapper = new ObjectMapper();
		try {
			demoClass = mapper.readValue(Json, DemoClass.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return demoClass;
	}
	public static String marshalToXml(DemoClass demoClass) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(DemoClass.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter newFile = new StringWriter();
			marshaller.marshal(demoClass, newFile);
			result = newFile.toString();
		}
		catch (Exception e) {
			//System.out.println("Failed");
			e.printStackTrace();
		}
		return result;
	}
	public static DemoClass unmarshalFromXml(String xml) {
		DemoClass demoClass = null;
		try {
			JAXBContext context = JAXBContext.newInstance(DemoClass.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			demoClass = new DemoClass();
			demoClass = (DemoClass) unmarshaller.unmarshal(new StringReader(xml));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return demoClass;
	}
}
