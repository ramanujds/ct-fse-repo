package com.cognizant.component.processing.factoryservice;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.component.processing.dao.ProcessService;
import com.cognizant.component.processing.model.ProcessResponse;
import com.cognizant.component.processing.repository.ProcessRequestRepository;
import com.cognizant.component.processing.service.ProcessRequestService;

@Service
public class AccessorPartService implements ProcessService {
	
	@PostConstruct
	public void success()
	{
		System.out.println("process accessor service created------------------------------");
	}
	
	@Autowired
	ProcessRequestService ppp;
	
	@Autowired
	ProcessRequestRepository prr;
	
	
	
	
	@Override
	public ProcessResponse getProcessResponse(int userId) {
		if(ppp==null)
		{
			System.out.println("------------------------accessor is null-----------------------");
		}
		if(prr==null)
		{
			System.out.println("------------------------accessor is null1111111-----------------------");
			
		}
		int processingDays=5;
		double processingCharge=300;
		LocalDate currentDay = LocalDate.now();
		ProcessResponse processResponse=new ProcessResponse();
		processResponse.setUserId(userId);
		processResponse.setProcessingCharge(processingCharge);
		processResponse.setDateOfDelivery(currentDay.plusDays(processingDays));
		processResponse.setPackagingAndDeliveryCharge(3000);
	
		return processResponse;
	}

}
