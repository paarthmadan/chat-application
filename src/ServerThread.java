import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{
	
	private Server server = null;
	private Socket socket = null;
	private final int ID;
	private DataInputStream streamInput = null;
	
	
	public ServerThread(Server server, Socket socket){
		this.server = server;
		this.socket = socket;
		this.ID = socket.getPort();
	}
	
	public void run(){
		boolean isClientDone = false;
		
		while(!isClientDone){
			String input = null;
			try {
				input = streamInput.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(ID + ": " + input);
			isClientDone = input.equalsIgnoreCase("done");
		}
		
		//close socket and streams
		try {
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void open() throws IOException{
		streamInput = new DataInputStream(socket.getInputStream());
	}
	
	public void close() throws IOException{
		socket.close();
		streamInput.close();
	}
	
	
}
