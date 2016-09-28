
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
* @author Samuel Orgill 15118305
* NW5 Smartwatch Control of Environment
* September 2016
*
* User utils
*/


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
<<<<<<< HEAD
		
		
=======

		System.out.println("Persisted username " + usr );

>>>>>>> eb0a891582d1a652217ad5912a36477e8bf80735
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
<<<<<<< HEAD
				
=======

				System.out.println("un = line: " + username);
>>>>>>> eb0a891582d1a652217ad5912a36477e8bf80735
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return username;

	}



}
