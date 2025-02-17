package ttakkeun.ttakkeun_server.dto.tip;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ttakkeun.ttakkeun_server.entity.enums.Category;

@Getter
@Setter
@NoArgsConstructor
public class TipCreateRequestDTO {
    private String title;
    private String content;
    private Category category;

    public TipCreateRequestDTO(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}