package ttakkeun.ttakkeun_server.dto.diagnose;

import java.util.List;

public record PostDiagnoseResponseDTO(Long result_id, Integer score, String result_detail, String result_care, List<String> products) {
}
