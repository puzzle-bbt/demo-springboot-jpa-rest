package ch.puzzle.demo;

import ch.puzzle.demo.model.database.results.PercentResult;
import ch.puzzle.demo.model.dto.result.PercentResultDto;
import ch.puzzle.demo.service.result.PercentResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.auditing.DateTimeProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PercentResultServiceTests {

    private final PercentResultService percentResultService;

    private final PercentResultDto percentResultDTO = PercentResultDto.builder()
            .name("New DTO")
            .keyResult(1L)
            .description("description")
            .percentValue(100d)
            .build();

    @MockBean
    private DateTimeProvider dateTimeProvider;

    @SpyBean
    private AuditingHandler handler;

    @Autowired
    public PercentResultServiceTests(PercentResultService percentResultService) {
        this.percentResultService = percentResultService;
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        handler.setDateTimeProvider(dateTimeProvider);
    }

    @Test
    void buildPercentResult() {
        LocalDateTime createdDateTime = this.createLocalDateTime("2020-10-17 00:00");

        Mockito.when(dateTimeProvider.getNow()).thenReturn(Optional.of(createdDateTime));
        PercentResult percentResult = this.percentResultService.createPercentResult(this.percentResultDTO);

        assertEquals("New DTO", percentResult.getName());
        assertEquals("description", percentResult.getDescription());
        assertEquals(createdDateTime, percentResult.getCreatedOn());
        assertEquals(100d, percentResult.getPercentValue());
    }

    @Test
    void getAllPercentResults() {
        List<PercentResult> allPercentResults = this.percentResultService.getAllPercentResults();
        assertEquals(2, allPercentResults.size());
    }

    private LocalDateTime createLocalDateTime(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

}
