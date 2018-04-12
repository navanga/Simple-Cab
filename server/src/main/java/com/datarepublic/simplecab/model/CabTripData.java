package com.datarepublic.simplecab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@NamedQuery(name = "CabTripData.findTripsByMedallionAndPickupDate",
        query = "SELECT COUNT(t) FROM CabTripData t WHERE t.medallion =:medallion AND t.pickupDateTime >= :pickupDateStart AND t.pickupDateTime < :pickupDateEnd"
)
 
@Entity
@Table(name = "cab_trip_data")
public class CabTripData implements Serializable {

	public static final String FIND_TRIPS_BY_MEDALLION_AND_PICKUP_DATE =
	            "CabTripData.findTripsByMedallionAndPickupDate";
	
	@Id
	private String medallion;

	@Column(name="hack_license")
	private String hackLicense;

	@Column(name="vendor_id")
	private String vendorId;

	@Column(name="rate_Code")
	private Integer rateCode;

	public CabTripData() {
	}

	public Date getPickupDateTime() {
		return pickupDateTime;
	}

	public void setPickupDateTime(Date pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}

	@Id
	@Column(name="pickup_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pickupDateTime;

	public String getMedallion() {
		return medallion;
	}

	public void setMedallion(String medallion) {
		this.medallion = medallion;
	}

	public String getHackLicense() {
		return hackLicense;
	}

	public void setHackLicense(String hackLicense) {
		this.hackLicense = hackLicense;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getRateCode() {
		return rateCode;
	}

	public void setRateCode(Integer rateCode) {
		this.rateCode = rateCode;
	}

}
