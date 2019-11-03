<h3>Tow To:</h3>

<ul>
<li>By any of the convenient ways create the
 Android emulator or connect Android device to the your PC </li>
 <li>Install the "WiFi Connect" application to the device</li>
 <li>Download/Clone this project and unpack it to the folder you like</li>
 <li>Open POM.XML file and fill the next value with the actual data from your setup
 <br>
 &#60;android.device.name>Pixel 2 API 26&#60;/android.device.name>
 <br>
 &#60;android.udid>emulator-5554&#60;/android.udid>
 <br>
 &#60;android.platform.ame>Android&#60;/android.platform.ame>
 <br>
 &#60;android.platform.version>8.0&#60;/android.platform.version>
 </li>
 <li>Open console window in the folder you have previously unpack project</li>
 <li>Execut "mvn test -Pdev"</li>
</ul>