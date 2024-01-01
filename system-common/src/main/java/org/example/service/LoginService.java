package org.example.service;

import org.example.entity.User;
import org.example.vo.ResultJson;

public interface LoginService {
    ResultJson<User> loginUser(String uid, String password);
}
