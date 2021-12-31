<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

      <jsp:include page="menu.jsp"/>
      <hr/>

	<table border="1" align="center">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>keywords</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productId }</td>
					<td>${product.productTitle }</td>
					<td>${product.productPrice }</td>
					<td>${product.productQty }</td>
					<td>${product.productKeywords }</td>
					<td> <a href="./findById?productId=${product.productId}">Update</a></td>
					<td><a href="./deleteProduct?productId=${product.productId}">Delete</a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>





</body>
</html>