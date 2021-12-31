<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<h1 align="center">Product Form</h1> <hr/>

   <div align="center">
    <form:form modelAttribute="product" action="./updateProduct">
    
    	Product ID: <form:input path="productId" readonly="true"/> <br/>
    	Name: <form:input path="productTitle"/> <br/>
    	Price: <form:input path="productPrice"/> <br/>
    	Quantity: <form:input path="productQty"/> <br/>
    	Keywords: <form:textarea path="productKeywords"/> <br/>
    	Brand ID: <form:input path="brand.brandId"/> <br/>
    	Category ID: <form:input path="category.catId"/><br/>
    	
    	<form:button>Update</form:button>
    	
    	
    
    </form:form>
    
    </div>


</body>
</html>