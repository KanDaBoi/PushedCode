package com.cognizant.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.exception.InvalidFlightOperation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class Flight {
	private String id;
	private String flightType;
	private List<Passenger> passengers = new ArrayList<>();
	
	public boolean addPassenger(Passenger passenger)throws InvalidFlightOperation
	{
		boolean addStatus = false;
		if(flightType.equalsIgnoreCase("economy"))
			addStatus = passengers.add(passenger);
		else if(flightType.equalsIgnoreCase("business"))
		{
			if(passenger.isVip())
				addStatus = passengers.add(passenger);
			else
				throw new InvalidFlightOperation("Cannot add non-VIP to business flight");
		}
		return addStatus;
	}
	public boolean removePassenger(Passenger passenger)throws InvalidFlightOperation
	{
		boolean removeStatus = false;
		if(!passenger.isVip() && flightType.equals("economy"))
		{
			removeStatus = passengers.remove(passenger);
		}
		else
			throw new InvalidFlightOperation("Cannot remove VIP/Business flight does not have any non-VIP passenger to remove");
		return removeStatus;
	}
}
