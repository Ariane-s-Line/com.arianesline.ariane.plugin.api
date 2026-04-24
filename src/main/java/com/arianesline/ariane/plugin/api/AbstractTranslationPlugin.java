package com.arianesline.ariane.plugin.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base class for translation plugins that load their strings from a {@code .properties} file on the
 * classpath.
 *
 * <p><b>Naming convention for third-party i18n plugins:</b> the Java module name <em>must</em>
 * contain the segment {@code .ariane.plugin.i18n.} (e.g. {@code
 * com.example.ariane.plugin.i18n.italian}). Ariane uses this substring to distinguish i18n plugins
 * from other plugin types: they are loaded synchronously before the UI initialises, while all other
 * plugins load asynchronously in the background. Any module that does not follow this convention
 * will be treated as a regular plugin and will not be available during early UI construction.
 */
public abstract class AbstractTranslationPlugin implements TranslationPlugin {

  private static final Logger LOGGER = Logger.getLogger(AbstractTranslationPlugin.class.getName());

  private final PropertyResourceBundle bundle;
  private final Locale supportedLocale;

  /**
   * @param locale the single locale this plugin serves (e.g. {@code Locale.of("fr")})
   * @param resourcePath absolute classpath path to the {@code .properties} file (e.g. {@code
   *     "/com/example/ariane/plugin/i18n/italian/ui_it.properties"}). The plugin's module-info
   *     <em>must</em> {@code opens} the package containing this resource unconditionally — JPMS
   *     encapsulation otherwise prevents {@code getResourceAsStream} from crossing module
   *     boundaries.
   */
  protected AbstractTranslationPlugin(Locale locale, String resourcePath) {
    this.supportedLocale = locale;
    PropertyResourceBundle loaded = null;
    try (InputStream in = getClass().getResourceAsStream(resourcePath)) {
      if (in != null) {
        try (Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
          loaded = new PropertyResourceBundle(reader);
        }
      } else {
        LOGGER.warning("Translation resource not found: " + resourcePath);
      }
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Failed to load translation resource: " + resourcePath, e);
    }
    this.bundle = loaded;
  }

  @Override
  public String getTranslation(String text, Locale locale) {
    if (bundle != null && supportedLocale.getLanguage().equals(locale.getLanguage())) {
      if (bundle.containsKey(text)) {
        return bundle.getString(text);
      }
    }
    return null;
  }

  @Override
  public List<Locale> getSupportedLanguages() {
    return List.of(supportedLocale);
  }

  @Override
  public PluginType getType() {
    return PluginType.TRANSLATE;
  }

  @Override
  public void showSettings() {}
}
