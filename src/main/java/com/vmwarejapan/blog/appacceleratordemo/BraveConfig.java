package com.vmwarejapan.blog.appacceleratordemo;

import brave.handler.MutableSpan;
import brave.handler.SpanHandler;
import brave.propagation.TraceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BraveConfig {
    @Bean
    SpanHandler handlerOne() {
        return new SpanHandler() {
            @Override
            public boolean end(TraceContext traceContext, MutableSpan span, Cause cause) {
                for (int i =0 ; i < span.tagCount(); i++){
                    if (span.tagKeyAt(i).equals("jdbc.query")){
                        span.tag("component", "java-jdbc");
                        span.tag("db.type", "localdb");
                        span.tag("db.instance", "local");
                    }
                }
                return true;
            }
        };
    }
}