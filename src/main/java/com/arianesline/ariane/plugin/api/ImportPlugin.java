package com.arianesline.ariane.plugin.api;

import com.arianesline.cavelib.api.CaveSurveyInterface;
import com.arianesline.cavelib.api.StationInterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface ImportPlugin extends Plugin {

    String getFileTypeName();

    String getFileExtension();

    boolean importFile(CaveSurveyInterface survey, InputStream inStream);

}

