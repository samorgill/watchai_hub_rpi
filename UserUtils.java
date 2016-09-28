
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUtils {

	public static void saveUser (String username) {
		

		
		String usr = username;
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("WatchaiUser.txt"));

			out.write(usr);
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally
		{
		    try
		    {
		        if ( out != null)
		        out.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
		
		
	}
	
	public String getUser() throws IOException{
		String line;
		BufferedReader in;
		String username = null;
		User user = new User("");
		
		try {
			in = new BufferedReader(new FileReader("WatchaiUser.txt"));
			line = in.readLine();
			
			while(line != null){
			
				username = line;
				user.setUserName(username);
				line = in.readLine();
				
			}
		
			//System.out.println(line);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return username;
		
	}

	
	
}
