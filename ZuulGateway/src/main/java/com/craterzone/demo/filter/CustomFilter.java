package com.craterzone.demo.filter;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;

@Component
@Order(1)

public class CustomFilter implements Filter {

//	private final String userServiceUrl = "user-service";
//
//	private final String postServiceUrl = "post-service";
//	@Autowired
//	private DiscoveryClient discoveryClient;

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String oldURI = req.getRequestURI();
//		RequestContext context = RequestContext.getCurrentContext();
		

//		
//
        	if (oldURI.contains("user")) {
        		System.out.println("olduri = " + oldURI);
        		req.getRequestDispatcher("/user-service" + oldURI).forward(req, response);
        	}
//			// System.out.println("newURI = "+newURI);
//			List<ServiceInstance> instances = discoveryClient.getInstances(userServiceUrl);
//			String serviceID = instances.get(0).getUri().toURL().toString();
//			URL url = new URL(serviceID + oldURI);
//			//req.getRequestDispatcher(url.toString()).forward(req, response);
//			context.setRouteHost(url);
//			System.out.println("newURI = " + url);
//		}
//
         	else if (oldURI.contains("post")) {
         		System.out.println("olduri = " + oldURI);
        		req.getRequestDispatcher("/post-service" + oldURI).forward(req, response);
         	}
//			// String newURI = oldURI;
//			List<ServiceInstance> instances = discoveryClient.getInstances(postServiceUrl);
//			String serviceID = instances.get(0).getUri().toURL().toString();
//			URL url = new URL(serviceID + oldURI);
//			//req.getRequestDispatcher(url.toString()).forward(req, response);
//			context.setRouteHost(url);
//			System.out.println("newURI = " + url);
//		} else {
//			res.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
//		}
		

	}

}
