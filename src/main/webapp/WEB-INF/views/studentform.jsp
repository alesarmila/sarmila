<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">
    
    <script  type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Start navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">GTC Movember</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
             <li><a href="upload">Upload</a></li>
              <li><a href="email">Contact</a></li>
            <li><a href="gallery">Gallery</a></li>
            <li><a href="student">StudentForm</a></li>
            <li><a href="#">Profile</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/logout">Logout<span class="sr-only">(current)</span></a></li>
          </ul>
        </div> 
      </div>
    </nav>
    <!-- End navbar -->

	<h1>Student Form</h1>
	<hr>

	<spring:form action="student" method="post" modelAttribute="mstudent">
		<table>

			<tr>
				<td>First Name</td>
				<td><spring:input path="fname" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><spring:input path="lname" /></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td>
					<spring:radiobutton path="gender" value="male" /> Male 
					<spring:radiobutton path="gender" value="female" /> Female
				</td>
			</tr>

			<tr>
				<td>Date of Birth</td>
				<td><spring:input path="dob" type="date"/></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><spring:input path="phone" /></td>
			</tr>

			<tr>
				<td>College</td>
				<td><spring:input path="college" /></td>
			</tr>

			<tr>
				<td>Semester</td>
				<td><spring:input path="semester" /></td>
			</tr>

			<tr>
				<td>Faculty</td>
				<td><spring:input path="faculty" /></td>
			</tr>

			<tr>
				<td>Roll No</td>
				<td><spring:input path="rollno" /></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><spring:input path="address.country"/></td>
			</tr>

			<tr>
				<td>City</td>
				<td><spring:input path="address.city"/></td>
			</tr>

			<tr>
				<td>State</td>
				<td><spring:select path="address.state">

						<spring:option value="0">------Select state-------</spring:option>

						<spring:option value="1">State-1</spring:option>

						<spring:option value="2">State-2</spring:option>

						<spring:option value="3">State-3</spring:option>

						<spring:option value="4">State-4</spring:option>

						<spring:option value="5">State-5</spring:option>

						<spring:option value="6">State-6</spring:option>

						<spring:option value="7">State-7</spring:option>


					</spring:select></td>
			</tr>

			<tr>
				<td>Zip</td>
				<td><spring:input path="address.zip" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="save"/></td>
			</tr>

		</table>
	</spring:form>

</body>
</html>