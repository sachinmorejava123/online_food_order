$("document").ready(function(){		
	 var $container = $("#count");
     $container.load("./notification");
     var refreshId = setInterval(function(){
         $container.load('./notification');
     },600000);     
    
});
