package it.achtelik.ymlmod.dumperoptions;

import it.achtelik.ymlmod.YamlService;
import it.achtelik.ymlmod.testutils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import it.achtelik.ymlmod.yamlfilter.NoFilterConfiguration;

class KubernetesDumperOptionsTest {

    @Test
    void testLoadAndSave() throws Exception {
        String yamlInputString = new FileUtils().loadResourceAsString("yaml/k-creator-fixedForLoadAndSave.yml");
        String yamlResultString = new YamlService().clean(yamlInputString, new NoFilterConfiguration(), new KubernetesDumperOptions());
        Assertions.assertEquals(yamlInputString, yamlResultString);
    }

}
