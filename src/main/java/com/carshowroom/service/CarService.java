package com.carshowroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshowroom.Repository.CarRepository;
import com.carshowroom.entity.carentity;

@Service
public class CarService {
	@Autowired
	private CarRepository carrepo;
	//====find all================
	public List<carentity> findall()
	{
		List<carentity> details=carrepo.findAll();
		return details;
	}
	//========findbyid=====
	public carentity findbyid(Integer sno)
	{
		Optional<carentity> ce=carrepo.findById(sno);
		if(ce.isPresent())
		{
			return ce.get();
		}
		else
		{
			throw new RuntimeException("id is not there");
		}
	}
	//=============find all by id============
	public List<carentity> findallbyid(List<Integer> sno)
	{
		List<carentity> ce=carrepo.findAllById(sno);
		return ce;
	}
	//====save=====
	public carentity insertarescord(carentity ce)
	{
		carentity ces=carrepo.save(ce);
		return ces;
	}
	//==saveall====
	public List<carentity> insertmultiplerecords(List<carentity> ce)
	{
		List<carentity> ces=carrepo.saveAll(ce);
		return ces;
	}
	//===========exist by id============
	public Boolean existbyid(Integer sno)
	{
		Boolean b=carrepo.existsById(sno);
		return b;
	}
	//===============update record===========
	public carentity updatetherecord(Integer sno,carentity ce)
	{
		Optional<carentity> cers=carrepo.findById(sno);
		if(cers.isPresent())
		{
			carentity oldrecord=cers.get();
			ce.setName(oldrecord.getName());
			ce.setBrand(oldrecord.getBrand());
			ce.setDescription(oldrecord.getDescription());
			ce.setPrice(oldrecord.getPrice());
			ce.setReleaseDate(oldrecord.getReleaseDate());
			ce.setAvailabilty(oldrecord.isAvailabilty());
			ce.setQuantity(oldrecord.getQuantity());
			return carrepo.save(oldrecord);
			
		}
		else
		{
			throw new RuntimeException("sno is not there");
		}
	}
	//=============delete by id=====
	public String deletebyid(Integer id)
	{
		carrepo.deleteById(id);
		return "id is deleted";
	}
	//========delete all by id===
	public String deleteallbyid(List<Integer> id)
	{
		carrepo.deleteAllById(id);
		return "id are deleted";
	}
	//==============findby methods==========
	public List<carentity> findbyname(String name)
	{
		 return carrepo.findByName(name);
	}
	//=================================
	public carentity findnamebysno(Integer sno)
	{
		return carrepo.findNameBySNo(sno);
	}
	//=====================findbypricegreaterthan=====
	public List<carentity> findbypricegreaterthan(long price)
	{
		return carrepo.findByPriceGreaterThan(price);
	}
	//==================findbyreleasedate==========
	public List<carentity> findbyreleasedate(String releasedate)
	{
		return carrepo.findByReleaseDate(releasedate);
	}
	//============combination quieries=====
	public List<carentity> findbybrandandavilabiliy(String brand,boolean avilability)
	{
		 return carrepo.findByBrandAndAvailabilty(brand, avilability);
	}
	public List<carentity> findbynameandbrand(String name,String brand)
	{
		return carrepo.findByNameAndBrand(name, brand);
	}
	public List<carentity> findbypricebetween(long price1,long price2)
	{
		return carrepo.findByPriceBetween(price1, price2);
	}
	//=====ordering and limting==========
	public List<carentity> findBybrandorderbypriceasc(String brand)
	{
		return carrepo.findByBrandOrderByPriceAsc(brand);
	}
	//==========jpql quireies=======================
	public List<carentity> findbyinnamejpql(String name)
	{
	return carrepo.findbyname(name);
	}
	public carentity findbyids(Integer id)
	{
		return carrepo.findbysno(id);
	}
	public List<carentity> findbypricegreaterthann(long price)
	{
		return carrepo.findbypriceGreaterthan(price);
	}
	public List<carentity> findbypricebetweenn(long price1,long price2)
	{
		return carrepo.findbypricebetween(price1, price2);
	}
	public List<carentity> findbyreleasedatee(String releasedate)
	{
		return carrepo.findbyreleasedate(releasedate);
	}
	public List<carentity> findbybrandandavilability(String brand,boolean avilability)
	{
		return carrepo.findbybrandandavilability(brand, avilability);
	}
	public List<carentity> findbybrandorderbyprice(String brand)
	{
		return carrepo.findbybrandordderbypricedesc(brand);
	}
}
