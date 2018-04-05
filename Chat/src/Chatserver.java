import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class Chatserver {	
	ServerSocket ss =null;
	private boolean bcn = false;
	List<ChatThread> Clients= new ArrayList();
	public static void main(String[] args) {
		new Chatserver().start();
	}
	public void start()
	{
		
		try {
			ss= new ServerSocket(8888);
			bcn=true;
					while(bcn)
			{
				try {
				Socket s=ss.accept();
				System.out.println("a client concent!");
				ChatThread c = new ChatThread(s);
				Clients.add(c);
				Thread t = new Thread(c);
				t.start();
				} catch (IOException e) {
					e.printStackTrace();
									}	
				
			}	
		} catch (IOException e) {
			System.out.print("already run..");
			System.exit(-1);
					}
		finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ChatThread implements Runnable
	{
		DataInputStream ipt =null;
		DataOutputStream opt =null;
		private boolean bc=false;
		Socket s =null;
		public ChatThread(Socket s) {
			this.s = s;
			try{
				ipt =new DataInputStream(s.getInputStream());
				opt =new DataOutputStream(s.getOutputStream());
				bc =true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public void send(String str)
		{
			try {
				opt.writeUTF(str);
			} catch (IOException e) {
				
				System.out.print("a client exit");
			}
		}
		
		public void run() {
			try
			{
				while(bc)
				{	
					String str=ipt.readUTF();

					for(int i=0;i<Clients.size();i++)
					{
						ChatThread c = Clients.get(i);
						c.send(str);
					}
				}
			}
			catch(IOException e)
			{
				System.out.println("a client exit!");
				Clients.remove(this);
				
			} 
			finally {
			
				try {
				if(ipt!=null)	ipt.close();
				if(s!=null) 	s.close();
				if(opt!=null)   opt.close();
				} catch (IOException e) {	
					e.printStackTrace();
				}
		}

			
		}
		
	}
}


