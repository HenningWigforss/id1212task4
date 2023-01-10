<%-- 
    Document   : home
    Created on : 8 jan. 2023, 11:02:53
    Author     : Henning, Rola
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Number Guess Game</title>
    </head>
    <body>
        <div id="message">
            <%
                if (request.getSession(false).getAttribute("GameBean") == null || request.getSession(false).getAttribute("Status").equals("Start")){
                out.print("<h1>Welcome to the Number Guess Game. Guess a number between 1 and 100.</h1>");
                }
                else{
            
                String status = (String) request.getSession(false).getAttribute("Status");
                int numberOfGuesses = (int) request.getSession(false).getAttribute("NumberOfGuesses");
                int lastGuess = (int) request.getSession(false).getAttribute("LastGuess");
                out.print("<h1>Number Guess Game</h1>");  
                out.print("Your last guess: "+lastGuess);
                out.print("<br>Total number of guess "+numberOfGuesses+"<br>");
                switch(status){
                case "Out of bounds":
                    out.print("Your last guess was out of bounds, you can only guess a number between 1-100 ");
                break;
            
                case "Higher":
                    out.print("Your last guess was to High, make a lower guess");
                break;
            
                case "Lower":
                    out.print("Your last guess was to Low, make a higher guess");
                break;
            
                case "Correct":
                    out.print("Congratulation you guessed the right number , press submit to play again.");
                break;
                }
                }
            %>

        </div>    
        <form id="form" action="GameServlet" method="GET" >
            <input type="text" name="guess">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
