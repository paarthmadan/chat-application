import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	
	Socket socket = null;
	DataOutputStream outputStream = null;
	Scanner input = null;
	
	public Client(int port) throws IOException{
		System.out.println("Establishing a connection to a server..."); 
		try {
			socket = new Socket(String.valueOf(port), port);
			System.out.println("Connected to port " + port + "."); 
			start();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		boolean isDone = false;
		
		while(!isDone){
			String line = input.nextLine();
			if(line.equalsIgnoreCase("done")){
				isDone = true;
			}
			try {
				outputStream.writeUTF(line);
				outputStream.flush();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
		outputStream.close();
		socket.close();
	}
	
	public void start() throws IOException{
		input = new Scanner(System.in);
		outputStream = new DataOutputStream(socket.getOutputStream());
	}
	
	public static void main(String [] args) throws IOException{
		Scanner initialInput = new Scanner(System.in);
		System.out.println("Enter server port: ");
		Client client = new Client(initialInput.nextInt());
		initialInput.close();
	}
}
