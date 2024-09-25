package test.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {

    private Long id;
    private String name;
    private Long totalMessages;
    private List<GetUserAndMessageResponse> lisTo;

}
