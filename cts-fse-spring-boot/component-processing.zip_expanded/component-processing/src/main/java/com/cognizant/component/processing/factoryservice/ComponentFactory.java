package com.cognizant.component.processing.factoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.component.processing.dao.ProcessService;
import com.cognizant.component.processing.model.ComponentType;
@Service
public class ComponentFactory {
	
	@Autowired
	ApplicationContext context;

	public ProcessService getComponentFactory(ComponentType componentType)
	{
		
		
		if(componentType==ComponentType.ACCESSORY)
		{
			return context.getBean(AccessorPartService.class);
			
			//return new AccessorPartService();
		}
		else if(componentType==ComponentType.INTEGRAL)
		{
			return context.getBean(IntegralPartService.class);
			
			//return new IntegralPartService();
		}
		else
		{
			return null;
		}
	}
	
}
