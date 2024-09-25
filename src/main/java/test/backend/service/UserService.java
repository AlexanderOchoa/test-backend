package test.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import test.backend.dto.*;
import test.backend.entity.MessageAndUser;
import test.backend.entity.User;
import test.backend.repository.MessageRepository;
import test.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final MessageRepository messageRepository;

    public UserService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public GenericResponse save(SaveUserRequest request) {
        GenericResponse response = new GenericResponse();

        try {
            Optional<User> userFound = userRepository.findByName(request.getName());

            if (userFound.isEmpty()) {
                User user = new User();
                user.setName(request.getName());
                userRepository.save(user);

                response.setData(new SaveUserResponse(user.getId()));
                response.setMessage("User saved!");
            } else {
                response.setMessage("User exist!");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.setMessage("Error in the process!");
        }

        return response;
    }

    public GenericResponse get(Long userId) {
        GenericResponse response = new GenericResponse();

        try {
            Optional<User> userFound = userRepository.findById(userId);

            if (userFound.isPresent()) {
                GetUserResponse getUserResponse = new GetUserResponse();
                getUserResponse.setId(userFound.get().getId());
                getUserResponse.setName(userFound.get().getName());

                Long totalMessages = messageRepository.countByUser(userId);

                getUserResponse.setTotalMessages(totalMessages);

                List<MessageAndUser> messageAndUsers = messageRepository.findByUserTo(userId);

                List<GetUserAndMessageResponse> getUserAndMessageResponses = messageAndUsers.stream().map(mu -> {
                    GetUserAndMessageResponse getUserAndMessageResponse = new GetUserAndMessageResponse();
                    getUserAndMessageResponse.setUser(mu.getUser());
                    getUserAndMessageResponse.setTotalMessage(mu.getTotal());
                    return getUserAndMessageResponse;
                }).collect(Collectors.toList());

                getUserResponse.setLisTo(getUserAndMessageResponses);

                response.setData(getUserResponse);
                response.setMessage("Get success!");
            } else {
                response.setMessage("User not exist!");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.setMessage("Error in the process!");
        }

        return response;
    }
}
