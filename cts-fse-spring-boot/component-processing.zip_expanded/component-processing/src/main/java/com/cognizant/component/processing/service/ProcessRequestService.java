package com.cognizant.component.processing.service;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.component.processing.dao.ProcessService;
import com.cognizant.component.processing.exception.UserNotFoundException;
import com.cognizant.component.processing.model.ComponentType;
import com.cognizant.component.processing.model.ProcessRequest;
import com.cognizant.component.processing.model.ProcessResponse;
import com.cognizant.component.processing.repository.ProcessRequestRepository;
import com.cognizant.component.processing.repository.ProcessResponseRepository;

@Service
public class ProcessRequestService {

	@Autowired
	private ProcessRequestRepository processRequestRepository;
	
	@Autowired
	private ProcessResponseService processResponseService;
	
	@PostConstruct
	public void success()
	{
		System.out.println("process request service created------------------------------");
	}
	
	public void saveRequest(ProcessRequest processRequest)
	{
		processRequestRepository.save(processRequest);
	}
	
	public Optional<ProcessRequest> getRequestById(int userId) throws UserNotFoundException
	{
		if(processRequestRepository==null)
		{
			System.out.println("---------------PRoces Request is null------------");
		}
		if(!processRequestRepository.existsById(userId))
		{
			throw new UserNotFoundException("User with Id "+userId+" does not exists");
		}
		return processRequestRepository.findById(userId);
	}
	
	public ProcessRequest getById(int userId)
	{
		return processRequestRepository.findByUserId(userId);
	}
	
	public ProcessResponse fun(ProcessRequest processRequest)
	{
		return processResponseService.getResponse(processRequest);
	}
	/*
	public ProcessResponse getResponse(ProcessRequest processRequest)
	{
		processRequestRepository.save(processRequest);
		ComponentType componentType=processRequest.getDefectiveComponentDetails().getComponentType();
		int userId=processRequest.getUserId();
		ProcessResponse processResponse=getResponseForComponent(componentType,userId);
		//processRequestRepository.save(processRequest);
	    processResponseRepository.save(processResponse);
		return processResponse;
	}
	
	public ProcessResponse getResponseForComponent(ComponentType componentType,int userId)
	{
		ProcessService processService=ComponentFactory.getComponentFactory(componentType);
		return processService.getProcessResponse(userId);
	}
	*/
}
