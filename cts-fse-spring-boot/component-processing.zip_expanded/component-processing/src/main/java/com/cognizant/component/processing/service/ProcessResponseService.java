package com.cognizant.component.processing.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.component.processing.dao.ProcessService;
import com.cognizant.component.processing.factoryservice.ComponentFactory;
import com.cognizant.component.processing.model.ComponentType;
import com.cognizant.component.processing.model.ProcessRequest;
import com.cognizant.component.processing.model.ProcessResponse;
import com.cognizant.component.processing.repository.ProcessRequestRepository;
import com.cognizant.component.processing.repository.ProcessResponseRepository;

@Service
public class ProcessResponseService {

	@Autowired
	private ProcessResponseRepository processResponseRepository;
	
	@Autowired
	private ProcessRequestRepository processRequestRepository;
	@Autowired
	ComponentFactory factory;
	
	@PostConstruct
	public void success()
	{
		System.out.println("process response service created------------------------------");
	}
	
	public void saveResponse(ProcessResponse processResponse)
	{
		processResponseRepository.save(processResponse);
	}
	
	public ProcessResponse getProcessResponseByRequestId(int requestId)
	{
		return processResponseRepository.getOne(requestId);
	}
	
	@Transactional
	public ProcessResponse getResponse(ProcessRequest processRequest)
	{
		ProcessRequest saveRequest=processRequestRepository.save(processRequest);
		ComponentType componentType=saveRequest.getDefectiveComponentDetails().getComponentType();
		int userId=saveRequest.getUserId();
		System.out.println(userId);
		ProcessResponse processResponse=getResponseForComponent(componentType,userId);
		//processRequestRepository.save(processRequest);
	    processResponseRepository.save(processResponse);
		return processResponse;
		
	}
	
	public ProcessResponse getResponseForComponent(ComponentType componentType,int userId)
	{
		ProcessService processService=factory.getComponentFactory(componentType);
		return processService.getProcessResponse(userId);
	}
	
}
