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
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Please update the product details</h1>

				<form action="${pageContext.request.contextPath }/update-product" method="post">
					<div class="form-group">
					<!-- Product Id is hidden -->
						 <input type="hidden"
							class="form-control" id="Id" aria-describedby="emailHelp"
							name="Id" value="${product2BEdited.id }">
						</div>
						<div class="form-group">
							<label for="name">Product Name</label> <input type="text"
								class="form-control" id="name" aria-describedby="emailHelp"
								name="productName" value="${product2BEdited.productName }">
						</div>
						<div class="form-group">
							<label for="description">Product Description</label>
							<textarea class="form-control" id="description"
								name="productDescription" rows=5>${product2BEdited.productDescription }</textarea>
						</div>

						<div class="form-group">
							<label for="price">Product Price</label> <input type="text"
								class="form-control" id="price" name="productPrice"
								value="${product2BEdited.productPrice }">
						</div>

						<div class="container text-center">
							<a href="${ pageContext.request.contextPath }/home"
								class="btn btn-outline-danger">Cancel</a>
								
							<button type="submit" class="btn btn-primary">Update</button>

						</div>
				</form>
			</div>

		</div>


	</div>
</body>
</html>