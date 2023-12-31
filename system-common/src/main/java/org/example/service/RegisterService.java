package org.example.service;

import org.example.entity.User;
import org.example.vo.ResultJson;

public interface RegisterService {
    ResultJson<Boolean> existUser(String uname);
    ResultJson<Boolean> registerUser(User user);
}
