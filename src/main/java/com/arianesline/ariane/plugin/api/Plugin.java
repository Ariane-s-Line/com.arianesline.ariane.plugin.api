package com.arianesline.ariane.plugin.api;

public interface Plugin {

  static final StringBuilder containerVersion = new StringBuilder();

  default PluginInterface getInterfaceType() {
    return PluginInterface.NONE;
  }

  String getName();

  PluginType getType();

  default boolean hasSettingsUI() {
    return false;
  }

  void showSettings();
}
