package com.ct.microservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class RestTemplateHeaderModifierInterceptor
implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(
    HttpRequest request, 
    byte[] body, 
    ClientHttpRequestExecution execution) throws IOException {
request.getHeaders().remove("Authorization");
      ClientHttpResponse response = execution.execute(request, body);
      
      HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
      // get the current session without creating a new one
      HttpSession httpSession = httpServletRequest.getSession(false);
      // get whatever session parameter you want
      if(httpSession.getAttribute("token")!=null) {
      String token = httpSession.getAttribute("token")
                                       .toString();
      
      response.getHeaders().remove("Authorization", response.getHeaders().getFirst("Authorization"));
      response.getHeaders().add("Authorization", token);
      log.info("Authorization added to request");
      
      }
      System.out.println(response.getHeaders().getFirst("Authorization"));
      return response;
  }
}