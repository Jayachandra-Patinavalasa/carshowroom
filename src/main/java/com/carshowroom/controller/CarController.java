package com.carshowroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.carshowroom.entity.carentity;
import com.carshowroom.service.CarService;

@RestController
@RequestMapping("cardetails")
public class CarController {
	@Autowired
	private CarService carser;
	@GetMapping("/getcardetails")
	public ResponseEntity<?> findalldetails()
	{
		List<carentity> details=carser.findall();
		return ResponseEntity.ok(details);
	}
//======findbyid=================
	@GetMapping("/findbyid/{sno}")
	public ResponseEntity<?> findByid(@PathVariable Integer sno)
	{
		carentity ce=carser.findbyid(sno);
		return ResponseEntity.ok(ce);
	}
	//====findallbyid=============
	@GetMapping("/findallbyids")
	public ResponseEntity<?> findallByid(@RequestParam List<Integer> sno)
	{
		List<carentity> cer=carser.findallbyid(sno);
		return ResponseEntity.ok(cer);
	}
	//=====save======
	@PostMapping("/inserttherecord")
	public ResponseEntity<String> insertrecord(@RequestBody carentity ce)
	{
		carentity ces=carser.insertarescord(ce);
		return ResponseEntity.ok("one record is inserted");
	}
	//====save all=====
	@PostMapping("/insertmultiplerecords")
	public ResponseEntity<String> insertMultiplerecord(@RequestBody List<carentity> ce)
	{
		List<carentity> ces=carser.insertmultiplerecords(ce);
		return ResponseEntity.ok("inserted the records");
	}
	//==========existbyid========
	@GetMapping("/existbyid/{sno}")
	public String existByid(@PathVariable Integer sno)
	{
		Boolean b=carser.existbyid(sno);
		if(b)
		{
			return "data is there";
		}
		else
		{
			return "id is not there";
		}
	}
	//================update record=========
	@PutMapping("/updatetherecord/{sno}")
	public ResponseEntity<String> Updatetherecord(@PathVariable Integer sno,@RequestBody carentity ce)
	{
		carentity ces=carser.updatetherecord(sno, ce);
		return ResponseEntity.ok("updated Sucessfully");
	}
	//======delete by id============
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> Deletebyid( @PathVariable Integer id)
	{
	carser.deletebyid(id);
	return ResponseEntity.ok("id is deleted");
	}
	//==========delete all by id=====
	@DeleteMapping("/deletemultipleids")
	public ResponseEntity<String> Deleteallbyid(@RequestParam List<Integer> id)
	{
		carser.deleteallbyid(id);
		return ResponseEntity.ok("id are deleted");
	}
	
	//=================find by methods===============
	@GetMapping("/getname/{name}")
	public ResponseEntity<?> findByname(@PathVariable String name)
	{
		return ResponseEntity.ok(carser.findbyname(name));
	}
	//=====================================
	@GetMapping("/entersno/{sno}")
	public ResponseEntity<?> findNamebysno(@PathVariable Integer sno)
	{
	carentity ces=carser.findnamebysno(sno);
	return ResponseEntity.ok(ces.getName());		
	}
	//===========findbypricegraterthan==============
	@GetMapping("/entertheprice/{price}")
	public ResponseEntity<?> findBypricegreaterthan(@PathVariable long price)
	{
		return ResponseEntity.ok(carser.findbypricegreaterthan(price));
	}
	//==================findbyrelaasedate========
	@GetMapping("/enterreleasedate/{releasedate}")
	public ResponseEntity<?> findByreleasedate(@PathVariable String releasedate)
	{
		return ResponseEntity.ok(carser.findbyreleasedate(releasedate));
	}
	//================combinatonquieries==========
	@GetMapping("/enterbrand/{brand}/{avilability}")
	public ResponseEntity<?> findbynameandavailablity(@PathVariable String brand,@PathVariable boolean avilability)
	{
		return ResponseEntity.ok(carser.findbybrandandavilabiliy(brand, avilability));
	}
	@GetMapping("/enternameandbrand/{name}/{brand}")
	public ResponseEntity<?> findByNameandbrand(@PathVariable String name,@PathVariable String brand)
	{
		return ResponseEntity.ok(carser.findbynameandbrand(name, brand));
	}
	@GetMapping("/enterpricebetween/{price1}/{price2}")
	public ResponseEntity<?> findBypricebetween(@PathVariable long price1,@PathVariable long price2)
	{
		return ResponseEntity.ok(carser.findbypricebetween(price1, price2));
	}
	//=============ordering and limiting===========
	@GetMapping("/indi/{brand}")
	public ResponseEntity<?> findBypriceorderbyasc(@PathVariable String brand)
	{
		return ResponseEntity.ok(carser.findBybrandorderbypriceasc(brand));
	}
	// =================jpql queries====================
	@GetMapping("/enteraname/{name}")
	public ResponseEntity<?> findbynamejpq(@PathVariable String name)
	{
		List<carentity> car=carser.findbyinnamejpql(name);
		return ResponseEntity.ok(car);
	}
	@GetMapping("/enterid/{sno}")
	public ResponseEntity<?> findbyenteringsno(@PathVariable Integer sno)
	{
		return ResponseEntity.ok(carser.findbyids(sno));
	}
	@GetMapping("/enterprice/{price}")
	public ResponseEntity<?> findbygreaterthan(@PathVariable long price)
	{
		return ResponseEntity.ok(carser.findbypricegreaterthann(price));
	}
	@GetMapping("/entertheprice/{price1}/{price2}")
	public ResponseEntity<?> findbypricebetween(@PathVariable long price1,@PathVariable long price2)
	{
		return ResponseEntity.ok(carser.findbypricebetweenn(price1, price2));
	}
	@GetMapping("/enterareleasedate/{releasedate}")
	public ResponseEntity<?> findbyreleasedate(@PathVariable String releasedate)
	{
		return ResponseEntity.ok(carser.findbyreleasedatee(releasedate));
	}
	@GetMapping("enterbrandandavilability/{brand}/{avilability}")
	public ResponseEntity<?> findbybrandandavailabitity(@PathVariable String brand,@PathVariable boolean avilability)
	{
		return ResponseEntity.ok(carser.findbybrandandavilability(brand, avilability));
	}
	@GetMapping("/enterthebrand/{brand}")
	public ResponseEntity<?> findbybrandandprice(@PathVariable String brand)
	{
		return ResponseEntity.ok(carser.findbybrandorderbyprice(brand));
	}
	@GetMapping("/get")
	public String get()
	{
		return "jay";
	}
}
