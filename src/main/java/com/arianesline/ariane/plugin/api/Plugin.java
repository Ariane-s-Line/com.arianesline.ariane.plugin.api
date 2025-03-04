package com.arianesline.ariane.plugin.api;

public interface Plugin {

    default PluginInterface getInterfaceType(){
        return PluginInterface.NONE;
    }
    String getName();

    PluginType getType();

    void showSettings();
}

