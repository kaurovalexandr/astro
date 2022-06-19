package numerology.name;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MagicName {
    String name;
    Integer fullNumber;
    Integer finalNumber;
    List<Letter> letters;
}
