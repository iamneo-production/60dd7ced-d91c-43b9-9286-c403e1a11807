<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Document</title>
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<style>
			body{        
				padding-top: 60px;
				padding-bottom: 40px;
			}
			.fixed-header, .fixed-footer{
				width: 100%;
				position: fixed;        
				background: #FF1493;
				padding: 10px 0;
				color: #fff;
			}
			.fixed-header{
				top: 0;
			}
			.fixed-footer{
				bottom: 0;
			}
			.container{
				width: 80%;
				margin: 0 auto; /* Center the DIV horizontally */
			}
			nav a{
				color: #fff;
				text-decoration: none;
				padding: 7px 25px;
				display: inline-block;
			}
			.fixed-header input[type=text] {
				float: right;
				padding: 6px;
				border: none;
				margin-top: 8px;
				margin-right: 16px;
				font-size: 17px;
			}
			#div1 {
				width: 20%;
				float: right;
				height: 510px;
				margin: auto;
				margin-top: 10px;
				margin-left: 1030px;
				background-color: #9932CC;
			}
			#ip1 {
				border-radius: 18px;
				background: #DCDCDC;
				padding: 20px; 
				width: 200px;
				height: 15px;    
			}
			#bt1 {
				border-radius: 18px;
				padding: 5px; 
				width: 100px;
				background: #000000;
				text-decoration-color: #DCDCDC;
			}
			#div-2{
				width: 70%;
				float: left;
				height: 150px;
				gap:100%;
				margin: auto;
				margin-top: 5px;
				margin-left: 10px;
				background-color: #A9A9A9;
			}
			.container { overflow: hidden; }
		</style>
	</head>
	<body>
		<div class="fixed-header">
			<div class="container">
				<nav>
					<a href="#">Placement Records</a>
					<input type="text" placeholder=" type here to search" id="fname" name="fname">
					<button type="submit"><i class="fa fa-search"></i></button>
				</nav>
			</div>
		</div>
		<div class="main_div">
		<div class="card" id="div1">
			<h2 class="card-header text-center text-dark ">Add Student Details</h2>
			<form class="form" action="AddStudent" method="POST">
				<table class="table table-hover table-striped text-center text-dark">
					<tr>
						<td><input type="text" placeholder="enter student ID" name="studentId" id="ip1"/></td>
					</tr>
					<tr>
						<td><input type="text" placeholder="enter student name" name="studentName" id="ip1" /></td>
					</tr>

					<tr>
						<td><input type="text" placeholder="enter Company Name" name="companyName" id="ip1" /></td>
					</tr>
					<tr>
						<td><input type="text" placeholder="enter salary" name="salaryOffered" id="ip1" /></td>
					</tr>
					<tr>
						<td><input type="text" placeholder="enter batch" name="batch" id="ip1" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add" id="bt1"
							class="btn btn-outline-success"></td>
					</tr>
				</table>
			</form>
		</div>

		<div class="card-2" id="div-2">
			<table>
				<tr>
				  <th scope="col">Student Id</th>
				  <th scope="col">Student Name</th>
				  <th scope="col">Company Name</th>
				  <th scope="col">Salary</th>
				  <th scope="col">Batch</th>
				</tr>
				<tr>
				  <td>1</td>
				  <td>Shiwani</td>
				  <td>Virtusa</td>
				  <td>100000</td>
				  <td>2022</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Bhawana</td>
					<td>ABC</td>
					<td>20000</td>
					<td>2022</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Ruchi</td>
					<td>ABCD</td>
					<td>14000</td>
					<td>2020</td>
				</tr>
			  </table>
		</div> 
	</div>

	</body>
</html>