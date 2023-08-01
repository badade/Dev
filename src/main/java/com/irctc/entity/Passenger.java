package com.irctc.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;


@Data
@JacksonXmlRootElement
public class Passenger {
private	String name;
private	String email;
private	String from;
private	String to;
private	String jdate;
private	Long phno;
private	String trainnum;
}
