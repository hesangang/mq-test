package com.sg.mq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * @author sangang
 * @desc:
 * @date 2026-01-26
 */
@Tag(name = "日志")
@Slf4j
@RestController
@RequestMapping("/task")
public class Test {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/{taskId}/vital-signs")
    public Map<String, Object> vital(@PathVariable Integer taskId) {
        Map bloodPressureMap = new HashMap();
        bloodPressureMap.put("systolic", 120 + taskId);
        bloodPressureMap.put("diastolic", 80 + taskId);
        Map map = new HashMap();
        map.put("temperature", 36.7 + taskId);
        map.put("pulse", 76 * taskId);
        map.put("measureTime", LocalDateTime.now().toString());
        map.put("bloodPressure", bloodPressureMap);

        return map;
    }

    String s2 = "{\n" +
            "    \"type\": \"object\",\n" +
            "    \"properties\": {\n" +
            "      \"vital\": {\n" +
            "        \"type\": \"void\",\n" +
            "        \"x-component\": \"vitalsignsviewer\"\n" +
            "      },\n" +
            "      \"row1Wrapper\": {\n" +
            "        \"type\": \"void\",\n" +
            "        \"x-decorator\": \"FormItem\",\n" +
            "        \"x-decorator-props\": {\n" +
            "          \"style\": {\n" +
            "            \"maxWidth\": \"520px\",\n" +
            "            \"marginBottom\": \"0px\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"properties\": {\n" +
            "          \"row1\": {\n" +
            "            \"type\": \"void\",\n" +
            "            \"x-component\": \"FormGrid\",\n" +
            "            \"x-component-props\": {\n" +
            "              \"maxColumns\": 2,\n" +
            "              \"minColumns\": 2,\n" +
            "              \"columnGap\": 8\n" +
            "            },\n" +
            "            \"properties\": {\n" +
            "              \"col1\": {\n" +
            "                \"type\": \"void\",\n" +
            "                \"x-component\": \"FormGrid.GridColumn\",\n" +
            "                \"properties\": {\n" +
            "                  \"temperature\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"体温\",\n" +
            "                    \"x-decorator\": \"FormItem\",\n" +
            "                    \"x-decorator-props\": {\n" +
            "                      \"labelWidth\": 60,\n" +
            "                      \"style\": {\n" +
            "                        \"maxWidth\": \"260px\",\n" +
            "                        \"marginRight\": \"0px\",\n" +
            "                        \"marginBottom\": \"0px\"\n" +
            "                      }\n" +
            "                    },\n" +
            "                    \"x-component\": \"InputNumber\",\n" +
            "                    \"x-component-props\": {\n" +
            "                      \"style\": {\n" +
            "                        \"width\": \"180px\"\n" +
            "                      }\n" +
            "                    }\n" +
            "                  }\n" +
            "                }\n" +
            "              },\n" +
            "              \"col2\": {\n" +
            "                \"type\": \"void\",\n" +
            "                \"x-component\": \"FormGrid.GridColumn\",\n" +
            "                \"properties\": {\n" +
            "                  \"pulse\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"脉搏\",\n" +
            "                    \"x-decorator\": \"FormItem\",\n" +
            "                    \"x-decorator-props\": {\n" +
            "                      \"labelWidth\": 60,\n" +
            "                      \"style\": {\n" +
            "                        \"maxWidth\": \"260px\",\n" +
            "                        \"marginLeft\": \"0px\",\n" +
            "                        \"marginBottom\": \"0px\"\n" +
            "                      }\n" +
            "                    },\n" +
            "                    \"x-component\": \"InputNumber\",\n" +
            "                    \"x-component-props\": {\n" +
            "                      \"style\": {\n" +
            "                        \"width\": \"180px\"\n" +
            "                      }\n" +
            "                    }\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    @GetMapping("/{taskId}/form")
    public Map<String, Object> form(@PathVariable Integer taskId) throws JsonProcessingException {

        JsonNode schemaNode = objectMapper.readTree(s2);

        Map<String, Object> bloodPressureMap = new HashMap();
        bloodPressureMap.put("systolic", 120 + taskId);
        bloodPressureMap.put("diastolic", 80 + taskId);
        Map<String, Object> map = new HashMap();
        map.put("temperature", 36.7 + taskId);
        map.put("pulse", 76 * taskId);
        map.put("measureTime", LocalDateTime.now().toString());
        map.put("bloodPressure", bloodPressureMap);

        Map<String, Object> schemaData = new HashMap();
        schemaData.put("temperature", 37.5);
        schemaData.put("pulse", 10);
        schemaData.put("vital", bloodPressureMap);

        Map<String, Object> result = new HashMap<>();
        //result.put("task", task);
        result.put("schema", schemaNode);
        result.put("formData", schemaData);
        result.put("readonly", false);
        result.put("title", "表单"+taskId);

        return result;
    }

    @PostMapping("/{taskId}/form/submit")
    public String submit(@PathVariable Map<String, Object> req) {
        log.info("submit:{}",req);
        return "成功";
    }
}
