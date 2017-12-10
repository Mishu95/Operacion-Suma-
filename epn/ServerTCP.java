package epn;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerTCP {
	
	private static int PORT=9090; //se establece el puerto que se usará a 9090

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket=new ServerSocket(PORT); //Se crea un socket de servidor que pide el puerto para usar.
		System.out.println("Server listening on port "+PORT); // imprime en consola el puerto que el servidor se conecta.
		
		try{
			while(true){
				Socket socket= serverSocket.accept();//Se crea un socket que acepta las conexiones de clientes
				try{
					DataInputStream entrada = new DataInputStream(socket.getInputStream());
					//DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
										
					PrintWriter out= new PrintWriter(socket.getOutputStream(), true);//Se declara un objeto out para poder enviar datos al cliente
					out.println("Bienvenido a la calculadora");//Envia un mensaje al cliente
										
					out.println("Ingrese el primer número");// Envia el mensaje al cliente
					
					int a= entrada.read();//Recibe y guarda un dato entero que es enviado por el cliente
										
					out.println("Ingrese el segundo número"); //Envia el mensaje para mostrar al cliente
					
					int b= entrada.read();//Recibe y guarda un dato enter, el mismo que es enviado por el cliente
									
					int c=suma(a,b);//LLama a la funcion suma() enviando los datos obtenidos del cliente
					out.println(c);//Envia un dato de resultado de sumar por medio de la funcion suma()
					
					
				}finally{
					socket.close();//Deja de aceptar conexion de cliente
				}
			}
		}
		finally{
			serverSocket.close();//Cierra la conexion del servidor
	}
	
	}
	
	public static int suma(int a, int b){
		return a+b;
	}

}
