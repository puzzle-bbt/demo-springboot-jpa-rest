package ch.puzzle.demo.controller.resultcontroller;

import ch.puzzle.demo.model.database.results.BooleanResult;
import ch.puzzle.demo.model.dto.result.BooleanResultDto;
import ch.puzzle.demo.service.result.BooleanResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static ch.puzzle.demo.model.helper.UrlLibrary.*;

@RestController
@RequestMapping(BASIC_URL)
public class BooleanResultController {
    private final BooleanResultService booleanResultService;

    @Autowired
    public BooleanResultController(BooleanResultService booleanResultService) {
        this.booleanResultService = booleanResultService;
    }

    @GetMapping(GET_BOOLEANRESULTS)
    @ResponseBody
    public List<BooleanResult> getBooleanResults() {
        return this.booleanResultService.getAllBooleanResults();
    }

    @PostMapping(POST_BOOLEANRESULT)
    @ResponseBody
    public BooleanResult createBooleanResult(@Valid BooleanResultDto booleanResultDto) {
        return this.booleanResultService.createBooleanResult(booleanResultDto);
    }
}
