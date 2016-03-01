Ejemplo simple de como crear referencias hacia actores y como es el envio de mensajes entre ellos

La clase AkkaSampleMain, inicia el ActorSystem con las propiedades sample.conf, que es el encargado de crear dos actores SampleActor y SampleActorLambda, ambos hacen lo mismo pero uno esta implementado con soporte para Java 8.

Luego, se envie indefinidamente un mensaje, que consiste en un número aleatorio, a cada uno ellos. A su vez los dos actores crean referencias a otro actor, LogActor, que simplementa logea los mensajes que le envían los actores

Para iniciar el ejemplo 

java -jar AkkaSample-1.0-SNAPSHOT.jar

Luego por la consola se mostrara cada 1 segundo(valor configurado en las properties) algo asi

[INFO] [03/01/2016 15:10:46.583] [akkaSystem-akka.actor.default-dispatcher-3] [akka://akkaSystem/user/sampleActorLambda/$a] Mensaje DoubleMsg=0.3292053163902354 desde akka://akkaSystem/user/sampleActorLambda
[INFO] [03/01/2016 15:10:46.583] [akkaSystem-akka.actor.default-dispatcher-7] [akka://akkaSystem/user/sampleActor/$a] Mensaje DoubleMsg=0.12450741255353848 desde akka://akkaSystem/user/sampleActor
[INFO] [03/01/2016 15:10:47.575] [akkaSystem-akka.actor.default-dispatcher-7] [akka://akkaSystem/user/sampleActor/$a] Mensaje DoubleMsg=0.46215112103272915 desde akka://akkaSystem/user/sampleActor
