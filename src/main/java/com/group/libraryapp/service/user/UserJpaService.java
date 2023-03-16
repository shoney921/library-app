package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserJpaRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Primary
@Service
public class UserJpaService implements UserService {

    private final UserJpaRepository userJpaRepository;

    public UserJpaService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public void saveUser(UserCreateRequest request) {
        User user = userJpaRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserResponse> getUsers() {
        List<User> users = userJpaRepository.findAll();
        return users.stream().map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request) {
        User user = userJpaRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);
        user.updateName(request.getName());
        userJpaRepository.save(user);
    }

    @Override
    public void deleteUser(String name) {
        User user = userJpaRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userJpaRepository.delete(user);
    }
}
