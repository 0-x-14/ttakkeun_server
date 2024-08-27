package ttakkeun.ttakkeun_server.apiPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import ttakkeun.ttakkeun_server.apiPayLoad.code.BaseCode;
import ttakkeun.ttakkeun_server.apiPayLoad.code.BaseErrorCode;
import ttakkeun.ttakkeun_server.apiPayLoad.code.status.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;

    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)  //result값이 null이 아닌 경우에만 포함
    private T result;

    // 성공한 경우
    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }

    // 응답이 필요없을때
    public static ApiResponse<Void> onSuccess() {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), null);
    }

    // 실패한 경우
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(false, code, message, data);
    }

    public static <T> ApiResponse<T> ofFailure(BaseErrorCode code, T result) {
        return new ApiResponse<>(false, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);
    }
}
