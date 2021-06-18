package nel.sockets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) {
		
		MarcoServidor miMarco = new MarcoServidor();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}

class MarcoServidor extends JFrame implements Runnable { 	// implementa runnable para hacer 2 cosas a la ves: estar a la escucha del 9999 y recibir texto en JTextArea
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MarcoServidor() {
		
		setBounds(500, 250, 400, 300);
		
		JPanel miLamina = new JPanel();
		miLamina.setLayout(new BorderLayout());
		
		areaTexto = new JTextArea();
		miLamina.add(areaTexto, BorderLayout.CENTER);
		
		add(miLamina);
		
		setVisible(true);
		
		Thread hiloEscuchaPrueba = new Thread(this);
		
		hiloEscuchaPrueba.start();
		
	}
	

	@Override
	public void run() {
		
		//System.out.println("Estoy a la escucha!"); 	//probando si funciona
		
		try {
			// crea socket y pone a la escucha en el puerto especificado
			ServerSocket servidor = new ServerSocket(9999);
			
			// creamos 3 variables para almacenar los datos de los paquetes que recibe:
			String nick, ip, mensaje;
			
			// intancia de PaqueteEnvio para almacenar:
			PaqueteEnvio paqueteRecibido;
			
			// arraylist que almacene la ip que se conectan: osea va a ser leido una ves, y cuando se vayan conectando clientes no va a volver a crearse!
			ArrayList<String> listaIP = new ArrayList<String>();
			
			
			// creamos bucle infinito para que deje abierta el puerto: cada ves que lee la instruccion vuelve a abrir el socket, no es necesario que cree el socket pero SI que las acepte
			
			while (true) { 	// el bucle infinito se encuentra dentro de un hilo, por lo que nos permite ejecutar la app en primer plano
				
				// decirle que acepte conexion cualquier conexion que le llegue, utilizamos el metodo accept que devuelve un socket
				Socket miSocket = servidor.accept();
				

				
				// crear flujo de datos de entrada Stream para que le lleguen los datos:
				//DataInputStream flujo_entrada = new DataInputStream(miSocket.getInputStream()); 	// señalamos por donde va a recibir los datos de entrada, por el socket
				
				//String mensajeTexto = flujo_entrada.readUTF();
				
				//areaTexto.append("\n" + mensajeTexto); 	// salto de linea para que cada ves que manda texto no lo mande junto
				
				ObjectInputStream paqueteDatosEntrada = new ObjectInputStream(miSocket.getInputStream());
				
				// le decimos que lea lo que hay en paqueteDatosEntrada y lo almacene en paqueteRecibido
				paqueteRecibido = (PaqueteEnvio) paqueteDatosEntrada.readObject();
				
				nick = paqueteRecibido.getNick();
				ip = paqueteRecibido.getIp();
				mensaje = paqueteRecibido.getMensaje();
				
				// si el mensaje es diferente a Online, que es lo que manda los clientes cuando se conectan.
				if (!mensaje.equalsIgnoreCase("Online")) {
					
					areaTexto.append("\n" + nick + ": " + mensaje + " .Para: " + ip);
				
					// hacer que el servidor reenvie la info al cliente adecuado:
					Socket enviaDestinatario = new Socket(ip, 9090); 	// cambia el puerto
					ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
				
					paqueteReenvio.writeObject(paqueteRecibido); 		// escribimos en paqueteReenvio lo que recibimos.
				
					paqueteReenvio.close(); // cerramos el flujo de datos, despues de escribir en el paquete.
				
					enviaDestinatario.close();
				
					miSocket.close();
				} else { 	// si es la primera ves que se conecta:
					
		// ------------------------DETECTA ONLINE-----------------------
					// almacenamos la direccion del cliente con el que conectamos
					InetAddress localizacion = miSocket.getInetAddress();
					
					String ipRemota = localizacion.getHostAddress();
					
					System.out.println("Online: " + ipRemota);
					
		// --------------------------------------------------------------
					
					// rellenamos el arraylist con las ip que se conecten:
					listaIP.add(ipRemota);
					
					// reutilizamos paqueteRecibido y guardamos la lista de IPs
					paqueteRecibido.setIPs(listaIP);
					
					// for earch para enviar a todos los clientes el arraylist:
					for (String ipConectada: listaIP) {
						// socket flujo de datos con la ip conectada, es decir cada ves que se conecta uno nuevo, reenvia esto.
						Socket enviaDestinatario = new Socket(ipConectada, 9090);
						ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
					
						paqueteReenvio.writeObject(paqueteRecibido); 		// escribimos en paqueteReenvio lo que recibimos.
					
						paqueteReenvio.close();
					
						enviaDestinatario.close();
					
						miSocket.close();
						
					}
					
				}
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Error de clase no encontrada! " + e.getMessage());
			
		}
		
		
		catch (IOException e) {
			
			System.out.println("No se pudo poner a la escucha el servidor: " + e.getMessage());
			
		}
		
	}
	
	
	private JTextArea areaTexto;
	
}




