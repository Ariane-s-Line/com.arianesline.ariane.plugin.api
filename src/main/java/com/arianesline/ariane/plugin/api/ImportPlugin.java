package com.arianesline.ariane.plugin.api;

import com.arianesline.cavelib.api.CaveSurveyInterface;
import java.io.InputStream;

public interface ImportPlugin extends Plugin {

  String getFileTypeName();

  String getFileExtension();

  boolean importFile(CaveSurveyInterface survey, InputStream inStream);
}
