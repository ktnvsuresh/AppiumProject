package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;
import io.appium.java_client.NetworkConnectionSetting;


public class NetworkConnectionsPage extends DriverInitialization

{
	public NetworkConnectionsPage(){
		super();
	}

	
	//Script for enable and disable the network connections through appium
	
	public void networkConnections() throws InterruptedException {
		try{
			// Identify Network status
			NetworkConnectionSetting networkConnection = driver.getNetworkConnection();
			Boolean status = networkConnection.wifiEnabled();
			System.out.println(status);

			// Turn off the WI-fI connection
			if (!equals(status))
			{
				enableInterNet(false);
				Thread.sleep(2000);
				System.out.println("Network connection Disabled");
			}
			// Turn On the WI-FI connection
			enableInterNet(true);
			Thread.sleep(2000);
			System.out.println("Network connection Enabled");
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
