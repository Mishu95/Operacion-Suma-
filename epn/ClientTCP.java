package epn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientTCP {

	public static int SERVER_PORT=9090;//El puerto que el cliente usara para la conexion

	public static void main(String[] args) throws IOException {
		String serverAddress= JOptionPane.showInputDialog("Ingrese la direccion IP del servidor: ");//Pide la direccion IP para establecer la conexion

		//Establece la conexion con el servidor mediante un socket
		Socket clientSocket = new Socket(serverAddress, SERVER_PORT);

		//obtiene el mensaje enviado por el servidor a traves del socket
		InputStreamReader inputStream= new InputStreamReader(clientSocket.getInputStream());
		BufferedReader input= new BufferedReader(inputStream);//Presentation--> objeto para leer los datos del mensaje

		String answer=input.readLine();//Presentation --> Obtiene un dato enviado por el servidor 
		JOptionPane.showMessageDialog(null,answer);//Muestra en una ventana el dato que recibio del servidor

		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());//objeto que servira para enviar datos al servidor


		answer=input.readLine();//obtiene un dato del servidor
		JOptionPane.showMessageDialog(null,answer);//muestra el dato obtenido del servidor en una ventana

		int a=Integer.parseInt(JOptionPane.showInputDialog("Primer número"));//Pide un dato y lo convierte a entero 
		out.write(a);//Envia ese dato a un servidor

		answer=input.readLine();//Obtiene el dato enviado por un servidor
		JOptionPane.showMessageDialog(null,answer);//Muestra el dato obtenido del servidor. Es un string.
		int b=Integer.parseInt(JOptionPane.showInputDialog("Segundo número"));//Pide otro dato y lo convierte a entero
		out.write(b);//envia ese dato al servidor

		answer=input.readLine();//Obtiene el dato enviado por un servidor
		JOptionPane.showMessageDialog(null,"Resultado de la suma "+a+" + "+b+" es: "+answer);//muestra el resultado enviado por el servidor y los sumandos

		System.exit(0);//finaiza la conexion

	}
}