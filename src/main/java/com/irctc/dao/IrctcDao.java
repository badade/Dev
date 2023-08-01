package com.irctc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.irctc.entity.Ticket;

@Repository
public class IrctcDao {
public Map<String,Ticket>ticketmap=new HashMap<>();
public String saveTicket(Ticket resp) {
	ticketmap.put(resp.getPnr(),resp);
	return resp.getPnr();
}
public String updateTicket(Ticket resp) {
	String pnr=resp.getPnr();
ticketmap.put(pnr, resp);
return "Ticket Updated";
}
public String deleteTicket(String pnr) {
	ticketmap.remove(pnr);
	return "Ticket Deleted";
}
public Ticket getTicketByPnr(String pnr) {
	if(ticketmap.containsKey(pnr)) {
		return ticketmap.get(pnr);
	}
	return null;
}
}
