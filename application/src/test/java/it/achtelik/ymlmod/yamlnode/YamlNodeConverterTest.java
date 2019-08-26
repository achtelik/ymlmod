package it.achtelik.ymlmod.yamlnode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import it.achtelik.ymlmod.testutils.FileUtils;

import java.util.Map;

class YamlNodeConverterTest {

    @Test
    void convertNoValueCollection() throws Exception {
        Map<String, Object> ymlInputObjectMap = new FileUtils().loadYamlFile("yaml/test-collection-no-value.yml");
        YamlNode yamlNode = new YamlNodeConverter().convert(ymlInputObjectMap);
        Map<String, Object> ymlResultObjectMap = new YamlNodeConverter().convert(yamlNode);
        Assertions.assertTrue(ymlInputObjectMap.equals(ymlResultObjectMap));
    }
}
