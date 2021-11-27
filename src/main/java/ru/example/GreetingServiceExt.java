package ru.example;

import io.grpc.stub.StreamObserver;
import ru.example.grpc.GreetingServiceGrpc;
import ru.example.grpc.GreetingServiceOuterClass;

public class GreetingServiceExt extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);

        //Билдим ответ
        GreetingServiceOuterClass.HelloResponse response =
                GreetingServiceOuterClass
                        .HelloResponse
                        .newBuilder()
                        .setGreeting("Hello from server, " + request.getName())
                        .build();

        //Отправка данных
        responseObserver.onNext(response);

        //Закончили отправку
        responseObserver.onCompleted();
    }
}
