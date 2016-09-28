
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONArray;
import org.json.JSONObject;

import com.phidgets.*;
import com.phidgets.event.*;


/**
 *
 * @author Samuel Orgill 15118305
 * NW5 Smartwatch Control of Home
 * September 2016
 * A controller class to run on Raspberry Pi
 *
 */

public class Controller {

  public static void main(String[] args) throws IOException, InterruptedException, PhidgetException {

	 //Gets all the things stored in the DB&  adds them to an arraylist
	  GetThings gt = new GetThings();
	  gt.getDB();

		// Starts MQTT broker/ client
    MQTT mqtt = new MQTT();
	  mqtt.startMQTT(args);


}



}
