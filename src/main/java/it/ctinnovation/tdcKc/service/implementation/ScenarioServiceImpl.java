package it.ctinnovation.tdcKc.service.implementation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.model.scenario.ScenarioMessage;
import it.ctinnovation.tdcKc.service.ScenarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ScenarioServiceImpl implements ScenarioService {

    @Override
    public void saveScenario(MultipartFile file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<ScenarioMessage> messages = new ArrayList<>();
        //List<Message> messages = new ArrayList<>();


        try (InputStream inputStream = file.getInputStream()) {
            // Read the entire content as a byte array
            byte[] contentBytes = inputStream.readAllBytes();

            // Convert the byte array to a String
            String content = new String(contentBytes, StandardCharsets.UTF_8);

            JsonNode jsonNode = objectMapper.readTree(content);
            if (jsonNode.isArray()) {
                // Unmarshal each object in the JSON array into a Message object
                for (JsonNode node : jsonNode) {
                    ScenarioMessage message = objectMapper.treeToValue(node, ScenarioMessage.class);
                    //Message message = objectMapper.treeToValue(node, Message.class);
                    messages.add(message);
                }
            }
        } catch (IOException e)     {
            log.error("Error reading file", e);
        }

        log.info("Saving scenario");
    }
}
