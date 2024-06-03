package lv.lvs.backend.model.communicationsInterfaces;

import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MaintInsert {

    @Min(1)
    private int idCA;

    @Min(1)
    private int idM;

    @NonNull
    private LocalDateTime startDateTime;
}
