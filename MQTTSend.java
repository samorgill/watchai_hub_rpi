
import java.io.IOException;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/*
* @author Samuel Orgill 15118305
* NW5 Smartwatch Control of Environment
* September 2016
*
* Stand alone class for send MQTT message on local network
*/

public class MQTTSend {


	public static void send(String cTemp){
		 UserUtils uu = new UserUtils();

		  String username = null;
		try {
			username = uu.getUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("MQTT un: " + username);

		    String topic        = username + "/Temperature";
		    String content      = cTemp;
		    int qos             = 1;
<<<<<<< HEAD
		//    String broker       = "tcp://192.168.0.30:1883";
		String broker       = "tcp://m21.cloudmqtt.com:17781";
		    //MQTT client id to use for the device. "" will generate a client id automatically
		    String clientId     = "SendPi";
    MemoryPersistence persistence = new MemoryPersistence();
=======
		    String broker       = "tcp://192.168.0.30:1883";
	    	String clientId     = "SendPi";
    		MemoryPersistence persistence = new MemoryPersistence();
>>>>>>> eb0a891582d1a652217ad5912a36477e8bf80735

    		try {
        MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(false);
  connOpts.setUserName("xcihlzki");
	           connOpts.setPassword(new char[]{'7', 'w', 'p', 'h', '1', 'k', 'J', 'E', 'R', '7', 'X', 'h'});
        System.out.println("Connecting to broker: "+broker);
        sampleClient.connect(connOpts);
        System.out.println("Connected");
        System.out.println("Publishing message: "+content);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        sampleClient.publish(topic, message);
        System.out.println("Message published");
        //sampleClient.disconnect();


       // System.out.println("Disconnected");
       // System.exit(0);
    } catch(MqttException me) {
        System.out.println("reason "+me.getReasonCode());
        System.out.println("msg "+me.getMessage());
        System.out.println("loc "+me.getLocalizedMessage());
        System.out.println("cause "+me.getCause());
        System.out.println("excep "+me);
        me.printStackTrace();
    }
}

}
