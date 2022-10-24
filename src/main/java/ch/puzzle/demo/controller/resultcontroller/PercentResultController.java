package ch.puzzle.demo.controller.resultcontroller;

import ch.puzzle.demo.model.database.results.PercentResult;
import ch.puzzle.demo.model.dto.result.PercentResultDto;
import ch.puzzle.demo.service.result.PercentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static ch.puzzle.demo.model.helper.UrlLibrary.*;

@RestController(BASIC_URL)
public class PercentResultController {
    private final PercentResultService percentResultService;

    @Autowired
    public PercentResultController(PercentResultService percentResultService) {
        this.percentResultService = percentResultService;
    }

    @GetMapping(GET_PERCENTRESULTS)
    @ResponseBody
    public List<PercentResult> getAllPercentResults() {
        return this.percentResultService.getAllPercentResults();
    }

    @PostMapping(POST_PERCENTRESULTS)
    @ResponseBody
    public PercentResult createPercentResult(@Valid PercentResultDto percentResultDto) {
        return this.percentResultService.createPercentResult(percentResultDto);
    }
}
