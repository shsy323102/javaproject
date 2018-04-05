import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class ChatClient extends Frame{
    private boolean flag=false;
	TextField tx=new TextField();
	TextArea  ta=new TextArea();
	Socket s = null;
	DataOutputStream opt=null;
	DataInputStream ipt =null;
	Thread t= new Thread(new IptThread());
	public void draw()
	{
		
		this.setLocation(300,100);
		this.setSize(300, 400);
		this.add(tx,BorderLayout.SOUTH);
		tx.addActionListener(new TfListener());
		this.add(ta,BorderLayout.NORTH);
		this.pack();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {	
				try {
					opt.close();
					ipt.close();
					System.exit(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
						}
			
		});
		this.setVisible(true);
		this.concent();
		t.start();
		
	}
	public void concent()
	{
		try {
			s =new Socket("127.0.0.1",8888);
			opt = new DataOutputStream(s.getOutputStream());
			ipt = new DataInputStream(s.getInputStream());
			flag=true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatClient().draw();
	}
	private  class TfListener implements ActionListener
	{

			public void actionPerformed(ActionEvent e) {
			
				String t = tx.getText().trim();
			//	ta.setText(t);
				tx.setText("");
				try {
					 
					opt.writeUTF(t);
					opt.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}			
		}	
	}
	class IptThread implements Runnable{

		public void run() {
			try {
					while(flag)
					{
						String str =ipt.readUTF();
						ta.setText(ta.getText()+str+'\n');
					}
				}catch (IOException e) {
					System.out.println("disconcent!");
					}
					
				}
			
		}
		
	}

