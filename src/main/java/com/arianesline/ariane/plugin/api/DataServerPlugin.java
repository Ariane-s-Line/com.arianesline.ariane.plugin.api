package com.arianesline.ariane.plugin.api;

import com.arianesline.cavelib.api.CaveSurveyInterface;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;


public interface DataServerPlugin extends Plugin {

    File getSurveyFile();

    void setSurveyFile(File file);

    StringProperty getCommandProperty();

    CaveSurveyInterface getSurvey();

    void setSurvey(CaveSurveyInterface survey);

    void showUI();

    Node getUINode();

    Image getIcon();

    void closeUI();

}
