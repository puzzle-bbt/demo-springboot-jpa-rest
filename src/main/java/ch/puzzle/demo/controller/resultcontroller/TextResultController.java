package ch.puzzle.demo.controller.resultcontroller;

import ch.puzzle.demo.model.database.results.TextResult;
import ch.puzzle.demo.model.dto.result.TextResultDto;
import ch.puzzle.demo.service.result.TextResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static ch.puzzle.demo.model.helper.UrlLibrary.*;

@RestController
@RequestMapping(BASIC_URL)
public class TextResultController {
    private final TextResultService textResultService;

    @Autowired
    public TextResultController(TextResultService textResultService) {
        this.textResultService = textResultService;
    }

    @GetMapping(GET_TEXTRESULTS)
    @ResponseBody
    public List<TextResult> getTextResults() {
        return textResultService.getAllTextResults();
    }

    @PostMapping(POST_TEXTRESULT)
    @ResponseBody
    public TextResult createTextResult(@Valid TextResultDto textResultDto) {
        return textResultService.createTextResult(textResultDto);
    }
}
