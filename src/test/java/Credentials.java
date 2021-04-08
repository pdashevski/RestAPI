import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Credentials {
    String login;
    String password;
}
