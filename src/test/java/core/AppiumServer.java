package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {

    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    public void startServer() {
        //Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        //added by myself:
        builder.usingDriverExecutable(new File("C:/node/node.exe"));
        builder.withAppiumJS(new File("C:/Users/Dima/AppData/Roaming/npm/node_modules/appium/lib/appium.js"));


        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void stopServer() {
        service.stop();
    }

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void main(String[] args) {
        AppiumServer appiumServer = new AppiumServer();

        int port = 4723;
        if (!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer();
            appiumServer.stopServer();
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }
    }
}
