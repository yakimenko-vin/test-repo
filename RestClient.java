import lombok.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "SOME-SERVICE"
)
public interface RestClient {

    @PostMapping(value = "save")
    Response save(MultiValueMap<String, Resource> resources);

    @Value
    class Response {
        String status;
    }
}