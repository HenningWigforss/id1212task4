package Game;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Henning
 */
public class GameServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = request.getSession(true);
        
        GameBean game = new GameBean();
        GameBean temp = (GameBean) httpSession.getAttribute("GameBean");
        
        if(temp!=null){
            game = temp;
        }
        String status;
        int numberOfGuesses;
        int lastGuess;

        if(game.getGameFinished()){
            game.resetGame();
            status = game.getResponse();
            numberOfGuesses = game.getNumberOfGuesses();
            lastGuess = game.getLastGuess();
                    
        httpSession.setAttribute("Status", status);
        httpSession.setAttribute("NumberOfGuesses", numberOfGuesses);
        httpSession.setAttribute("LastGuess", lastGuess);
        httpSession.setAttribute("GameBean", game);
        }else{
        int guess = Integer.parseInt(request.getParameter("guess"));
        game.checkGuess(guess);
        status = game.getResponse();
        numberOfGuesses = game.getNumberOfGuesses();
        lastGuess = game.getLastGuess();
        
  
        httpSession.setAttribute("Status", status);
        httpSession.setAttribute("NumberOfGuesses", numberOfGuesses);
        httpSession.setAttribute("LastGuess", lastGuess);
        httpSession.setAttribute("GameBean", game);
        }

        
	response.sendRedirect("home.jsp");
    }
    
    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
