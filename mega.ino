#include <Wire.h> //Incluímos la librería wire
#include <Servo.h> // Incluímos la librería servo
// Declaración de los pines a utilizar en la placa Arduino/Genuino Mega or Mega 2560
#define PIN_SERVO 2 // Pin digital 2 para el Servo Motor
#define PIN_LED_RED 8 // Pin PWM 8 para conectar el led RED del RGB
#define PIN_LED_GREEN 7 // Pin PWM 7 para conectar el led GREEN del RGB
#define PIN_LED_BLUE 6 // Pin PWM 6 para conectar el led BLUE del RGB
#define PIN_ULTRASONIDO_TRIG 23 // Pin digital 23 para conectar el TRIG del sensor ultrasonido
#define PIN_ULTRASONIDO_ECHO 24 // Pin digital 24 para conectar el ECHO del sensor ultrasonido
#define PIN_BUZZER 50 // Pin digital 50 para conectar el BUZZER
#define PIN_FSR 0 // Definimos el pin para la resistencia sensible a la fuerza
#define PIN_MANUAL 37 // Definimos el pin para manipular el circuito manualmente

Servo servoMotor; // Creamos una instancia de la estructura Servo

long distancia, porcionServida, porcionSolicitada, fsrReading, aux; //Definimos como long algunas variables
bool servir; // Definimos como bool la variable servir
const float FACTORCM = 58.0; // Definimos una constante
long z = 0; // Definimos una variable
long x; // Definimos una variable

void setup() {

  pinMode(PIN_ULTRASONIDO_TRIG, OUTPUT); //Configuración del pin digital 23 como salida
  pinMode(PIN_ULTRASONIDO_ECHO, INPUT); //Configuración del pin digital 23 como salida
  pinMode(PIN_LED_RED, OUTPUT); //Configuración del pin digital 23 como salida
  pinMode(PIN_LED_GREEN, OUTPUT); //Configuración del pin digital 23 como salida
  pinMode(PIN_LED_BLUE, OUTPUT); //Configuración del pin digital 23 como salida
  pinMode(PIN_MANUAL, INPUT); //Configuración del pin digital 23 como salida

  servoMotor.attach(PIN_SERVO); // definimos el pin del servo
  servoMotor.write(0); // Escribimos en el 
  digitalWrite(PIN_ULTRASONIDO_TRIG, LOW); // Escribimos en el TRIG un LOW
  digitalWrite(PIN_ULTRASONIDO_ECHO, LOW); // Escribimos en el ECHO un LOW

  Wire.begin(4); // Definimos a que placa irá la transmisión
  Wire.onReceive(receiveEvent); // Recibimos un evento de otra placa

  aux = 0; // le damos el valor de 0 a la placa 

  Serial.begin(9600); // iniciamos el serial

}

void loop() {

  digitalWrite(PIN_ULTRASONIDO_TRIG, HIGH); // Encendemos el TRIG
  delayMicroseconds(10); //Creamos un delay 
  digitalWrite(PIN_ULTRASONIDO_TRIG, LOW); // Apagamos el TRIG
  distancia = pulseIn(PIN_ULTRASONIDO_ECHO, HIGH) / FACTORCM; // Recibimos el pulso para la distancia 

  Serial.println(100 - (distancia * 100 / 22)); // Imprimimos la conversión que nos da la distancia real

  if (z == aux) { // Hacemos una condición  para comparar porcion solicitada con aux
      servir = false; // Si se cumple la condición servir se vuelve falso
  } else { // si la condición no se cumple
      servir = true;   // Servir se hace verdadero
  }
     
  porcionServida = 0; // la porción servida inicia en 0
  porcionSolicitada = z * 10000 / 255; // Hacemos una conversión para el valor real en gramos de la porcion

  while ((porcionServida < z && servir) || (digitalRead(PIN_MANUAL) == HIGH)) { // acá entramos a un ciclo que solo se entra dependiendo de si la porcionServida es menor a la solicidada y si servir se cumple o si pin manual se activa

    if (z >= 0 && z < 100) { // Si la porción solicitada eestá en ese rango

      analogWrite(PIN_LED_RED, 0);
      analogWrite(PIN_LED_GREEN, 0);
      analogWrite(PIN_LED_BLUE, 255); // se prende solo el LED AZUL

    } else if (z >= 100 && z < 200) { // si está en este rango

      analogWrite(PIN_LED_RED, 0);
      analogWrite(PIN_LED_GREEN, 255); // Se prende el LED VERDE
      analogWrite(PIN_LED_BLUE, 0);

    } else { // Si no está en ninguno

      analogWrite(PIN_LED_RED, 255); // Se prende el LED ROJO
      analogWrite(PIN_LED_GREEN, 0);
      analogWrite(PIN_LED_BLUE, 0);

    }

    servoMotor.write(90); // Se le escribe al servo la cantidad de grados a girar

    tone(PIN_BUZZER, 1); // Se le da una frecuencia al buzzer

    fsrReading = analogRead(PIN_FSR); //  Se lee el valor de la FSR 

    porcionServida = (1023 / (fsrReading * 0.01)); // se hace una conversión para el valor real de la porción servida

    porcionServida -= 100; // se le resta un valor a porción servida para ser mas exactos

  }

  aux = z; // auxiliar se convierte en la porción solicitada

  noTone(PIN_BUZZER); // Se le quita el tono al buzzer

  analogWrite(PIN_LED_RED, 0);  // se apaga el led rojo
  analogWrite(PIN_LED_GREEN, 0); // se apaga el led verde
  analogWrite(PIN_LED_BLUE, 0);// se apaga el led azul

  servoMotor.write(0); // se le dice al servo que baje a 0 grados
 
  delay(5000); // se hace un delay que detenga la ejecución por un tiempo

}

void receiveEvent(int howMany) { // se crea un nuevo metodo

  while (Wire.available()) { // se crea un ciclo con la condición de que el wire esté activo

    z = Wire.read(); // se le da a z el valor que se recibe de la otra placa 

  }

}
