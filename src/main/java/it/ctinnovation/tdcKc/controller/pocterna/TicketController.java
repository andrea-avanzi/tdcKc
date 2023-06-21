package it.ctinnovation.tdcKc.controller.pocterna;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@Slf4j
public class TicketController {

    @Autowired
    PocTernaService pocTernaService;

    @GetMapping("/api/ticket")
    String getIncidents(@RequestParam(name="assetId") String assetId,
                        @RequestParam(name="publicId") String publicId,
                        @RequestParam(name="id") String id) throws JsonProcessingException, FileNotFoundException {
        String output= pocTernaService.getTicketsAsString(assetId);
        log.info("output: " + output);
        return output;
    }

    @GetMapping("/api/tickets")
    String getTickets() throws JsonProcessingException, FileNotFoundException {
        return pocTernaService.getTicketsAsString();
    }
}
