package org.example.service;

import org.example.entity.Storage;

import java.util.List;

public interface StorageService {
    boolean addStorage(String uid, String bid, Integer count);
    boolean newStorage(String uid, String bid, Integer count);

    List<Storage> showAll();
}
