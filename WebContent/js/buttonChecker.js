/* Check if radio button from the form is selected and modify the access to the form's input fields */
 
 	  var radio1 = document.getElementById("radio_lines");
      var radio2 = document.getElementById("radio_words");
      var lineInput1 = document.getElementById("line1");
      var lineInput2 = document.getElementById("line2");

      var wordInput1 = document.getElementById("word1");
      var wordInput2 = document.getElementById("word2");

      if(!radio1.checked && !radio2.checked){
    	  lineInput1.disabled = true;
    	  lineInput2.disabled = true;
    	  wordInput1.disabled = true;
          wordInput2.disabled = true;
      }
      
      radio1.addEventListener("click", ()=>{
         if(radio1.checked){
        	lineInput1.disabled = false;
       	  	lineInput2.disabled = false;
            wordInput1.disabled = true;
            wordInput2.disabled = true;
         }  
      });
      
      radio2.addEventListener("click", ()=>{
         if(radio2.checked){
        	 lineInput1.disabled = false;
        	 lineInput2.disabled = false;
             wordInput1.disabled = false;
             wordInput2.disabled = false;
         }
      });
      
      
      
      
      
      
      
      
      
      