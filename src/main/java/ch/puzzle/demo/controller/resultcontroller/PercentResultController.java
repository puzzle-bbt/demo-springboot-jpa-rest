package ch.puzzle.demo.controller.resultcontroller;

import ch.puzzle.demo.model.database.results.PercentResult;
import ch.puzzle.demo.model.dto.result.PercentResultDto;
import ch.puzzle.demo.service.result.PercentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static ch.puzzle.demo.model.helper.UrlLibrary.*;

@RestController
@RequestMapping(BASIC_URL)
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

    @PostMapping(value = POST_PERCENTRESULT)
    @ResponseBody
    public PercentResult createPercentResult(@Valid PercentResultDto percentResultDto) {
        return this.percentResultService.createPercentResult(percentResultDto);
    }
}
