package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Manzil.responcestucture;
import com.example.Manzil.Dto.ActiveBookingDto;
import com.example.Manzil.Dto.AvailabeVechileDto;
import com.example.Manzil.Dto.BookingDto;
import com.example.Manzil.entity.Booking;
import com.example.Manzil.entity.Customer;
import com.example.Manzil.entity.Driver;
import com.example.Manzil.entity.Vehicle;
import com.example.Manzil.repository.CustomerRepositry;
import com.example.Manzil.repository.DriverRepository;
import com.example.Manzil.repository.VechileRepositry;
import com.example.Manzil.repository.bookingRepository;
import com.example.Manzil.service.Exception.DriverAlreadyExistsException;
import com.example.Manzil.service.Exception.bookingnotfind;
import com.example.Manzil.service.Exception.vechilenotfound;
import java.time.*;
import java.util.List;

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
	
	@Autowired
	private EmailService es;
	public responcestucture<Booking> bookVechilee(long mob, BookingDto bd) {

	    responcestucture<Booking> rs = new responcestucture<>();

	    Customer c = cr.findByMob(mob);
    if (c == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
        rs.setMasg("Customer not found");
        rs.setData(null);
        return rs;
   }

  int vechileid = bd.getV().getVehicleId();

  Vehicle v = vr.findById(vechileid)
               .orElseThrow(() -> new vechilenotfound());

  LocalDateTime now = LocalDateTime.now();
int driverid=bd.getD().getDriverId();
Driver d=dr.findById(driverid).orElseThrow(()-> new DriverAlreadyExistsException() );
   Booking b = new Booking();
   
   int otp = (int)(Math.random() * 9000) + 1000;
   b.setOtp(otp);

   b.setDriver(d);
   b.setCust(c);
  b.setVeh(v);
  b.setSourcelocation(bd.getSourcelocation());
 b.setDestinationlocation(bd.getDestinationlocation());
 b.setFare(bd.getFare());
 double baseFare = v.getPricePerKm() * bd.getDistancetravelled();
 double totalFare = baseFare;
 int penaltyCount = c.getPanality();
 if (penaltyCount > 1) {
     totalFare = baseFare + (baseFare / 100) * penaltyCount * 10;
 }
 b.setFare(totalFare);

	

   b.setDistancetravlled(bd.getDistancetravelled());
   b.setEstimatedtimerequired(bd.getEstimatedtime());
   b.setDatebooked(now.toString());
b.setBookingStatus("BOOKED");

	    Booking saved = br.save(b);
 

    // Maintain relationships
    c.getBlist().add(saved);
   v.getDriver().getBlist().add(saved);

    v.setAvailabilityStatus("BOOKED");
    v.getDriver().setDriverStatus("BOOKED");
     c.setFlag(true);
  // Important Saves!
  cr.save(c);
    dr.save(v.getDriver());
    vr.save(v);   // FIX — missing in your code
    rs.setStatuscode(HttpStatus.OK.value());
    rs.setMasg("Booking Successfully");
    rs.setData(saved);
    es.sendMail(c.getEmailid()," Your ride has been booked \"+ b.getId()+\" booking details/   booking date= \"+b.getDatebooked()+\" DropLocation= \"+b.getDestinationlocation()+\" Amount to be paid= \"+b.getFare()+\" our driver = \"+d.getDriverName()+\" Driver MobileNumber= \"+d.getMobileNum()+\" Driver will contact Shortly before pickup//-----ThankYou For Chossing Manzil----","Booking Confirmation");
    es.sendMail(d.getMailId(), " Customer details"+c+"booking assigned by= "+d.getDriverName()+" booking details/ booking id ="+b.getId()+ "booking date ="+b.getDatebooked()+" Customer name= "+c.getName()+" pickupLocation= "+c.getCurrentLocation()+" DropLocation = "+b.getDestinationlocation()+"Fare amount= "+b.getFare(), "your vechile booked successfully");
    
    
    return rs;
	}

	
	
	
	
	
	
	
/*	public responcestucture<Booking> bookVechilee(long mob, BookingDto bd) {

	    responcestucture<Booking> rs = new responcestucture<>();

	    // 1️⃣ Find customer
	    Customer c = cr.findByMob(mob);
	    if (c == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Customer not found with mobile: " + mob);
	        rs.setData(null);
	        return rs;
	    }

	    // 2️⃣ Get vehicle from DTO
	    int vehicleId = bd.getV().getVehicleId();
	    Vehicle v = vr.findById(vehicleId)
	                  .orElseThrow(() -> new vechilenotfound());

	    // 3️⃣ Get driver from the vehicle
	    Driver d = v.getDriver();
	    if (d == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Driver not assigned to this vehicle");
	        rs.setData(null);
	        return rs;
	    }

	    // 4️⃣ Create booking object
	    LocalDateTime now = LocalDateTime.now();

	    Booking b = new Booking();
	    b.setCust(c);
	    b.setVeh(v);
	    b.getVeh().setDriver(d);//(d);                             // Important: add driver to booking
	    b.setSourcelocation(bd.getSourcelocation());
	    b.setDestinationlocation(bd.getDestinationlocation());
	    b.setFare(bd.getFare());
	    b.setDistancetravlled(bd.getDistancetravelled());
	    b.setEstimatedtimerequired(bd.getEstimatedtime());
	    b.setDatebooked(now.toString());
	    b.setBookingStatus("BOOKED");

	    // 5️⃣ Save booking
	    Booking saved = br.save(b);

	    // 6️⃣ Maintain relationships
	    c.getBlist().add(saved);      // add to customer booking history
	    d.getBlist().add(saved);      // add to driver booking history (Correct)
	    v.setAvailabilityStatus("BOOKED");
	    d.setDriverStatus("BOOKED");

	    // 7️⃣ Save all affected entities
	    cr.save(c);
	    dr.save(d);
	    vr.save(v);

	    // 8️⃣ Response
	    rs.setStatuscode(HttpStatus.ACCEPTED.value());
	    rs.setMasg("Booking completed successfully");
	    rs.setData(saved);

	    return rs;
	}*/

	
	
	
	
	
	
	
	
	/*********couystomer*/
	public ResponseEntity<responcestucture<List<Booking>>> seebookinghistory(long mob) {

	    responcestucture<List<Booking>> rs = new responcestucture<>();

	    // 1. Fetch customer
	    Customer c = cr.findByMob(mob);

	    // 2. If customer not found → return 400
	    if (c == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Customer not found for mobile: " + mob);
	        rs.setData(null);
	        return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	    }

	    // 3. Get booking list
	    List<Booking> blist = c.getBlist();

	    // 4. Success response
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMasg("Booking history fetched successfully");
	    rs.setData(blist);

	    return new ResponseEntity<responcestucture<List<Booking>>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<responcestucture<List<Booking>>> seeDriverbookhistory(long mob) {

	    responcestucture<List<Booking>> rs = new responcestucture<>();

	    // 1. Fetch driver
	    Driver d = dr.findByMobileNum(mob);

	    // 2. If driver not found
	    if (d == null) {
	        rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMasg("Driver not found for mobile: " + mob);
	        rs.setData(null);
	        return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	        
	        
	        
	        
	        
	        
	        
	    }

	    // 3. Fetch booking list
    List<Booking> blist = d.getBlist();

	    // 4. Success
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMasg("Driver booking history fetched successfully");
	    rs.setData(blist);

	    return new ResponseEntity<>(rs, HttpStatus.OK);
	}






/********************************/

	public ResponseEntity<responcestucture<ActiveBookingDto>> seeactivebooikngs(long customermob) {
		// TODO Auto-generated method stub
		BookingDto bt = new BookingDto();
		

		 Customer c = cr.findByMob(customermob);
		Booking b1 = new Booking();
		if(c.isFlag()==true)
		{
			List<Booking> blist = c.getBlist();
			for(Booking b: blist)
			{
				if ("BOOKED".equals(b.getBookingStatus()))
				{
					b1=b;
					break;
				}
			}
			ActiveBookingDto abdto = new ActiveBookingDto();
			abdto.setBookng(b1);
			abdto.setCustomername(c.getName());;
			abdto.setCustomermobnum(customermob);
			abdto.setCurrentlocation(c.getCurrentLocation());
			responcestucture<ActiveBookingDto> rs = new responcestucture<ActiveBookingDto>();
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMasg("You have alredy booked one vehicle cant book one more vehicle");
			rs.setData(abdto);
			return new ResponseEntity<responcestucture<ActiveBookingDto>>(rs,HttpStatus.OK);
		}
		else
			
			
		{
			Vehicle v = vr.findById(bt.getV().getVehicleId()).get();
			Driver d = dr.findById(v.getDriver().getDriverId()).get();
			Booking b = new Booking();
			b.setCust(c);;
			b.setVeh(v);
			
			b.setSourcelocation(bt.getSourcelocation());
			b.setDestinationlocation(bt.getDestinationlocation());
			b.setFare(bt.getFare());
			b.setEstimatedtimerequired(bt.getEstimatedtime());
			b.setDistancetravlled(bt.getDistancetravelled());
		
			b.setBookingStatus("BOOKED");
			br.save(b);
			
			c.getBlist().add(b);
			c.setFlag(true);
			v.getDriver().getBlist().add(b);
			v.setAvailabilityStatus("BOOKED");
			d.setDriverStatus("BOOKED");;
			cr.save(c);
			vr.save(v);
			dr.save(d);
			
			ActiveBookingDto abdto = new ActiveBookingDto();
			abdto.setBookng(b);
			abdto.setCustomername(c.getName());
			abdto.setCustomermobnum(customermob);
			abdto.setCurrentlocation(c.getCurrentLocation());
			responcestucture<ActiveBookingDto> rs = new responcestucture<ActiveBookingDto>();
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMasg("You have successfully booked the vehicle");
			rs.setData(abdto);
			return new ResponseEntity<responcestucture<ActiveBookingDto>>(rs,HttpStatus.OK);
		}
	}

		
		
		
	
public ResponseEntity<responcestucture<Integer>> getotp(int bookingid) 
{
	Booking b = br.findById(bookingid).orElseThrow(bookingnotfind::new);
	int otp = (int)(Math.random() * 9000) + 1000;
	b.setOtp(otp);
	br.save(b);
	responcestucture<Integer> rs = new responcestucture<Integer>();
	rs.setStatuscode(HttpStatus.OK.value());
	rs.setMasg("Otp generated");
	rs.setData(otp);
	return new ResponseEntity<responcestucture<Integer>>(rs,HttpStatus.OK);

}
		
		
		
		
	}




	


