import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{
	
	private Server server = null;
	private Socket socket = null;
	private final int ID;
	private DataInputStream streamInput = null;
	private DataOutputStream streamOutput = null;
	private boolean isDone = false;
	
	public ServerThread(Server server, Socket socket){
		this.server = server;
		this.socket = socket;
		this.ID = socket.getPort();
	}
	
	public void run(){
		while(!isDone){
			try {
				server.handle(ID, streamInput.readUTF());
				System.out.println("handled");
			} catch (IOException ioe) {
				//Expected EOF error
			} 
		}		
	}
	
	public void send(String message){
		try{
			streamOutput.writeUTF(message);
			streamOutput.flush();
			System.out.println(message + " sent to client: " + ID);
		}catch(IOException e){
			//handle
			server.removeThread(ID);
		}
	}
	
	public void open() throws IOException{
		streamInput = new DataInputStream(socket.getInputStream());
		streamOutput = new DataOutputStream(socket.getOutputStream());
	}
	
	public void close() throws IOException{
		isDone = true;
		socket.close();
		streamInput.close();
	}
	
	//GETTERS
	public int getID(){
		return ID;
	}
	
}
