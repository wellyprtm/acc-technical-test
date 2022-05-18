package id.co.acc.domain.base.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    @JsonProperty(value = "OUT_STAT")
    private String outStat;
    @JsonProperty(value = "OUT_MESS")
    private String outMess;
    @JsonProperty(value = "OUT_DATA")
    private Object outData;

    public static ApiResponse data(final Object data) {
        final ApiResponse apiResponse = new ApiResponse();
        apiResponse.setOutStat("T");
        apiResponse.setOutMess("Success");
        apiResponse.setOutData(data);
        return apiResponse;
    }

    public static ApiResponse error(String status, String message) {
        return new ApiResponse(status, message, new ArrayList<>());
    }
}
