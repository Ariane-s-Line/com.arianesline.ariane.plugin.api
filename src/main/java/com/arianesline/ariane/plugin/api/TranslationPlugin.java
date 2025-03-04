package com.arianesline.ariane.plugin.api;

import java.util.List;
import java.util.Locale;

public interface TranslationPlugin extends Plugin {

    String ACTIVATED_TRANSLATION = "ActivatedTranslation";

    String getTranslation(String text, Locale locale);

    List<Locale> getSupportedLanguages();


}
