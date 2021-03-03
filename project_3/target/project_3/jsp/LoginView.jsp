
<%@page import="in.co.rays.project_3.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.controller.LoginCtl"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login view</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<style type="text/css">
.log1 {
	padding-top: 5%;
}

<%-- .hm-gradient {


	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg.png');
}
 --%>

i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}
</style>
</head>
<body style=background-color:#ccccb3>
	<div>
		<%@include file="Header.jsp"%>
	</div>
	<div>

		<main>
		<form action="<%=ORSView.LOGIN_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-md-4 "></div>
				<div class="col-md-4">
					<div class="card">
						<div class="card-body">

							<h3 class="text-center text-primary">Login</h3>
							<!--Body-->
							<div>

								<jsp:useBean id="dto" class="in.co.rays.project_3.dto.UserDTO"
									scope="request"></jsp:useBean>
								<H4 align="center">
									<%
										if (!ServletUtility.getSuccessMessage(request).equals("")) {
									%>
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getSuccessMessage(request)%>
									</div>
									<%
										}
									%>
								</H4>

								<H4 align="center">
									<%
										if (!ServletUtility.getErrorMessage(request).equals("")) {
									%>
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
											<%=ServletUtility.getErrorMessage(request)%>
									</div>
									<%
										}
									%>

								</H4>
								<%
									String uri = (String) request.getAttribute("uri");
								%>
								
								
								<input type="hidden" name="id" value="<%=dto.getId()%>">
								<input type="hidden" name="createdBy" value="<%=dto.getCreatedBy()%>"> 
								<input type="hidden" name="modifiedBy" value="<%=dto.getModifiedBy()%>"> 
								<input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(dto.getCreatedDatetime())%>">
								<input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(dto.getModifiedDatetime())%>">
							</div>
							
		<span class="pl-sm-5"><b>Email Id</b>
		<span style="color: red;">*</span></span> </br>
	
	<div class="col-sm-12">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fa fa-envelope grey-text" style="font-size: 1rem;"></i> </div>
        </div>
        <input type="text" class="form-control" name="login" placeholder="Enter email" value="<%=DataUtility.getStringData(dto.getLogin())%>">
      </div>
    </div>
	<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("login", request)%></font></br>								
					
	<span class="pl-sm-5"><b>Password</b>
	<span style="color: red;">*</span></span> </br> 
	<div class="col-sm-12">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fa fa-lock grey-text" style="font-size: 1rem;"></i> </div>
        </div>
        <input type="password" id="myInput" class="form-control" name="password" placeholder="Enter password"  value="<%=DataUtility.getStringData(dto.getPassword())%>">
      	
       
     </div>
     
     
    </div>
		<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("password", request)%></font></br>	</br>						
		

							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md hover-overlayed" style="font-size: 17px"
									value="<%=LoginCtl.OP_SIGN_IN%>"> 
									
								<input type="submit"
									name="operation" class="btn btn-info btn-md"
									style="font-size: 17px"
									value="<%=UserRegistrationCtl.OP_SIGN_UP%>">
							</div>
							<div class="text-center">
								<a href="<%=ORSView.FORGET_PASSWORD_CTL%>"
									style="color: black; font-size: 15px;"><b>Forget my
										password ?</b></a>
							</div>
							<input type="hidden" name="uri" value="<%=uri%>">
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-4"></div>
			</div>

		</form>
		</main>


	</div>

</body>
<%@include file="FooterView.jsp"%>
</html>