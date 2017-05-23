import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Server implements Runnable{
	
	private ServerSocket server = null;
	private Thread thread = null;
	private ArrayList<ServerThread> threads = null;
	
	public Server(int portNumber){
	
		try{
			System.out.println("----------------- SERVER -----------------");
			
			System.out.println("Creating server on port " + portNumber + ", please wait...");
			server = new ServerSocket(portNumber);
			server.setReuseAddress(true);
			System.out.println("Server created: " + server);
			
			System.out.println("------------------------------------------\n");
			
			threads = new ArrayList<ServerThread>();
			
			start();
			
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void start(){
		if(thread == null)
			thread = new Thread(this); thread.start();
	}
	
	public void stop(){
		if(thread != null)
			thread.interrupt(); thread = null;
	}

	@Override
	public void run() {
		while(thread != null){
			try{
				System.out.println("----------------- CLIENT -----------------");
				System.out.println("Accepting new client...");
				createThread(server.accept());

			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void createThread(Socket socket){
		System.out.println("Connected to client " + socket + "!");
		System.out.println("------------------------------------------\n");
		
		threads.add(new ServerThread(this, socket));
		
		try{
			int newThread = threads.size() - 1;
			threads.get(newThread).open();
			threads.get(newThread).start();
		}catch(IOException ioe){
			System.out.println("Could not start thread: " + ioe);
		}
		
	}
	
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the port on which the server will run:");
		int port = input.nextInt();
		
		try {
			//PRINTS OUT HOST IP FOR OTHER CHATTERS
			System.out.println("Your IP Address is: " + InetAddress.getLocalHost() + "\n");
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
		Server server = new Server(port);
		input.close();
	}

	
}

