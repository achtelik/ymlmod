package it.achtelik.ymlmod.testutils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

public class FileUtils {

    public Map<String, Object> loadYamlFile(String filePath) throws Exception {
        return new Yaml().load(loadResourceAsString(filePath));
    }

    public String loadResourceAsString(String fileName) throws Exception {
        File file = new File(this.getClass().getClassLoader().getResource(fileName).getFile());
        System.out.println("File Found : " + file.exists());
        String content = new String(Files.readAllBytes(file.toPath()));
        return content;
    }
}
