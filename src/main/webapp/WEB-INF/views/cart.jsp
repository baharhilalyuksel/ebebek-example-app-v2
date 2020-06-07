<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/list-products.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/cart.css" />">
</head>

<body>

<div class="header">

	<h2>Ebebek E-Commerce Application</h2>
	
	<hr>

</div>

<div class="content">

	<div class="container-fluid">
	
		<div class="row list-cartLines">
		
			<div class="col-12 title">
			
				<c:choose>
					<c:when test="${!empty cart.cartLines}">
						<div class="row align-items-center cartLine-container">
							<div class="col-2 col-sm-2">
								<span>Ürün resmi</span>
							</div>
							<div class="col-3 col-sm-2 offset-sm-1 cartLine-name">
								<span>Ürün adı</span>
							</div>
							<div class="col-1 cartLine-price">
								<span>Fiyat</span>
							</div>
							<div class="col-3 offset-1 cartLine-quantity">
								<span>Adet</span>							
							</div>
							<div class="col-1 cartLine-totalPrice">
								<span>Toplam Fiyat</span>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h2 class="basket-empty" >Sepetiniz boş</h2>
					</c:otherwise>
				</c:choose>
			
			</div>
			
			<hr>
		
			<c:forEach items="${cart.cartLines}" var="cartLine">
			
				<div class="col-12">
					
					<div id="cartLine-${cartLine.product.id}" class="row align-items-center cartLine-container">
						<div class="col-2 col-sm-2 cartLine-image">
							<img alt="" src="${cartLine.product.imageUrl}">
						</div>
						<div class="col-3 col-sm-2 offset-sm-1 cartLine-name">
							<span>${cartLine.product.name}</span>
						</div>
						<div class="col-1 cartLine-price">
							<span>${cartLine.product.price}</span>
						</div>
						<div class="col-4 col-sm-3 offset-1 cartLine-quantity">
							<div class="decrementButton">
								<form action="${pageContext.request.contextPath}/decrement-product-quantity" method="post">
									<input type="submit" value="-" />
									<input type="hidden" value="${cartLine.product.id}" name="productId" >
								</form>
							</div>
							<span class="quantity" >${cartLine.quantity}</span>
							<div class="incrementButton">
								<form action="${pageContext.request.contextPath}/increment-product-quantity" method="post">
									<input type="submit" value="+" />
									<input type="hidden" value="${cartLine.product.id}" name="productId" >
								</form>
							</div>							
						</div>
						<div class="col-1 cartLine-totalPrice">
							<span><fmt:formatNumber type="number" maxFractionDigits="2" value="${cartLine.totalPrice}" /></span>
						</div>
					</div>
					
				</div>
			
			</c:forEach>
			
			<br>
			<hr>
			<br>
			
		</div>
		
		<div class="row justify-content-center">
			<div class="col-12 col-sm-4 gotoproducts-button">
				<a href="${pageContext.request.contextPath}/list-products">Ürünlere Git</a>				
			</div>			

			<c:if test="${!empty cart.cartLines}">
				<div class="col-12 col-sm-6 offset-sm-2 cart-totalPrice">
					<span>Genel Toplam : <fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.totalPrice}" /></span>
				</div>
			</c:if>	
		</div>
	
	</div>

</div>

</body>
</html>
