import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread{
	
	private Client client = null;
	private Socket socket = null;
	private DataInputStream inputStream = null;
	private volatile boolean isDone = false;
	
	public ClientThread(Client client, Socket socket){
		this.client = client;
		this.socket = socket;
		open();
		start();
	}
	
	public void open(){
		try{
			inputStream = new DataInputStream(socket.getInputStream());
		}catch(IOException ioe){
			System.out.println("Error getting input stream: " + ioe);
			client.stop();
		}
	}
	
	public void close(){
		try{
			if(inputStream != null)
				inputStream.close();
		}catch(IOException ioe){
			System.out.println("Error closing input stream: " + ioe);
		}
		
		isDone = true;
	}
	
	public void run(){
		while(!isDone){
			try{
				client.handle(inputStream.readUTF());
			}catch(IOException ioe){
				System.out.println("Listening error" + ioe.getMessage());
				client.stop();
			
			}
		}
	}
}
