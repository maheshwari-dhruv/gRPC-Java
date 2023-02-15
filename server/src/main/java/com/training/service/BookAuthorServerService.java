package com.training.service;

import com.training.Author;
import com.training.TempDB;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.training.BookAuthorServiceGrpc.BookAuthorServiceImplBase;

/**
 * @author Dhruv Maheshwari
 * @version $Id: BookAuthorServerServiceImpl.java, v 0.1 2023-02-16 12:28 AM Dhruv Maheshwari Exp $$
 */

@GrpcService
public class BookAuthorServerService extends BookAuthorServiceImplBase {

    @Override
    public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
        TempDB.getAuthorsFromTempDb()
                .stream()
                .filter(author -> author.getAuthorId() == request.getAuthorId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}
