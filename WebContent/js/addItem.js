$(document).ready(function () {
  $('#additem').validate({
	  
	  errorClass:'errors',
   
	  rules: {
		  "itemname": {
			  required: true,
			  minlength:4
		  },
  		  "price": {
  			  required: true,
  			  number:true
  		  },
		  "de_charge": {
			  required: true,
			  digits:true
		  },
  		  "discount": {
  			  required: true,
  			  digits:true
  		  },
  	     "itemStatus": {
			  required: true,
			  minlength:4
		  },
  		 "image": {
 			  required: true,
 		  },
      },
      messages: {
    	  "itemname": {
    		  required: "Item Name must be required",
    		  minlength: "Item Name must contain at least {0} characters"
    	  },
    	  "price": {
    		  required: "Price must be required",
    		  number: "Price must be number only"
    	  },
    	  "de_charge": {
    		  required: "Delivery Charg must be specified",
    		  digits: "Delivery Charge must be number only"
    	  },
    	  "discount": {
    		  required: "Discount must be required",
    		  digits: "Discount must be number only"
    	  },
    	  "itemStatus": {
    		  required: "Item Status must be required",
    		  minlength: "Item Status must contain at least {0} characters"
    	  },
    	  "image": {
    		  required: "Please choose any image",
    	  },
      },
  });	

});