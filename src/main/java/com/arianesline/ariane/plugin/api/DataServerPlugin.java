package com.arianesline.ariane.plugin.api;

import com.arianesline.cavelib.api.CaveSurveyInterface;
import java.io.File;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;

public interface DataServerPlugin extends Plugin {

  File getSurveyFile();

  void setSurveyFile(File file);

  default BooleanProperty getDirtyProperty() {
    return new SimpleBooleanProperty();
  }

  StringProperty getCommandProperty();

  CaveSurveyInterface getSurvey();

  void setSurvey(CaveSurveyInterface survey);

  void showUI();

  Node getUINode();

  Image getIcon();

  void closeUI();
}
