package com.arianesline.ariane.plugin.api;

import com.arianesline.cavelib.api.CaveSurveyInterface;
import com.arianesline.cavelib.api.StationInterface;

import java.io.OutputStream;
import java.util.List;

public interface ExportPlugin extends Plugin {

    String getFileTypeName();

    String getFileExtension();

    boolean export(CaveSurveyInterface survey, List<StationInterface> stations, OutputStream outStream);

}
