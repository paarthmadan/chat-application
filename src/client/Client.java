package client;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;


public class Client implements Runnable{
	
	private Socket socket = null;
	private DataOutputStream outputStream = null;
	private Scanner input = null;
	private Thread thread = null;
	private ClientThread clientThread = null;
	private volatile boolean isDone = false;
	
	public Client(String ip, int port){
		System.out.println("Establishing a connection to a server..."); 
		try {
			socket = new Socket(ip, port);
			System.out.println("Connected to port " + port + "."); 
			start();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public void handle(String msg){  
		if (msg.equals(".bye")){
			System.out.println("Good bye. Press RETURN to exit ..."); 
			stop();
		}else{
			System.out.println(msg);
		}
	}
	
	public void run(){
		while(!isDone){
			String line = null;
			try{
				line = input.nextLine();
				outputStream.writeUTF(line);
			}catch(SocketException se){
				//socket is closed
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
		
	public void start() throws IOException{
		input = new Scanner(System.in);
		outputStream = new DataOutputStream(socket.getOutputStream());
		
		if(thread == null){
			clientThread = new ClientThread(this, socket);
			thread = new Thread(this);
			thread.start();	
		}
			 
	}
	
	public void close() throws IOException{
		isDone = true;
		outputStream.close();
		socket.close();
		input.close();
		clientThread.close();
		clientThread.interrupt();		
	}

	public void stop(){
		if(thread != null){
			isDone = true;
			thread = null;
		}
		try {
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) throws IOException{
		Scanner initialInput = new Scanner(System.in);
		if(args.length < 2){
			System.out.println("Server Name:");
			String host = initialInput.nextLine();
			System.out.println("Port:");
			int port = Integer.parseInt(initialInput.nextLine());
			Client client = new Client(host, port);
		}else{
			Client client = new Client(args[0], Integer.parseInt(args[1]));
		}
	}


}
