package updateUserData;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class PatchUserData {

        private String name;
        private String job;
}
