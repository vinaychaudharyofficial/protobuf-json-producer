# protobuf-json-producer
This Producer application which is based on SpringBoot, expose two APIs i.e protobuf and json for performance testing between them(Protobuf vs Json). Both the APIs returns the 20k records of employee object having 5 properties in it.

Reference Doc: 
https://developers.google.com/protocol-buffers/docs/overview
https://developers.google.com/protocol-buffers/docs/javatutorial#defining-your-protocol-format

Below results are performed using JMeter tool in local enviroment with Number of Threads: 5 and LoopCount: 10. Here we can clearly see the difference of Average Latency for both APis ie. Protobuf: 47ms and JSonAPI: 69ms

Protobuf API Result
![alt text](https://github.com/vinaychaudharyofficial/protobuf-json-producer/blob/be6eb2aeaa2e7ea42edd4242a02b23e2a7229753/src/main/resources/static/JMeter_Protobuf.png)

Json API Result
![alt text](https://github.com/vinaychaudharyofficial/protobuf-json-producer/blob/be6eb2aeaa2e7ea42edd4242a02b23e2a7229753/src/main/resources/static/JMeterJson.png)
