<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">
    
    <script  type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>

<title>My web</title>
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
    
	<h1>Home Page</h1>
	<p>welcome ${user}</p>
	<hr>

	<table id="myTable" class="table table-stripted">
		<thead>

			<tr class="success">
				<td>First Name</td>
				<td>Last Name</td>
				<td>College</td>
				<td>Phone</td>
				<td>Country</td>
				<td>Action</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="student" items="${slist}">

				<tr class="danger">
					<td>${student.fname}</td>
					<td>${student.lname}</td>
					<td>${student.college}</td>
					<td>${student.phone}</td>
					<td>${student.address.country}</td>
					<td>
						<input type="submit" class="btn btn-success" onclick="editStudent(${student.id})" value="Edit"> 
						<input type="submit" class="btn btn-danger" onclick="deleteStudent(${student.id})" value="Delete">
					</td>
				</tr>

			</c:forEach>
		</tbody>

	</table>
	
	<script type="text/javascript">
	
	function editStudent(id)
	{
		window.location="${pageContext.request.contextPath}/"+id+"/edit"; //helps to keep root url only
	}
	
	function deleteStudent(id)
	{
		var msg = confirm("DO you want to delete?")
		if(msg==true)
		{
			window.location="${pageContext.request.contextPath}/"+id+"/delete";
		}
	}
	
	$(document).ready( function () {
	    $('#myTable').DataTable();
	} );
	
	</script>
	
</body>

</html>
