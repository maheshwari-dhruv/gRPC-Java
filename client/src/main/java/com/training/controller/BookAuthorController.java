package com.training.controller;

import com.google.protobuf.Descriptors;
import com.training.service.BookAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Dhruv Maheshwari
 * @version $Id: BookAuthorController.java, v 0.1 2023-02-16 12:49 AM Dhruv Maheshwari Exp $$
 */

@RestController
@AllArgsConstructor
@RequestMapping("/grpc-java")
public class BookAuthorController {

    @Autowired
    BookAuthorService bookAuthorService;

    @GetMapping("/author/{authorId}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String authorId) {
        return bookAuthorService.getAuthor(authorId);
    }
}
