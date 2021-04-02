<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Product ID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Product Price(&#x20B9;)</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${products}" var="prod">
						<tr>
							<th scope="row">${prod.id }</th> <!-- This will be "id" instead of Id  -->
							<td>${prod.productName }</td>
							<td>${prod.productDescription }</td>
							<td>&#x20B9; ${prod.productPrice }</td>
							<td>
								<a href="delete/${prod.id} "><i class="fas fa-trash text-danger" style="font-size: 20px"></i></a>
								<a href="update/${prod.id }"><i class="fas fa-edit text-primary" style="font-size: 20px"></i></a>
							</td>
						</tr>
					</c:forEach>
						
						
					</tbody>
				</table>
					<div class="container text-center">
						<a href="add-product" class="btn btn-outline-success">Add Product</a>
					</div>
			</div>

		</div>

	</div>

</body>
</html>