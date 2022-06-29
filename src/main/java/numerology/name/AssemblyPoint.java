package numerology.name;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssemblyPoint {
    private String name;
    private Integer fullNumber;
    private Integer finalNumber;
}
