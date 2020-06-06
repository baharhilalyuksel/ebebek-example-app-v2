<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>

<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/list-products.css" />">
	<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
	<script type="text/javascript">
	function addToCart(productId) {
		$.post( "add-product-to-cart", {productId:productId}, function( data ) {
			  alert( "Ürün sepete eklendi.");
		});
	}	
	</script>
</head>

<body>

<div class="header">

	<h2>Ebebek E-Commerce Application</h2>
	
	<hr>

</div>

<div class="content">

	<div class="gotocart-button">
		<a href="${pageContext.request.contextPath}/cart">Sepete Git</a>
	</div>
	
	<div class="products-content">

	<div class="container-fluid">
	
		<div class="row list-products">
		
			<c:forEach items="${products}" var="product">
			
				<div class="col-xs-12 col-sm-6 col-md-3">
					
					<div class=product-container>
						<div class="product-image">
							<img alt="" src="${product.imageUrl}">
						</div>
						<div class="product-name">
							<span>${product.name}</span>
						</div>
						<div class="product-price">
							<span>${product.price} TL</span>
						</div>
						<div class=add-to-cart-button>
							<button type="button" onclick="javascript:addToCart(${product.id})" >Sepete Ekle</button>
						</div>
					</div>
					
				</div>
			
			</c:forEach>
		
		</div>
	</div>
	</div>

</div>

</body>
</html>
