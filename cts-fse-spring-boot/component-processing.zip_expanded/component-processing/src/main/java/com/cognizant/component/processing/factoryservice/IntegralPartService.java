package com.cognizant.component.processing.factoryservice;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.component.processing.dao.ProcessService;
import com.cognizant.component.processing.exception.UserNotFoundException;
import com.cognizant.component.processing.model.ProcessRequest;
import com.cognizant.component.processing.model.ProcessResponse;
import com.cognizant.component.processing.repository.ProcessRequestRepository;
import com.cognizant.component.processing.service.ProcessRequestService;

@Service
public class IntegralPartService implements ProcessService 
{

	@Autowired
	ProcessRequestService prs;
	
	/*
	@PostConstruct
	public void success()
	{
		System.out.println("process integeral service created------------------------------");
	}
	*/
	@Override
	public ProcessResponse getProcessResponse(int userId)  {
		int processingDays=5;
		double processingCharge=500;
		LocalDate currentDay = LocalDate.now();
		 
		
        if(prs==null)
        {
        	System.out.println("---------------NULLLLLL");
        }
		
		ProcessResponse processResponse=new ProcessResponse();
		
		ProcessRequest newProcessRequest=prs.getById(userId);
		//ProcessRequest newProcessRequest=processRequest.get();
		
		boolean isPriorityHigh=newProcessRequest.isPriorityRequest();
		if(isPriorityHigh)
		{
			processingDays=2;
			processingCharge=processingCharge+200;
		}
		processResponse.setUserId(userId);
		processResponse.setProcessingCharge(processingCharge);
		processResponse.setDateOfDelivery(currentDay.plusDays(processingDays));
		processResponse.setPackagingAndDeliveryCharge(2000);
		return processResponse;
	}

}
