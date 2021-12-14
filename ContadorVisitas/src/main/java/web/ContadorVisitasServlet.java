package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        //inicializamos nuestro contador
        int contador = 0;
        
        //Leemos las cookies del navegador der nuestro cliente
        Cookie[] cookies = request.getCookies();
        
        //Comprobamos si existe nuestra cookie
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        //Ahora incrementamos nuestro contador
        contador ++;
        
        //creamos la cookie con el vamor del contador actualizado
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
       
        //Establecemos un tiempo máximo de una hora para nuestra cookie
        c.setMaxAge(3600); //es en segundos
        response.addCookie(c);
        
        //Establecemos el tipo de contenido de respuesta
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("Contador de visitas: " + contador);
        out.close();
    
        
        
       
       /* 
        
        response.setContentType("text/html");
	response.setHeader("Cache-Control", "no-cache");
	
	Cookie[] cookies = request.getCookies();
	Cookie contador = buscaCookie("contador", cookies);
	
	if (contador == null)
	{
	   // Creamos la cookie con el contador
			
	   Cookie cookie = new Cookie ("contador", "1");
	   cookie.setMaxAge(180);
	   response.addCookie(cookie);

	   // Mostramos el mensaje de primera visita

	   PrintWriter out = response.getWriter();
	   out.println ("<HTML>");			
	   out.println ("<BODY>");			
	   out.println ("Primera visita"); 
	   out.println ("<BR>");
	   out.println ("</BODY>");
	   out.println ("</HTML>");

	} else {
	
	   // Obtenemos el valor actual del contador
			
	   int cont = Integer.parseInt(contador.getValue());
	   cont++;
		
	   // Modificamos el valor de la cookie 
	   // incrementando el contador
			
	   Cookie cookie = new Cookie ("contador", "" + cont);
	   cookie.setMaxAge(180);
	   response.addCookie(cookie);

	   // Mostramos el numero de visitas

	   PrintWriter out = response.getWriter();
	   out.println ("<HTML>");
	   out.println ("<BODY>");
	   out.println ("Visita numero " + cont);
	   out.println ("<BR>");
	   out.println ("</BODY>");
	   out.println ("</HTML>");
	}	*/
   }	

   // Busca la cookie 'nombre' 
   // en el array de cookies indicado. 
   // Devuelve null si no esta
/*
   private Cookie buscaCookie(String nombre, Cookie[] cookies)
   {
	if (cookies == null)
	   return null;
	
	for (int i = 0; i < cookies.length; i++)
	   if (cookies[i].getName().equals(nombre))
		return cookies[i];
	
	return null;
   }*/

}
