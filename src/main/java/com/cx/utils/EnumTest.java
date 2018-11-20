package com.cx.utils;

public enum  EnumTest {

    HUANBEI(10040001,"还呗");

    private Integer sceneId;
    private String name;

    EnumTest(Integer sceneId, String name){
        this.sceneId = sceneId;
        this.name = name;
    }
    public Integer getSceneId() {
        return sceneId;
    }

    public String getName() {
        return name;
    }

    public static String getNameBySceneId(Integer sceneId){
        try{
            EnumTest[] values = EnumTest.values();
            for(EnumTest scene:values){
                if(scene.getSceneId().equals(sceneId)){
                    return scene.getName();
                }
            }
            return "";
        }catch (Exception e){
            return "";
        }
    }

}
