package ttakkeun.ttakkeun_server.dto;

import lombok.Getter;

public class PetProfileRequestDTO {

    @Getter
    public static class AddDTO {
        String name;
        String type;
        String variety;
        String birth;
        Boolean neutralization;
    }
}
