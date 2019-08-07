
$(document).ready(function () {
  $('#myform').validate({
	  errorClass:'errors',
   
	  rules: {
		  "username": {
			  required: true,
			  minlength:4
		  },
  		  "password": {
  			  required: true,
  			  minlength:4,
  			  maxlength:16
  		  }
      },
      messages: {
    	  "username": {
    		  required: "Username must required",
    		  minlength: "Username must contain at least {0} characters"
    	  },
    	  "password": {
    		  required: "Password must required",
    		  minlength: "Password must contain at least {0} characters",
    		  maxlength: "Password must contain at least {0} characters"
          }
      },
     
      
   /* submitHandler: function (form) {
      return true;
    }*/
  });	

});