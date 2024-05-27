package lv.lvs.backend.model.communicationsInterfaces;
import java.time.LocalDateTime;

// idPA: 0,
// orderCreated: "2000-01-01T00:00",
// plannedDelivery: "2000-01-01T00:00",
// price: 0,
// size: "S",
// fragile: false,
// customerCode: "",
// idD: 0
import jakarta.validation.constraints.*;
import lombok.*;
import lv.lvs.backend.model.parcel.ParcelSize;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ParcelUpdate {
    
    @Min(1)
    private int idPA;

    @NonNull
    private LocalDateTime orderCreated;

    @NonNull
    private LocalDateTime plannedDelivery;

    @Min(0)
    private float price;

    @NonNull
    private ParcelSize size;

    private boolean fragile;
    
    @NonNull
    @Size(min = 15, max = 150)
    private String customerCode;

    @Min(1)
    private int idD;
}
