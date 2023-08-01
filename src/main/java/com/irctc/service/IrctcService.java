package com.irctc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.dao.IrctcDao;
import com.irctc.entity.Passenger;
import com.irctc.entity.Ticket;

@Service
public class IrctcService {
	@Autowired
private IrctcDao dao;
	
	public String bookTicket(Passenger req) {
		Ticket resp=new Ticket();
		resp.setTicketid(123);
		resp.setName(req.getName());
		resp.setStatus("CONFIRMED");
		resp.setCost(545.50);
		resp.setFrom(req.getFrom());
		resp.setTo(req.getTo());
		resp.setJdate(req.getJdate());
		resp.setPnr("PNR2354545");
		
		dao.saveTicket(resp);
		return "PNR2354545";
	}
	public Ticket getTicketByPnr(String pnr) {
		return dao.getTicketByPnr(pnr);
	}
	public String updateTicket(Ticket ticket) {
		return dao.updateTicket(ticket);
	}
	public String deleteTicket(String pnr) {
		return dao.deleteTicket(pnr);
	}
}
