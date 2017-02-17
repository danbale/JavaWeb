
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<title>States</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">New State</h3>
	
	<form method="post" action="/academy/Cart/update" >
		<table style="width: 80%;">
			<tr>
				<td width="13%">Id</td>
				<td width="25%">
					<input type="text" name="id" value="${map.cart.id}" readonly="readonly">
				</td>
				<td width="10%">Ship To:*</td>
				<td width="25%">
					<select name="shipToId">
						<option value="0">- Select -</option>
						<c:forEach var="shipTo" items="${map.shipTos}">
							<option value="${shipTo.id}" <c:if test="${shipTo.id==map.cart.shipTo.id}">selected</c:if>>${shipTo.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Lines Amount:*</td>
				<td>
					<input type="text" name="linesAmount" value="${cart.linesAmount}">
				</td>
				<td>Status:*</td>
				<td>
					<select name="statusId">
						<option value="0">- Select -</option>
						<c:forEach var="status" items="${map.cartStatus}">
							<option value="${status.id}" <c:if test="${status.id==map.cart.status.id}">selected</c:if>>${status.description}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Shipping Amount:*</td>
				<td>
					<input type="text" name="shippingAmount" value="${map.cart.shippingAmount}">
				</td>
				<td>Create Date</td>
				<td>
					<input type="text" name="createDate" value="${map.cart.createDate}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Cart Amount</td>
				<td>
					<input type="text" name="cartAmount" value="${map.cart.cartAmount}">
				</td>
				<td>Update Date</td>
				<td>
					<input type="text" name="updateDate" value="${map.cart.updateDate}" readonly="readonly">
				</td>
			</tr>
		</table>
		
		<br>
		<input type="submit" name="update" value="Update">
	 </form>
	
	<br>
	<div><c:out value="${map.status}"/></div>
	
	<br>
<a href="<c:url value="/Cart/List"/>">Return to List</a>
</body>
</html>