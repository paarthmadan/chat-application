import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server implements Runnable{
	
	private ServerSocket server = null;
	private Socket socket = null;
	private DataInputStream streamInput = null;
	private Thread thread = null;
	
	public Server(int portNumber){
	
		try{
			System.out.println("Creating server on port " + portNumber + ", please wait...");
			server = new ServerSocket(portNumber);
			System.out.println("Server created: " + server);
			
			start();
			
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void open() throws IOException{
		streamInput = new DataInputStream(socket.getInputStream());
	}
	
	public void close() throws IOException{
		socket.close();
		streamInput.close();
	}
	
	public void start(){
		if(thread == null)
			thread = new Thread(this); thread.start();
	}
	
	public void stop(){
		if(thread != null)
			thread.interrupt(); thread = null;
	}

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the port on which the server will run:");
		int port = input.nextInt();
		
		try {
			//PRINTS OUT HOST IP FOR OTHER CHATTERS
			System.out.println("Your IP Address is: " + InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
		Server server = new Server(port);
	}

	@Override
	public void run() {
		while(thread != null){
			try{
				System.out.println("Waiting for client...");
				socket = server.accept();
				System.out.println("Connected to client!");
				
				//open socket and streams
				open();
				
				boolean isClientDone = false;
				
				while(!isClientDone){
					String input = streamInput.readUTF();
					if(input == null)
						isClientDone = true;
					System.out.println(socket.getLocalPort() + ": " + input);
					isClientDone = input.equalsIgnoreCase("done");
				}
				
				//close socket and streams
				close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}

