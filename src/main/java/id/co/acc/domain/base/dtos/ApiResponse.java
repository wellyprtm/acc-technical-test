package id.co.acc.domain.base.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String OUT_STAT;
    private String OUT_MESS;
    private Object OUT_DATA;

    public static ApiResponse data(final Object data) {
        final ApiResponse apiResponse = new ApiResponse();
        apiResponse.setOUT_STAT("T");
        apiResponse.setOUT_MESS("Success");
        apiResponse.setOUT_DATA(data);
        return apiResponse;
    }
}
