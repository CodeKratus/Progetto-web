package it.betacom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.bean.Clienti;
import it.betacom.bean.LoginBean;
import it.betacom.dao.ClientiDao;
import it.betacom.dao.LoginDao;
import it.betacom.dao.PSUserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	int cont;
	/**
		 * 
		 */
	private static final long serialVersionUID = 5284667188786893699L;
	/**
	 * Servlet implementation class LoginServlet
	 */

	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PRENDE I PARAMETRI DAL FORM IN LOGIN ATTRAVERSO IL CAMPO NAME
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ISTANZIA LA CLASSE LOGIN E SETTA USERNAME E PASSWORD
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
// RICHIAMA IL METODO CHE RITORNA UN TRUE SE PASSWORD E US NEL DB SONO ENTRAMBI
// CORRETTI
			if (loginDao.validateE(loginBean)) {
// RICHIAMO DEI METODI
// IL PRIMO PRENDE IL RUOLO DAL DB PRENDENDO L'EMAIL
				String checkRole = PSUserDao.getRoleE(username);
// IL SECONDO PRENDE LO STATUS DAL DB PRENDENDO L'EMAIL
				String checkPwdStat = PSUserDao.getPwdStatusE(username);
				String checkStatus = PSUserDao.getStatusE(username);
				int takeId = PSUserDao.getIdbyE(username);
// CONTROLLO SE IL RUOLO è UGUALE A 'M' O 'G' E SE LO STATUS è ATTIVO E SE HA BISONGO DI MODIFICARE LA PASSWORD
// CON VARI CONTROLLI
				if (checkRole.equals("M") && checkStatus.equals("A") && checkPwdStat.equals("N")) {
					request.setAttribute("role", checkRole);
// USO REQUESTDISPATCHER PER LEGGERE GLI ATTRIBUTI DELLA STESSA SESSIONE
// SE USASSI SENDREDIRECT DOVREI SETTARE GLI ATTRIBUTI DIRETTAMENTE NEL FILE JSP
					request.getRequestDispatcher("listaClienti.jsp").forward(request, response);
//                 response.sendRedirect("listaClienti.jsp");
				}else if (checkRole.equals("G") && checkStatus.equals("A") && checkPwdStat.equals("N")) {
					request.setAttribute("role", checkRole);
					request.getRequestDispatcher("listaClienti.jsp").forward(request, response);
				}
//CASE: HAI BISOGNO DI MODIFICARE LA PASSWORD				
				else if (checkRole.equals("M") && checkStatus.equals("A") && checkPwdStat.equals("Y")) {
					System.out.println("Sono quiii");
					request.setAttribute("id", takeId);
					request.getRequestDispatcher("changePWDForm.jsp").forward(request, response);

				} else if (checkRole.equals("G") && checkStatus.equals("A") && checkPwdStat.equals("Y")) {
					System.out.println("Sono quooo");
					request.setAttribute("id", takeId);
					request.getRequestDispatcher("changePWDForm.jsp").forward(request, response);
//CASE: STATO DISABILITATO
				}
				else if (checkRole.equals("M") && checkStatus.equals("D")) {
					String message = "Status disabilitato per questo utente";
					request.setAttribute("message", message);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
				} else if (checkRole.equals("G") && checkStatus.equals("D")) {
					String message = "Status disabilitato per questo utente";
					request.setAttribute("message", message);
                    request.getRequestDispatcher("login.jsp").forward(request, response);

				} else { 
// ALTRIMENTI RIMANDO ALLA PAGINA LOGIN
					String message = "Ruolo inesistente per questo utente";
					request.setAttribute("message", message);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
//CONTROLLO NOME ... SE IL NOME CORRISPONDE MA NON LA PASSWORD 
//HAI TRE TENTATIVI
			} else if (loginDao.checkUnameE(loginBean)) {
				
				String checkStatus = PSUserDao.getStatusE(username);
				
				if(checkStatus.equals("A")){
					
					cont++;
				if (cont < 3) {
					String message = "Password non valida " + cont + "° tentativo";
					request.setAttribute("message", message);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}

				else {

				//SE SUPERI I TRE TENTATIVI IMPOSTO LO STATUS SU 'D' DISATTIVO 	
					PSUserDao.setStatusE(username);
					response.sendRedirect("login-error.jsp");
					cont = 0 ;
					
				}}else {
					String message = "Status disabilitato per questo utente";
				request.setAttribute("message", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}
                  //QUESTO è IL CASO IN CUI NON CORRISPONDE L'USERNAME
			} else {
				String message = "Username non valido";
				request.setAttribute("message", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}