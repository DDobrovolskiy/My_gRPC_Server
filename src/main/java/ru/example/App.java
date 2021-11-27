package ru.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        System.out.println( "Hello World!" );
        Server server = ServerBuilder.forPort(8080).addService(new GreetingServiceExt()).build();

        server.start();
        System.out.println("Server start");

        server.awaitTermination();
    }
}
