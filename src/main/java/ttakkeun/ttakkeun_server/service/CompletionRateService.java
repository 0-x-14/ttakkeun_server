package ttakkeun.ttakkeun_server.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttakkeun.ttakkeun_server.dto.todo.CompletionRateDto;
import ttakkeun.ttakkeun_server.entity.Pet;
import ttakkeun.ttakkeun_server.entity.enums.Category;
import ttakkeun.ttakkeun_server.entity.enums.TodoStatus;
import ttakkeun.ttakkeun_server.repository.PetRepository;
import ttakkeun.ttakkeun_server.repository.TodoRepository;

@Service
public class CompletionRateService {

    private final TodoRepository todoRepository;
    private final PetRepository petRepository;

    public CompletionRateService(TodoRepository todoRepository, PetRepository petRepository) {
        this.todoRepository = todoRepository;
        this.petRepository = petRepository;
    }

    @Transactional(readOnly = true)
    public CompletionRateDto getCompletionRate(Long petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Pet Id 입니다"));

        int earTotal = (int) todoRepository.countByTodoCategoryAndPet(Category.EAR, pet);
        int hairTotal = (int) todoRepository.countByTodoCategoryAndPet(Category.HAIR, pet);
        int clawTotal = (int) todoRepository.countByTodoCategoryAndPet(Category.CLAW, pet);
        int eyeTotal = (int) todoRepository.countByTodoCategoryAndPet(Category.EYE, pet);
        int teethTotal = (int) todoRepository.countByTodoCategoryAndPet(Category.TEETH, pet);

        int earCompleted = (int) todoRepository.countByTodoCategoryAndPetAndTodoStatus(Category.EAR, pet, TodoStatus.DONE);
        int hairCompleted = (int) todoRepository.countByTodoCategoryAndPetAndTodoStatus(Category.HAIR, pet, TodoStatus.DONE);
        int clawCompleted = (int) todoRepository.countByTodoCategoryAndPetAndTodoStatus(Category.CLAW, pet, TodoStatus.DONE);
        int eyeCompleted = (int) todoRepository.countByTodoCategoryAndPetAndTodoStatus(Category.EYE, pet, TodoStatus.DONE);
        int teethCompleted = (int) todoRepository.countByTodoCategoryAndPetAndTodoStatus(Category.TEETH, pet, TodoStatus.DONE);

        return new CompletionRateDto(
                earTotal, earCompleted,
                hairTotal, hairCompleted,
                clawTotal, clawCompleted,
                eyeTotal, eyeCompleted,
                teethTotal, teethCompleted
        );
    }
}
