package app.freecharge.pages;

import org.apache.log4j.Logger;

import app.freecharge.androiddriver.DriverInitialization;
import io.appium.java_client.NetworkConnectionSetting;


public class NetworkConnectionsPage extends DriverInitialization

{
	public NetworkConnectionsPage(){
		super();
	}

	Logger logger=Logger.getLogger(NetworkConnectionsPage.class); 
	//Script for enable and disable the network connections through appium
	@Override
	public void networkConnections() throws InterruptedException {
		try{
			// Identify Network status
			NetworkConnectionSetting networkConnection = driver.getNetworkConnection();
			Boolean status = networkConnection.wifiEnabled();
			System.out.println(status);

			// Turn off the WI-fI connection
			if (status == true)
			{
				enableInterNet(false);
				Thread.sleep(2000);
				logger.info("Network connection Disabled");
			}
			else if (status == false){
				// Turn On the WI-FI connection
				enableInterNet(true);
				Thread.sleep(2000);
				logger.info("Network connection Enabled");
			}
		}catch(Exception e){

		}

	}

	// Setting the network connections
	@Override
	public void enableInterNet(boolean isEnabled) {
		NetworkConnectionSetting networkConnection = new NetworkConnectionSetting(false, isEnabled, false);
		driver.setNetworkConnection(networkConnection);

	}


}
