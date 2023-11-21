function toggleSignup() {
	document.getElementById("login-toggle").style.backgroundColor = "#fff";
	document.getElementById("login-toggle").style.color = "#222";
	document.getElementById("signup-toggle").style.backgroundColor = "#57b846";
	document.getElementById("signup-toggle").style.color = "#fff";
	document.getElementById("login-form").style.display = "none";
	document.getElementById("signup-form").style.display = "block";
}

function toggleLogin() {
	alert("login");
	document.getElementById("login-toggle").style.backgroundColor = "#57B846";
	document.getElementById("login-toggle").style.color = "#fff";
	document.getElementById("signup-toggle").style.backgroundColor = "#fff";
	document.getElementById("signup-toggle").style.color = "#222";
	document.getElementById("signup-form").style.display = "none";
	document.getElementById("login-form").style.display = "block";
}

function addItemTocart(itemId) {
	var formData = {
		itemId: itemId,
		quantity: 1
	};

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/cart-item",
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(data) {
			// Handle the success response
			console.log(data);
			alert("Item added successfully to cart!");
		},
		error: function(error) {
			// Handle the error response
			console.error(error);
			alert("Error processing the order");
		}
	});
}

function removeItem(itemId) {
	var formData = {
		itemId: itemId
	};

	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/cart-item",
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(data) {
			// Handle the success response
			$('table.cart tr#row_'+itemId).remove();
		},
		error: function(error) {
			// Handle the error response
			console.error(error);
			alert("Error processing the order");
		}
	});
}