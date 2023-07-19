package com.training.service.impl;

import com.google.protobuf.Descriptors;
import com.training.Author;
import com.training.BookAuthorServiceGrpc.BookAuthorServiceBlockingStub;
import com.training.service.BookAuthorService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Dhruv Maheshwari
 * @version $Id: BookAuthorServiceImpl.java, v 0.1 2023-02-16 12:49 AM Dhruv Maheshwari Exp $$
 */

@Service
public class BookAuthorServiceImpl implements BookAuthorService {

    @GrpcClient("grpc-training-service")
    BookAuthorServiceBlockingStub syncClient;

    @Override
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(String authorId) {
        Author authorReq = Author.newBuilder().setAuthorId(Integer.parseInt(authorId)).build();
        Author authorRes = syncClient.getAuthor(authorReq);

        return authorRes.getAllFields();
    }
}
