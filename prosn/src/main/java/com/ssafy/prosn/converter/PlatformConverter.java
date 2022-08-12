package com.ssafy.prosn.cj.converter;

import com.ssafy.prosn.cj.Platform;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class PlatformConverter implements Converter<String, Platform> {

    @Override
    public Platform convert(String source) {
        return Platform.valueOf(source.toUpperCase());
    }
}
