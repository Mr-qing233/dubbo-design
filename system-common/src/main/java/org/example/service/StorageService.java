package org.example.service;

import org.example.entity.Storage;
import org.example.vo.ResultJson;

import java.util.List;

public interface StorageService {
    ResultJson<Boolean> addStorage(String uid, String bid, Integer count);
    ResultJson<Boolean> newStorage(String uid, String bid, Integer count);

    ResultJson<List<Storage>> showAll();
}
