package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project_3.util.ServletUtility;

/**
 * Error functionality controller.perform error page operation
 * @author Mayank mishra
 *
 */
@WebServlet(name="ErrorCtl", urlPatterns={"/ErrorCtl"})
public class ErrorCtl extends BaseCtl{
	private static final Long servialVersionUID=1L;
	
	
	 /**
     * Concept of Display logic
     *
     */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		ServletUtility.forward(getView(), request, response);
		
	}
	 /**
     * Concept of submit logic
     *
     */
 protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
	
  ServletUtility.forward(getView(), request, response);
 
   
 }
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ERROR_VIEW;
	}

}
