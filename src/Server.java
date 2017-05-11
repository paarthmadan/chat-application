import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	
	private ServerSocket server = null;
	private Socket socket = null;
	private DataInputStream streamInput = null;
	
	public Server(int portNumber){
	
		try{
			System.out.println("Creating server on port " + portNumber + ", please wait...");
			server = new ServerSocket(portNumber);
			System.out.println("Server created: " + server);
			
			System.out.println("Waiting for client...");
			socket = server.accept();
			
			//open socket and streams
			open();
			
			boolean isClientDone = false;
			
			while(streamInput.readUTF() != null && !isClientDone){
				
				String input = streamInput.readUTF();
				System.out.println(input);
				isClientDone = input.equalsIgnoreCase("done");
				
			}
			
			//close socket and streams
			close();
			
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

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter port number");
		
		int port = input.nextInt();
		Server server = new Server(port);
		
	}
	
}
