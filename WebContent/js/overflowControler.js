	/* Checks if div's height and/or width is too small to display the whole message 
		from the program and then add a scroll to the div */

	var div = document.getElementById("generator-console");
	
	
	if(div.scrollWidth > div.clientWidth){
		div.style.overflowX = ("scroll");	
	} else {
		div.style.overflowX = ("hidden");	
	}
	
	if(div.scrollHeight > div.clientHeight){
		div.style.overflowY = ("scroll");	
	} else {
		div.style.overflowY = ("hidden");	
	}
	
	
    
     
    