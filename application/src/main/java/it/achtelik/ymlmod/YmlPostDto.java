package it.achtelik.ymlmod;

public class YmlPostDto {
    private String yml;

    public YmlPostDto() {
    }

    public YmlPostDto(String yml) {
        this.yml = yml;
    }

    public String getYml() {
        return yml;
    }

    public void setYml(String yml) {
        this.yml = yml;
    }
}
