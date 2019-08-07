$(document).ready(function () {
  $('#myform').validate({
	  
	  errorClass:'errors',
   
	  rules: {
		  "fullname": {
			  required: true,
			  minlength:4
		  },
  		  "dob": {
  			  required: true,
  			  date: true
  		  },
		  "gender": {
			  required: true,
		  },
  		  "mobile": {
  			  required: true,
  			  minlength:10,
  			  maxlength:10,
  			  digits:true
  		  },
		  "email": {
			  required: true,
			  email:true
		  },	  
		  "country": {
			  required: true,
		  },
		  "state": {
			  required: true,
		  },
		  "city":{ 
			  required: true,
		  },
  		  "address": {
  			  required: true,
  			  minlength:5,
  		  },
  		  "pincode": {
			  required: true,
			  minlength:6,
			  maxlength:6,
			  digits:true
		  },
		  "username": {
			  required: true,
			  minlength:4
		  },
		  "password": {
			  required: true,
			  minlength:4,
			  maxlength:16
		  },
		  "re_pass": {
			  required: true,
			  minlength:4,
			  maxlength:16,
			  equalTo: "#pass",
		  },
		  "oldPassword": {
			  required: true,
			  minlength:4,
			  maxlength:16
		  },
		  "newPassword": {
			  required: true,
			  minlength:4,
			  maxlength:16
		  },
		  "reNewPassword": {
			  required: true,
			  minlength:4,
			  maxlength:16,
			  equalTo: "#newPass"
		  },
      },
      messages: {
    	  "fullname": {
    		  required: "Full Name must be required",
    		  minlength: "Full Name must contain at least {0} characters"
    	  },
    	  "dob": {
    		  required: "Date of Birth must be required",
    		  date: "Only this Pattern dd/mm/yyyy"
    	  },
    	  "gender": {
    		  required: "Gender must be required",
    	  },
    	  "mobile": {
    		  required: "Mobile number must be required",
    		  minlength: "Number must contain at least {0} characters",
    		  maxlength: "Number must contain at almost {0} characters",
    		  digits: "Mobile number must be number only"
    	  },
    	  "email": {
    		  required: "Valid email must be required",
    		  email: "Email pass like this pattern akram@abc.com"
    	  },
    	  "country": {
    		  required: "Country name must be required",
    	  },
    	  "state": {
    		  required: "State name must be required",
    	  },
    	  "city": {  
    	  		required: "City name must be required",
    	  },
    	  "address": {
    		  required: "Address must be required",
    		  minlength: "Address must contain at least {0} characters",
          },
          "pincode": {
    		  required: "Pincode must required",
    		  minlength: "Pincode must be contain at least {0} characters",
    		  maxlength: "Pincode must be contain at almost {0} characters",
    		  digits: "Pincode must be number only"
          },
          "username": {
    		  required: "Username must be required and unique",
    		  minlength: "Username must be contain at least {0} characters",
          },
    	  "password": {
    		  required: "Password must be required",
    		  minlength: "Password must be contain at least {0} characters",
    		  maxlength: "Password must be contain at almost {0} characters"
          },
    	  "re_pass": {
    		  required: "Re-Password must required",
    		  minlength: "Re-Password must contain at least {0} characters",
    		  maxlength: "Re-Password must contain at almost {0} characters",
    		  equalTo: "Please password and re-Password must be same."
          },
          "oldPassword": {
    		  required: "Old Password must be required and unique",
    		  minlength: "Old Password must contain at least {0} characters",
    		  maxlength: "Old Password must contain at almost {0} characters"
          },
    	  "newPassword": {
    		  required: "New Password must required",
    		  minlength: "New Password must contain at least {0} characters",
    		  maxlength: "New Password must contain at almost {0} characters"
          },
    	  "reNewPassword": {
    		  required: "Re-NewPassword must be required",
    		  minlength: "Re-NewPassword must contain at least {0} characters",
    		  maxlength: "Re-NewPassword must contain at almost {0} characters",
    		  equalTo: "Please NewPassword and Re-NewPassword must be same."
          },
      },
     
      
   /* submitHandler: function (form) {
      return true;
    }*/
  });	

});