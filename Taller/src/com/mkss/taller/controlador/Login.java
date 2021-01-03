package com.mkss.taller.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mkss.taller.capaDatos.DaoUsuario;
import com.mkss.taller.modelo.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//UsuarioDaoTreeMap dao = UsuarioDaoTreeMap.getInstancia();
		DaoUsuario dao = Configuracion.daoUsuarios;
		Usuario usuario = dao.obtenerPorEmail(email);
		
		
		
		 
		if(usuario != null && usuario.getPassword().equals(password)) {
			request.getSession().setAttribute("usuario", usuario);			
			//request.getRequestDispatcher("/admin/index").forward(request, response);
			response.sendRedirect(request.getContextPath()+ "/inicio");
		} else {
			request.setAttribute("alertaTexto", "el usuario o la contraseña son incorrectos");
			request.setAttribute("alertaNivel", "danger");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

}
