#include <Wire.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BMP280.h>
#include <dht11.h>
#define DHTPIN 4
#define DHTTYPE DHT11
#include <SoftwareSerial.h>

dht11 DHT11;
SoftwareSerial HC05(2, 3); // RX, TX
Adafruit_BMP280 bmp; // I2C interface

void setup() {
  Serial.begin(38400);     // Serial Monitor baud rate
  HC05.begin(9600);       // HC-05 baud rate
  Serial.println("BT ready!");
  
  if (!bmp.begin()) {
    Serial.println("Could not find a valid BMP280 sensor, check wiring!");
    while (1);
  }
}

void loop() {
  int chk = DHT11.read(DHTPIN);
      

char buffer[150];
    char tempStr[10], humStr[10], temp2Str[10], pressureStr[10];


    // Convert float values to strings
    dtostrf(DHT11.humidity, 6, 2, humStr);
    dtostrf(DHT11.temperature, 6, 2, tempStr);
    dtostrf(bmp.readTemperature(), 6, 2, temp2Str);
    dtostrf(bmp.readPressure() / 100.0, 6, 2, pressureStr);

    // Format the output string
    sprintf(buffer, "<DATA>Humidity: %s, Temperature1: %s, Temperature2: %s, Pressure: %s Pa</DATA>", 
            humStr, tempStr, temp2Str, pressureStr);

    // Send the formatted string over Serial and HC05
    Serial.println(buffer);
    HC05.println(buffer);


  delay(10000);
}
