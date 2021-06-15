import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@AllArgsConstructor
public class AppController {

    @PostMapping(value = "/save", consumes = MULTIPART_FORM_DATA_VALUE)
    public Response save(ResourceRequest request) {
        /*
        do something
         */
        return new Response("success");
    }

    @Value
    private class Response {
        String status;
    }

    @Data
    private class ResourceRequest {
        private String field1;
        private String field2;
        private String field3;
        private Map<String, MultipartFile> files = new LinkedHashMap<>();
    }
}
