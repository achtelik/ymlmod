package it.achtelik.ymlmod;

public class YmlPostResultDto {
    private String yml;

    public YmlPostResultDto() {
    }

    public YmlPostResultDto(String yml) {
        this.yml = yml;
    }

    public String getYml() {
        return yml;
    }

    public void setYml(String yml) {
        this.yml = yml;
    }
}
