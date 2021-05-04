package com.cognizant.component.processing.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.component.processing.model.ProcessRequest;
import com.cognizant.component.processing.model.ProcessResponse;
import com.cognizant.component.processing.service.ProcessRequestService;
import com.cognizant.component.processing.service.ProcessResponseService;

@RestController
public class ComponentProcessingController {

	
	@Autowired
	private ProcessResponseService processResponseService;
	
	@Autowired
	private ProcessRequestService prs;
	
	@PostMapping("/processDetail")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ProcessResponse getProcessDetails(@RequestBody ProcessRequest processRequest)
	{
		return processResponseService.getResponse(processRequest);
	}
	
	@PostMapping("/completeProcessing")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String doCompleteProcessing(@PathVariable int requestId,@PathVariable long creditCardNumber,
		@PathVariable double creditLimit,@PathVariable	double processingCharge)
	{
		return "Success";	
	}
	
	@PostMapping("/fun")
	@ResponseStatus(code=HttpStatus.OK)
	public ProcessResponse getFun(@RequestBody ProcessRequest processRequest)
	{
		return prs.fun(processRequest);
	}
	
	@GetMapping("/success")
	public String getSuccess()
	{
		return "success";
	}
}
