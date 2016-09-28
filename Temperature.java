
import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

/*
* @author Samuel Orgill 15118305
* NW5 Smartwatch Control of Environment
* September 2016
*
* A class to get the temperature
*/


public class Temperature {


	public void getTemp(InterfaceKitPhidget ifk) throws PhidgetException{
		double sensVal = ifk.getSensorValue(7);
		double tempCels = (sensVal * 0.2222) -61.111;
		String cTemp = Double.toString(tempCels).substring(0, 4);
		System.out.println("Temp " + tempCels);
		MQTTSend.send("Temperature: " + cTemp);
		ifk.close();

	}



}
