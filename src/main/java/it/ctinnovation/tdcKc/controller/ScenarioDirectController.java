package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import it.ctinnovation.tdcKc.service.PlacemarkSendingService;
import it.ctinnovation.tdcKc.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Controller
@RequiredArgsConstructor
public class ScenarioDirectController {

   final  PlacemarkSendingService placemarkSendingService;
   final ScenarioService scenarioService;

   //region Placemark sending
    @ExtDirectMethod
    public String startSendMessageForPlacemark(String placemark) {
        String placemarkId="1:1:2:1:4:0015";
        placemarkSendingService.startSendingMessages(placemarkId);
        return "Started message sending for placemark: " + placemark;
    }

    @ExtDirectMethod
    public String stopSendMessageForPlacemark(String placemark) {
        placemarkSendingService.stopSendingMessages();
        return "Stopped message sending ";
    }
    //endregion

   //region ScenarioEntity
    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<ScenarioEntity> read(ExtDirectStoreReadRequest storeRequest) {
        List<ScenarioEntity> data = scenarioService.read();
        return new ExtDirectStoreResult<>(data.size(), data);
    }
    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioEntity create(ScenarioEntity companyRole) {
        return scenarioService.create(companyRole);
    }
    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioEntity update(ScenarioEntity companyRole) {
        return scenarioService.update(companyRole);
    }
    @ExtDirectMethod(STORE_MODIFY)
    public void destroy(List<ScenarioEntity> companyRoleList) {
        scenarioService.destroy(companyRoleList);
    }
//endregion
}
