
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.phidgets.*;
import com.phidgets.event.*;

public class Lights {

	InterfaceKitPhidget led;

	/**
	 * @author Samuel Orgill 15118305
	 * NW5 Smartwatch Control of Environment
	 * September 2016
	 *
	 * A method for turning on the lights automatically if the light
	 * level falls below a set level.
	 * Light Sensor & LED's
	 * @param args
	 * @throws PhidgetException
	 */

	 public void turnOn(String[] args) throws PhidgetException {

	 InterfaceKitPhidget led = new InterfaceKitPhidget();
	 System.out.println(Phidget.getLibraryVersion());
	 attachListener(led);

	 //Set the change listener to monitor the light levels
	 led.addInputChangeListener(new InputChangeListener(){

		@Override
		public void inputChanged(InputChangeEvent arg0) {

		}

	 });
		led.addSensorChangeListener(new SensorChangeListener(){

			@Override
			public void sensorChanged(SensorChangeEvent arg0) {

				int sensVal = arg0.getValue();

				System.out.println("Arg " + arg0.getValue());

				//If the light levels fall below 30, the lights turn on
				if(sensVal < 30){
					try {
						turnOnWhite(led);
						turnOnRed(led);
						turnOnGreen(led);

					} catch (PhidgetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(sensVal > 50){
					try {

						turnOffWhite(led);
						turnOffRed(led);
						turnOffGreen(led);
						String str = "Light off";

					} catch (PhidgetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});

		 }

	 /**
	  * A method for flashing the red emergency light
	  * @throws PhidgetException
	  * @throws InterruptedException
	  */

  	public void emergencyLight(InterfaceKitPhidget ifk) throws PhidgetException, InterruptedException{

  		attachListener(ifk);

  		for(int i = 0; i < 30; i++){
  		turnOnRed(ifk);
  		Thread.sleep(500);
  		turnOffRed(ifk);
  		Thread.sleep(500);
  		}

  	}

  	/**
  	 * A soothing mix of the lights
  	 * @throws PhidgetException
  	 * @throws InterruptedException
  	 */
  	public void soothingLights(InterfaceKitPhidget ifk) throws PhidgetException, InterruptedException{
  		
  		attachListener(ifk);
<<<<<<< HEAD
  		
  		for(int i = 0; i < 5; i++){
=======

  		for(int i = 0; i < 30; i++){
>>>>>>> eb0a891582d1a652217ad5912a36477e8bf80735
  	  		turnOnRed(ifk);
  	  		Thread.sleep(1000);
  	  		turnOnGreen(ifk);
  	  		Thread.sleep(1000);
  	  		turnOffRed(ifk);
	  		Thread.sleep(2000);
	  		turnOffGreen(ifk);
	  		turnOnRed(ifk);
	  		Thread.sleep(2000);
<<<<<<< HEAD
  	  		}


  		turnOffAll(ifk);
  		
=======
  	  		}

>>>>>>> eb0a891582d1a652217ad5912a36477e8bf80735
  	}

  	/**
  	 * A method for party lights
  	 * @throws PhidgetException
  	 * @throws InterruptedException
  	 */
<<<<<<< HEAD
  	
	public void partyLights(InterfaceKitPhidget ifk) throws PhidgetException, InterruptedException{
  	
=======

	public void partyLights() throws PhidgetException, InterruptedException{
  		InterfaceKitPhidget ifk = new InterfaceKitPhidget();
>>>>>>> eb0a891582d1a652217ad5912a36477e8bf80735
  		attachListener(ifk);
  		turnOffAll(ifk);
  		for(int i = 0; i < 1; i++){
  	  		turnOnRed(ifk);
  	  		turnOnGreen(ifk);
  	  		Thread.sleep(100);
  	  		turnOffGreen(ifk);
  	  		Thread.sleep(100);
  	  		turnOffRed(ifk);
  	  		Thread.sleep(200);
  	  		turnOffGreen(ifk);
	  		turnOnRed(ifk);
	  		Thread.sleep(100);
	  		turnOnGreen(ifk);
	  		Thread.sleep(400);
	  		turnOffGreen(ifk);
	  		turnOffRed(ifk);
	  		Thread.sleep(300);
	  		turnOnRed(ifk);
	  		Thread.sleep(200);
	  		turnOffRed(ifk);
	  		Thread.sleep(250);
	  		turnOnRed(ifk);
	  		turnOnGreen(ifk);
	  		Thread.sleep(200);
	  		turnOffRed(ifk);
	  		Thread.sleep(200);
	  		turnOffGreen(ifk);
	  		Thread.sleep(300);
	  		turnOnGreen(ifk);
	  		Thread.sleep(200);
	  		turnOffGreen(ifk);
	  		Thread.sleep(200);
	  		turnOnGreen(ifk);
	  		turnOnRed(ifk);
	  		Thread.sleep(200);
	  		turnOnGreen(ifk);
	  		Thread.sleep(300);
	  		turnOffRed(ifk);
	  		Thread.sleep(200);

  	  		}

  		turnOffAll(ifk);
  	}

  	/**
  	 * A method for setting the attachment listener
  	 * @param led
  	 * @throws PhidgetException
  	 */
  	public void attachListener(InterfaceKitPhidget ifk) throws PhidgetException{
  		ifk.addAttachListener(new AttachListener(){
  			public void attached(AttachEvent ae) {
  				System.out.println("attachment of " + ae);
  			}
  		});

  		ifk.addDetachListener(new DetachListener() {
  			public void detached(DetachEvent ae) {
  				System.out.println("detachment of " + ae);
  			}
  		});
  		ifk.addErrorListener(new ErrorListener() {
  			public void error(ErrorEvent ee) {
  				System.out.println("error event for " + ee);
  			}
  		});

  		ifk.openAny();
		ifk.waitForAttachment();


  	}

  	/**
  	 * A method to turn off the lights
  	 * @throws PhidgetException
  	 */

  	public void turnOffAll(InterfaceKitPhidget ifk) throws PhidgetException{
  		turnOffWhite(ifk);
  		turnOffRed(ifk);
  		turnOffGreen(ifk);
  	}

  	/**
  	 * A method for turning on all lights
  	 * @param led
  	 * @throws PhidgetException
  	 */

  	public void turnOnAll(InterfaceKitPhidget ifk) throws PhidgetException{
  		turnOnWhite(ifk);
  		turnOnRed(ifk);
  		turnOnGreen(ifk);
  	}

  	/**
  	 * A method for turning on the white light
  	 * @param led
  	 * @throws PhidgetException
  	 */
  	public void turnOnWhite(InterfaceKitPhidget ifk) throws PhidgetException{
  		ifk.setOutputState(0, true);
  	}

  	/**
  	 * Turn off the red light
  	 * @param led
  	 * @throws PhidgetException
  	 */
  	public void turnOffWhite(InterfaceKitPhidget ifk) throws PhidgetException{
  		ifk.setOutputState(0, false);
  	}

  	/**
  	 * Turn on the red light
  	 * @param led
  	 * @throws PhidgetException
  	 */
  	public void turnOnRed(InterfaceKitPhidget ifk) throws PhidgetException{
  		ifk.setOutputState(1, true);
  	}

  	/**
  	 * Turn off the red light
  	 * @param led
  	 * @throws PhidgetException
  	 */
  	public void turnOffRed(InterfaceKitPhidget ifk) throws PhidgetException{
  		ifk.setOutputState(1, false);
  	}

  	/**
  	 * Turn on the green light
  	 * @param led
  	 * @throws PhidgetException
  	 */
  	public void turnOnGreen(InterfaceKitPhidget ifk) throws PhidgetException{
  		ifk.setOutputState(2, true);
  	}

  	/**
  	 * Turn off the green light
  	 * @param led
  	 * @throws PhidgetException
  	 */
  	public void turnOffGreen(InterfaceKitPhidget ifk) throws PhidgetException{
  		ifk.setOutputState(2, false);
  	}

  	/**
  	 * Turn off all lights overloaded method
  	 * @throws PhidgetException
  	 */
	public void turnOffAll() throws PhidgetException {


	}
}
