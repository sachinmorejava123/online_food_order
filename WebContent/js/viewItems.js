 $(document).ready(function () {
	 alert("hi..");
		    $("form").submit(function () {

		      var clikedForm = $(this);// Select Form
		       if (clikedForm.find("[name='itemName']").val() == '') {
		        alert('Enter Valid mobile number');
		        return false;
		      }
		      if (clikedForm.find("[name='email_id']").val() == '') {
		        alert('Enter  valid email id');
		        return false;
		      }

		    });
		  });
	
	
	
	
	


	
	/*
	alert("alert");
	$(this).validate({
	  
		var v=$(this);
		
	  errorClass:'errors',
   
	  rules: {
		  "itemName": {
			  required: true,
			  minlength:4
		  },
  		  "price": {
  			  required: true,
  			  number: true
  		  },
		  "discount": {
			  required: true,
			  number: true
		  },
  		  "deliveryCharge": {
  			  required: true,
  			  number:true
  		  },
		  "itemStatus": {
			  required: true,
			  minlength:4
		  },
      },
      messages: {
    	  "ItemName": {
    		  required: "Item Name must be required",
    		  minlength: "Item Name must contain at least {0} characters"
    	  },
    	  "price": {
    		  required: "Price must be required",
    		  number: "Price must be number"
    	  },
    	  "discount": {
    		  required: "Discount must be mentioned",
    		  number: "Price must be number"
    	  },
    	  "deliveryCharge": {
    		  required: "Delivery Charge must be mentioned",
    		  number: "Price must be number"
    	  },
    	  "itemStatus": {
    		  required: "not empty",
    		  minlength: "Status must contain at least {0} characters"
    	  },    	  
      },
     
  });	

});*/

