package com.ct.microservices.filter;


import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AuthFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		System.out.println("Request Intercepted..");
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		String user="rahul";
		String header=request.getHeader("auth");
		if(header==null || header.isEmpty()) {
			return null;
		}
		if(header.equals(user)) {
			return null;
		}
		context.setSendZuulResponse(false);
		context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
		context.setResponseBody("Unauthorized user : "+header);
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
