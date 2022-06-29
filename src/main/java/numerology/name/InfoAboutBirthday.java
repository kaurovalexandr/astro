package numerology.name;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoAboutBirthday {
    private Map<Integer, Integer> table;
    private Map<String, Integer> quality;
    private List<AssemblyPoint> assemblyPoint;
}
