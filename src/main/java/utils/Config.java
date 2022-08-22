package utils;

public class Config {

    public static String userName = JsonParseUtils.getElementParseFromJson("config.json", "/userName");
    public static String password = JsonParseUtils.getElementParseFromJson("config.json", "/password");
    public static String connectionUrl = JsonParseUtils.getElementParseFromJson("config.json", "/connectionUrl");
    public static String authorName = JsonParseUtils.getElementParseFromJson("config.json", "/authorName");
    public static String authorLogin =  JsonParseUtils.getElementParseFromJson("config.json", "/authorLogin");
    public static String authorEmail = JsonParseUtils.getElementParseFromJson("config.json", "/authorEmail");
    public static String sessionNumber = JsonParseUtils.getElementParseFromJson("config.json", "/sessionBuildNunber");
    public static String env = JsonParseUtils.getElementParseFromJson("config.json", "/env");
    public static String browser = JsonParseUtils.getElementParseFromJson("config.json", "/browser");
    public static Integer sizeSortList = Integer.parseInt(JsonParseUtils.getElementParseFromJson("testing.json","/sizeSortListTest"));


}
