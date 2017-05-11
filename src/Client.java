import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	
	private Socket socket = null;
	private DataOutputStream outputStream = null;
	private Scanner input = null;
	
	public Client(String ip, int port) throws IOException{
		System.out.println("Establishing a connection to a server..."); 
		try {
			socket = new Socket(ip, port);
			System.out.println("Connected to port " + port + "."); 
			start();
			
			boolean isDone = false;
			
			while(!isDone){
				String line = input.nextLine();
				System.out.println("Sending: " + line);
				if(line.equalsIgnoreCase("done")){
					isDone = true;
				}
				try {
					outputStream.writeUTF(line);
				} catch (IOException e) {
					System.out.println(e);
				}
				
				outputStream.flush();
				
			}
			
		} catch (IOException e) {
			System.out.println(e);
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
		
		System.out.println("Enter server name: ");
		String ip = initialInput.nextLine();
		System.out.println("Enter server port: ");
		int port = initialInput.nextInt();
		
		Client client = new Client(ip, port);
		initialInput.close();
	}
}
