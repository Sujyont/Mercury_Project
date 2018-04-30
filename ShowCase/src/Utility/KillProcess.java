package Utility;

import org.openqa.selenium.os.WindowsUtils;

public class KillProcess {

	public static void main(String[] args) {
		
		//WindowsUtils.tryToKillByName("chrome.exe");
		//WindowsUtils.tryToKillByName("excel.exe");
		
		WindowsUtils.tryToKillByName("IEDriverServer.exe");
		WindowsUtils.tryToKillByName("iexplore.exe");
	}

}
