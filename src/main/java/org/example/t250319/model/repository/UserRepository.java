package org.example.t250319.model.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.t250319.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository implements SupabaseRepository<UserDTO> {
    final private String tableName = "USER";

    public void save(UserDTO userDTO) throws Exception {
        save(userDTO, tableName);
    }

    public List<UserDTO> findAll() throws Exception {
        String responseJson = findAll(tableName);
        return objectMapper.readValue(responseJson, new TypeReference<>() {});
    }

    public UserDTO findById(String userId) throws Exception {
        String responseJson = findById(userId,
                tableName, "user_id");
        List<UserDTO> userList = objectMapper.readValue(responseJson, new TypeReference<>(){});
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }
}