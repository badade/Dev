package com.irctc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.entity.Passenger;
import com.irctc.entity.Ticket;
import com.irctc.service.IrctcService;

@RestController
public class IrctcController {
@Autowired
private IrctcService service;

@PostMapping(
		value="/bookticket",
		consumes= {"application/xml","application/json"})
public ResponseEntity<String>bookTicket(@RequestBody Passenger req){
	String pnr=service.bookTicket(req);
	String msg="Ticket Booking Completed :: "+pnr;
	return new ResponseEntity<>(msg,HttpStatus.CREATED);
}

@GetMapping(value="/ticket/{pnr}",
	produces= {"application/xml","application/json"})
public ResponseEntity<Ticket>getTicket(@PathVariable String pnr ){
	Ticket ticket=service.getTicketByPnr(pnr);
	return new ResponseEntity<>(ticket,HttpStatus.OK);
	}

@DeleteMapping("/ticket/{pnr}")
public ResponseEntity<String>deleteTicket(@PathVariable String pnr){
  String msg=service.deleteTicket(pnr);
  return new ResponseEntity<>(msg,HttpStatus.OK);
}

@PutMapping("/ticket/update")
public ResponseEntity<String>updateTicket(@RequestBody Ticket ticket){
	String msg=service.updateTicket(ticket);
	return new ResponseEntity<>(msg,HttpStatus.OK);
}
}
