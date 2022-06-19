package numerology.name;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoAboutName {
    List<MagicName> magicNames;
    Integer fullNumber;
    Integer finalNumber;
}
