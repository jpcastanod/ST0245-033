#include <Wire.h> // Incluimos librerias Wire
#include <UbidotsArduino.h> // Incluimos librerias Ubidots

#define ID_PORCION "5a0dbd9fc03f974b9bc539ca" // definimos los pines con la ID en UBIDOTS
#define ID_COLOR "5a0dbd9fc03f974b9bc539ca" // definimos los pines con la ID en UBIDOTS
#define ID_CUIDO "5a0dbd3cc03f974a42c2342a" // definimos los pines con la ID en UBIDOTS

#define TOKEN "A1E-dFdjpcOum80fl2E0sBD0SejdTEUlDv" // definimos el token otrogado en UBIDOTS

char ssid[] = "AndroidAP";  // Le damos una variable al usuario del wi-fi
char pass[] = "a11223344"; // Le damos una variable a la contraseña del wi-fi
    
long porcionSolicitada, color; // Definimos porcionSolicitada y color como long 

int status = WL_IDLE_STATUS; // Definimos como int el estado de la conexión del wi-fi

Ubidots client(TOKEN); 

void setup() {  // Iniciamos el void setup

  Wire.begin(); //  Iniciamos el wire
  
  Serial.begin(9600); // Iniciamos el serial
   
  while (status != WL_CONNECTED) //  Empezamos un ciclo que depende de la conexión al wi-fi 
  {
    Serial.print("Intentando conectar a la red WiFi: "); // Imprimimos un mensaje
    Serial.println(ssid); // Imprimimos el usuario del wi-fi
    status = WiFi.begin(ssid, pass); // Hacemos una conexión a una red wi-fi
    delay(2000); // Creamos un delay que detenga el proceso por un tiempo
    
  }
 
  delay(5000); // Creamos un delay que detenga el proceso por un tiempo
  
}

void loop() { // iniciamos el void loop
  
  float *responseArray; // Definimos un apuntador a una variable

  responseArray = client.getValue(ID_PORCION); // Obtenemos el valor del servidor y lo asignamos
  
  if (responseArray[0] == 1) { // hacemos una condición del valor obtenido
    porcionSolicitada = responseArray[1]; //le asignamos el valor a otra variable
  }

  Wire.beginTransmission(4); // comenzamos la transmisión de datos a las placas
  Wire.write(porcionSolicitada); // escribir en la otra placa el dato
  Wire.endTransmission();  // Finalizamos la transmisión
  
  delay(2000); // Creamos un delay que detenga el proceso por un tiempo
  
}
