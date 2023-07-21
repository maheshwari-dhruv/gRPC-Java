package com.training.service;

import com.google.protobuf.Descriptors;

import java.util.Map;

/**
 * @author Dhruv Maheshwari
 * @version $Id: BookAuthorService.java, v 0.1 2023-02-16 12:49 AM Dhruv Maheshwari Exp $$
 */
public interface BookAuthorService {
    Map<Descriptors.FieldDescriptor, Object> getAuthor(String authorId);
}
