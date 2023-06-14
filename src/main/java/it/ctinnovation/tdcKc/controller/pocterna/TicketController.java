package it.ctinnovation.tdcKc.controller.pocterna;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class TicketController {

    @Autowired
    PocTernaService pocTernaService;

    @GetMapping("/custom/placemarks/{id}/incidents")
    String getIncidents(@PathVariable String id) throws JsonProcessingException, FileNotFoundException {
        return pocTernaService.getTicketsAsString(id);
    }

    @GetMapping("/api/ticket")
    String getTickets() throws JsonProcessingException, FileNotFoundException {
        return pocTernaService.getTicketsAsString();
    }
}
