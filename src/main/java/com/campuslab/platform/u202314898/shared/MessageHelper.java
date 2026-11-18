package com.campuslab.platform.u202314898.shared;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {
    private static MessageSource messageSource;

    public MessageHelper(MessageSource messageSource) {
        MessageHelper.messageSource = messageSource;
    }

    /**
     * Resuelve un mensaje por su clave utilizando el Locale actual del hilo (capturado del header Accept-Language).
     *
     * @param key  la clave del mensaje en el .properties
     * @param args argumentos opcionales para parámetros dinámicos {0}, {1}, etc.
     * @return el texto traducido correspondiente
     */
    public static String get(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
}
