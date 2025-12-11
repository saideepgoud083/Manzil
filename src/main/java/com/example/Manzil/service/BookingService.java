package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.AvailabeVechileDto;
import com.example.Manzil.Dto.BookingDto;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Vehicle;
import com.example.Manzil.repository.CustomerRepositry;
import com.example.Manzil.repository.DriverRepository;
import com.example.Manzil.repository.VechileRepositry;
import com.example.Manzil.repository.bookingRepository;
import com.example.Manzil.service.Exception.vechilenotfound;
import java.time.*;

@Service
public class BookingService {
	@Autowired
	bookingRepository br;
	@Autowired
	private CustomerRepositry cr;
	@Autowired
	private VechileRepositry vr;
	
	@Autowired
	private	DriverRepository dr;
	
	public responcestucture<Booking> bookVechilee(long mob, BookingDto bd) {

		  responcestucture<Booking> rs = new responcestucture<>();
		 Customer c = cr.findByMob(mob);
		    if (c == null) {
		        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
		        rs.setMasg("Customer not found");
		        rs.setData(null);
		        return rs;
		    }
		    
		int vechileid=   bd.getV().getVehicleId();
		
		 Vehicle v=   vr.findById(vechileid).orElseThrow(()-> new vechilenotfound());
		 LocalDateTime now = LocalDateTime.now();

		 
		 Booking b=new Booking();
		 b.setCust(c);
		 b.setVeh(v);
		 b.setSourcelocation(bd.getSourcelocation());
		 b.setDestinationlocation(bd.getDestinationlocation());
		 b.setFare(bd.getFare());
		 b.setDistancetravlled(bd.getDistancetravelled());
		 b.setEstimatedtimerequired(bd.getEstimatedtime());
		 b.setDatebooked(now+"");
		 
		 br.save(b);
		 
		 c.getBlist().add(b);
		v.getD().getBlist().add(b);
		v.setAvailabilityStatus("BOOKED");
		cr.save(c);
		dr.save(v.getD());
		
		rs.setStatuscode(HttpStatus.OK.value());
        rs.setMasg("Booking Successfully");
        rs.setData(b);
        return rs;

		
	}

	public void SeeallbookingHistory(long mob) {
		  responcestucture<Booking> rs = new responcestucture<>();
		 Customer c = cr.findByMob(mob);
		    if (c == null) {
		        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
		        rs.setMasg("Customer not found");
		        rs.setData(null);
		     //   return rs;
		    }
		
	}

}
