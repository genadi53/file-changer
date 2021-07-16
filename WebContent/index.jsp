<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File Manipulator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

    <div class="wrapper" style="">
        <form action="changeFile" method="post" class="form">
          <div class="input-fields">
            <input class="input"  type="text" name="filePath" placeholder="Enter path to the file." required>
            
            <div class="radio">
                <input type="radio" id="radio_lines" name="change" value="swapLines" required>
                <label for="lines">Swap lines.</label>
      
                <input type="radio" id="radio_words" name="change" value="swapWords" >
                <label for="words">Swap words.</label>
            </div>
            
             <input type="number" class="input" id="line1" name="line1" required min=1 placeholder="First Line Position">
             <input type="number" class="input" id="line2" name="line2" required min=1 placeholder="Second Line Position">
             <input type="number" class="input" id="word1" name="word1" required min=1 placeholder="First Word Position">
             <input type="number" class="input" id="word2" name="word2" required min=1 placeholder="Second Word Position">

             <div class="generator-console" id="generator-console">
       		
                <% String message = (String) request.getAttribute("message"); %>
                <% if(message != null) { %>
                    <% out.println(message); %>
                <% } %>
                
           </div>
             <div class="btn">
                 <input type="submit" class="submit">
             </div>
           </div>
        </form>
    </div>
    
     <script type="text/javascript" src="js/buttonChecker.js"></script>
     <script type="text/javascript" src="js/overflowControler.js"></script>
</body>
</html>