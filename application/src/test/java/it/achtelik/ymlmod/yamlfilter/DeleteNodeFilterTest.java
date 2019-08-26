package it.achtelik.ymlmod.yamlfilter;

import it.achtelik.ymlmod.testutils.FileUtils;
import it.achtelik.ymlmod.yamlfilter.filter.DeleteNodeFilter;
import it.achtelik.ymlmod.yamlnode.YamlNode;
import it.achtelik.ymlmod.yamlnode.YamlNodeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class DeleteNodeFilterTest {

    @Test
    void filter() throws Exception {
        Map<String, Object> ymlInputObjectMap = new FileUtils().loadYamlFile("yaml/test-template-01.yml");
        YamlNode yamlNode = new YamlNodeConverter().convert(ymlInputObjectMap);
        yamlNode = new DeleteNodeFilter(".*creationTimestamp", ".*").filter(yamlNode);
        Map<String, Object> ymlResultObjectMap = new YamlNodeConverter().convert(yamlNode);
        Map<String, Object> loadResultYmlFile = new FileUtils().loadYamlFile("yaml/test-template-01.yml");
        Assertions.assertTrue(loadResultYmlFile.equals(ymlResultObjectMap));
    }
}
