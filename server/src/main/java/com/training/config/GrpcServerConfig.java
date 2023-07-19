package com.training.config;

import com.training.service.BookAuthorServerService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Dhruv Maheshwari
 * @version $Id: GrpcServerConfig.java, v 0.1 2023-02-16 01:26 AM Dhruv Maheshwari Exp $$
 */

@Configuration
public class GrpcServerConfig {

    @Bean
    public Server grpcServer() throws IOException {
        ServerBuilder<?> builder = ServerBuilder.forPort(9000)
                .addService(new BookAuthorServerService()); // add your gRPC service implementation here
        return builder.build().start();
    }
}

