package ttakkeun.ttakkeun_server.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ttakkeun.ttakkeun_server.apiPayLoad.ApiResponse;
import ttakkeun.ttakkeun_server.dto.todo.CalendarResponseDto;
import ttakkeun.ttakkeun_server.service.CalendarService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    @Operation(summary = "캘린더 조회 API")
    @GetMapping("/{year}/{month}/{date}")
    public ApiResponse<CalendarResponseDto> getCalendarData(
            // @RequestHeader("Authorization") String accessToken,
            @RequestParam Long petId,
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int date) {
        CalendarResponseDto result = calendarService.getCalendarData(petId, year, month, date);
        return ApiResponse.onSuccess(result);
    }
}
