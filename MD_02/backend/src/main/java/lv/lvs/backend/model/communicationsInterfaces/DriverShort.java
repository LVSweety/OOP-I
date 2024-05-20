package lv.lvs.backend.model.communicationsInterfaces;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DriverShort {

    @Min(0)
    private int id;

    @NotNull
    @Pattern(regexp = "[A-Z]{2}[0-9]{6}")
    private String licenseNo;

    public DriverShort(int id, String licenseNo) {
        setId(id);
        setLicenseNo(licenseNo);
    }
}
