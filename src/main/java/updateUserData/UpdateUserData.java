package updateUserData;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateUserData {
    private String name;
    private String job;
}
