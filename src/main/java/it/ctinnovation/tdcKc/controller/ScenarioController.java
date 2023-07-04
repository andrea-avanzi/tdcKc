package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult;
import it.ctinnovation.tdcKc.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class ScenarioController {

    final ScenarioService scenarioService;

    @ExtDirectMethod(ExtDirectMethodType.FORM_POST)
    public ExtDirectFormPostResult uploadMessagesFile(
       //@RequestParam("id") Long id,
        @RequestParam("messagesFile") MultipartFile file) throws Exception {
        scenarioService.saveScenario(file);
        return new ExtDirectFormPostResult(true);
    }
}
