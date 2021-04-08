import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Vacancy {
    String name;
    Salary salary;
    @SerializedName("has_test")
    boolean hasTest;
}
