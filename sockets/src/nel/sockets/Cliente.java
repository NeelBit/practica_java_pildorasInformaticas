package nel.sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;
import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Cliente {

	public static void main(String[] args) {
		
		System.out.println("Hola");
		MarcoClienteChat miMarcoChatCliente = new MarcoClienteChat();
		miMarcoChatCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoChatCliente.setVisible(true);
		
	}

}

class MarcoClienteChat extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MarcoClienteChat() {
		
		System.out.println("Marco creado");
		
		setBounds(300, 200, 400, 450);
		
		LaminaClienteChat miLaminaClienteChat = new LaminaClienteChat();
		
		add(miLaminaClienteChat);
		//setVisible(true);
		
		System.out.println("setVisible(true)");
		
		// añadir evento de ventana, y ejecutar el metodo windowOpened de la clase EnvioOnline
		addWindowListener(new EnvioOnline());
		
	}
	
}

// clase para gestionar evento de ventana, para que al abrir la app ya envie la ip al servidor y que sepa que estamos conectados.
class EnvioOnline extends WindowAdapter { 	// clase adaptadora de evento de ventana, para no tener que escribir todos lo metodos, utilizamos la adaptadora.
	
	// sobre-escribir metodo para que se ejecute accion al abrir la ventana:
	public void windowOpened(WindowEvent e) {
		
		// IP DEL SERVIDOR VA ACA! y el puerto del servidor que esta a la escucha.
		try {
			
			Socket miSocket = new Socket("192.168.0.1", 9999);
			
			// reutilizamos la clase paqueteEnvio para almacenar
			PaqueteEnvio datos = new PaqueteEnvio();
			datos.setMensaje("Online"); 	// 
			
			// creamos el objetOutputStream para poder enviar este objeto y que lo reciba el servidor.
			ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
			
			// escribimos en ese objeto de datos los datos que queremos enviar:
			paqueteDatos.writeObject(datos);
			
			miSocket.close();
			
			
		} catch (IOException e1) {
			
			System.out.println("Problema de IOException al conectarse al servidor. " + e1.getMessage());
			
		}
		
		
		
	}
	
}

// tiene que estar a la escucha, entonces es necesario crear un hilo
class LaminaClienteChat extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LaminaClienteChat() {
		
		String name = JOptionPane.showInputDialog("Ingrese su Nick: ");
		
		JLabel yo = new JLabel("Nick: ");
		add(yo);
		
		nick = new JLabel();
		nick.setText(name);
		add(nick);
		
		JLabel texto = new JLabel("Online: ");
		add(texto);
		
		ip = new JComboBox();
		/*ip.addItem("Usuario 1");
		ip.addItem("Usuario 2");
		ip.addItem("Usuario 3");*/
		add(ip);
		
		campoChat = new JTextArea(12,30);
		add(campoChat);
		
		textoEnviar = new JTextField(25);
		add(textoEnviar);
		
		miBoton = new JButton("Enviar");
		
		miBoton.addActionListener(new EnviaTexto());
		add(miBoton);
		
		// hilo para poner a la escucha el cliente de lo que reciba:
		Thread hiloEscucha  = new Thread(this); 	// this ya que es la propia clase donde nos encontramos la que tiene este hilo. si fuese otra clase aca hiría la instancia
		
		hiloEscucha.run();
		
	}
	
	// clase interna para evento de enviar texto
	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//System.out.println(campo1.getText()); 	// imprimir en consola el texto del JTextField para ver que funciona hasta ahora
			
			// construir socket para que empiece a fluir las datos: ip mia local
			
			// mostrar tambien los mensajes que envio: en el chat
			campoChat.append("\n" + " YO: " + textoEnviar.getText());
			
			try {
				// mi Ip local o sino pongo como esta ó sino, InetAddress.getLocalHost().getHostAddress()
				//"192.168.207.193"
				// aquí en realidad va la IP del servidor!.
				
				Socket miSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
				
				//intanciamos la clase que creamos donde se van a almacenar nick, ip y mensaje
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				datos.setIp(ip.getSelectedItem().toString());
				datos.setMensaje(textoEnviar.getText());
				
				// como vamos a enviar un objeto no nos sirvo mas DataOutputStream, vamos a usar ObjectOutputStream
				ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
				
				// indicar que en paqueteDatos queremos enviar datos, la instancia de PaqueteEnvio
				paqueteDatos.writeObject(datos);
				
				
				
				miSocket.close();
				
				// los datos van a salir del cliente
				//DataOutputStream flujo_salida = new DataOutputStream(miSocket.getOutputStream());
				
				// en el flujo de datos de salida va a viajar el texto del textoEnviar
				//ese flujo circulara por el socket y ese socket se esta dirigiendo a esa ip y puerto
				//flujo_salida.writeUTF(textoEnviar.getText());
				
				//flujo_salida.close();
				
			} catch (IOException e1) {
				
				System.out.println("Error de conexion: " + e1.getMessage());
				
			}
			
			
		}
		
		
	}
	
	@Override
	public void run() {
		
	// indicar al cliente que va a recibir respuesta del servidor, que a su ves la mando otro cliente: debe estar a la escucha permanente el hilo
		try {
			
			// abrimos y dejamos a la escucha
			ServerSocket servidorCliente = new ServerSocket(9090); 	// si le dijimos que debe enviar a ese puerto, la app debe estar a la escucha a ese puerto
			
			// canal o socket por el que va a recibir el paquete
			Socket cliente;
			
			// variable tipo PaqueteEnvio para almacenar el paquete:
			PaqueteEnvio paqueteRecibido;
			
			// dejar permanentemente a la escucha el hilo
			while (true) {
				
				// el socket aceptando el serversocket en ese puerto
				cliente = servidorCliente.accept();
				
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream()); // le indicamos que use el socket que creamos
				
				paqueteRecibido = (PaqueteEnvio)flujoEntrada.readObject();
				
				
				
				if (!paqueteRecibido.getMensaje().equalsIgnoreCase("Online")) { // si no recibis el mensaje online, quiere decir que ya estamos chateando
					
					campoChat.append("\n" + paqueteRecibido.getNick() + " : " + paqueteRecibido.getMensaje());
					
				}else { 	// cuando se conecta nuevo cliente
					
					//campoChat.append("\n" + paqueteRecibido.getIPs()); 	// se conecta nuevo cliente, mostrar arraylist de IPs
					
					ArrayList<String> IPsMenu = new ArrayList<String>();
					
					// le decimos que ipsmenu es igual al arraylist de ip que recibimos
					IPsMenu = paqueteRecibido.getIPs();
					
					// metodo para borrar todos los items del JComboBox, antes de añadir nuevamente
					ip.removeAllItems();
					
					for (String ips : IPsMenu) {
						
						// agregamos al JComboBox llamado ip, las ips que recibe:
						ip.addItem(ips);
						
					}
					
				}
				
			}
			
			
			
			
		} catch (ClassNotFoundException | IOException e) {
			
			System.out.println("Error de conexión en el cliente destino. " + e.getMessage());
			
		}
		
		
	}
	
	private JTextField textoEnviar;
	
	private JComboBox ip;
	
	private JLabel nick;
	
	private JButton miBoton;
	private JTextArea campoChat;
	
	
	
}

// clase para crear objetos que empaqueten mensaje, ip y nick:
// necesitamos serializar para poder convertir nuestra paquete en bytes.
class PaqueteEnvio implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public ArrayList<String> getIPs() {
		return IPs;
	}

	public void setIPs(ArrayList<String> iPs) {
		IPs = iPs;
	}
	
	
	private String nick, ip, mensaje;
	
	private ArrayList<String> IPs;
	
}




