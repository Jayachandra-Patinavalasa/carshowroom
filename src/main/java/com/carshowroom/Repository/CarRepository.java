package com.carshowroom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carshowroom.entity.carentity;

public interface CarRepository  extends JpaRepository<carentity, Integer>{
//===========find by methods===============
	List<carentity> findByName(String name);
	carentity findNameBySNo(Integer sno);
	List<carentity> findByPriceGreaterThan(long price);
	List<carentity> findByReleaseDate(String relesedate);
	//====combinationquiries==========
	List<carentity>  findByBrandAndAvailabilty(String brand,boolean availability);
 List<carentity>findByNameAndBrand(String name,String brand);
 List<carentity> findByPriceBetween(long price1,long price2);
 //=======ordering and limiting
 List<carentity> findByBrandOrderByPriceAsc(String brand);	
 
 //===jpql quieries=========================
 @Query("select e from carentity e where e.name=:name")
 List<carentity> findbyname(String name);
 @Query("select e from carentity e where e.sNo=:sno")
  carentity findbysno(Integer sno);
 @Query("select e from carentity e where e.price>:price")
	List<carentity> findbypriceGreaterthan(long price);
	@Query("select e from carentity e where e.price between :price1 and :price2")
	List<carentity> findbypricebetween(long price1,long price2);
	@Query("select e from carentity e where e.releaseDate=:releasedate")
	List<carentity> findbyreleasedate(String releasedate);
	//findbybrandandavilability//
	@Query("select e from carentity e where e.brand=:brand and availabilty=:avilability")
	List<carentity> findbybrandandavilability(String brand,boolean avilability);
	@Query("select e from carentity e where e.brand=:brand order by price desc")
List<carentity>	findbybrandordderbypricedesc(String brand);
}
