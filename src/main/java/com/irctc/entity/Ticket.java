package com.irctc.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement
public class Ticket {
private String name;
private String from;
private String to;
private String status;
private String pnr;
private Integer ticketid;
private Double cost;
private String jdate;
}
