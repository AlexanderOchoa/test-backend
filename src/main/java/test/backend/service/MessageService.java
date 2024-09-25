package test.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import test.backend.dto.*;
import test.backend.entity.Message;
import test.backend.repository.MessageRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(MessageService.class);

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public GenericResponse save(SaveMessageRequest request) {
        GenericResponse response = new GenericResponse();

        try {
            if (Objects.equals(request.getUserIdTo(), request.getUserIdFrom())) {
                response.setMessage("userIdTo and userIdFrom cant be the same!");
                return response;
            }

            Message message = new Message();
            message.setUserIdFrom(request.getUserIdFrom());
            message.setUserIdTo(request.getUserIdTo());
            message.setMessage(request.getMessage());
            message.setMessageDate(new Date());

            messageRepository.save(message);

            response.setData(new SaveMessageResponse(message.getId()));
            response.setMessage("Message saved!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.setMessage("Error in the process!");
        }

        return response;
    }

    public GenericResponse get(Long userId, Long page) {
        GenericResponse response = new GenericResponse();

        try {
            Pageable pageable = PageRequest.of(page.intValue(), 10);

            List<Message> messages = messageRepository.findByUser(userId, pageable);

            List<GetMessageResponse> getMessageResponses = messages.stream().map(m -> {
                GetMessageResponse getMessageResponse = new GetMessageResponse();
                getMessageResponse.setMessage(m.getMessage());
                return getMessageResponse;
            }).collect(Collectors.toList());

            response.setData(getMessageResponses);
            response.setMessage("List success!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.setMessage("Error in the process!");
        }

        return response;
    }
}
