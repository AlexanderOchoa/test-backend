package test.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveMessageRequest {

    private Long userIdFrom;
    private Long userIdTo;
    private String message;

}
