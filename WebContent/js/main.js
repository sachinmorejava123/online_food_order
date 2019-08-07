
(function ($) {
    "use strict";

     /*==================================================================
    [ Focus input ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }
        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });
    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
        
   /* For country ,state and city
    * <===================================>
    * */
   
    $.get("AddressController",function(data){
    	
    	var a="<option disabled='disabled' selected='selected'>Select-Country</option>";
    	
    	$.each(data,function(key,value){   	
    		
    		a+="<option value="+value.cid+">"+value.countryName+"</option>" 
    		
    	});
    	$("#conid").append(a);
    	
    });
    
    
    $("#conid").change(function() {
    	var sid=$("#conid").val();
    	 $.get("StateController?stateid="+sid,function(data){    		 
    		  var cs="<option disabled='disabled' selected='selected'>Select-State</option>";    		  
    		  $.each(data,function(key,value){
    		  	cs=cs+"<option value="+value.stateId+">"+value.stateName+"</option>";
    		  
    		  });
    		  $("#sid").empty();
    		  
    			  $("#sid").append(cs);    		  
    	 });    
    });
    
    $("#sid").change(function() {
    	var ciid=$("#sid").val();
    	 $.get("CityController?cityid="+ciid,function(data){    		 
    		  var cs="<option disabled='disabled' selected='selected' >Select-City</option>";
    		  $.each(data,function(key,value){
    		  	cs=cs+"<option value="+value.cityId+">"+value.cityName+"</option>";
    		  
    		  });
    		  $("#cityid").empty();
    			  $("#cityid").append(cs);    		  
    	 });    
    });
    
    
    
   /* for select Status */
    $.get("StatusController",function(data){    	
    	var a="<option value='Select-Status'>Select-Status</option>";    	
    	$.each(data,function(key,v){  	    		
    		a+="<option value="+v.orderStatusId+">"+v.orderStatusName+"</option>" ;    		
    	});
    	$(".statusid").append(a);    	
    });
        
   /*  For increment or decrement quantity
     * <===================================>*/
    var incrementPlus;
    var incrementMinus;

    var buttonPlus  = $(".cart-qty-plus");
    var buttonMinus = $(".cart-qty-minus");

    var incrementPlus = buttonPlus.click(function() {
    	var $n = $(this)
    		.parent(".button-container")
    		.parent(".container")
    		.find(".qty");
    	$n.val(Number($n.val())+1 );
    });
    var incrementMinus = buttonMinus.click(function() {
    		var $n = $(this)
    		.parent(".button-container")
    		.parent(".container")
    		.find(".qty");
    	var amount = Number($n.val());
    	if (amount > 0) {
    		$n.val(amount-1);
    	}
    });
  
})(jQuery);