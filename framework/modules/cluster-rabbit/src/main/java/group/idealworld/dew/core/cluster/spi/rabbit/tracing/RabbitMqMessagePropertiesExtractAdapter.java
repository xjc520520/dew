/*
 * Copyright 2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package group.idealworld.dew.core.cluster.spi.rabbit.tracing;

import com.ecfront.dew.common.exception.RTUnsupportedEncodingException;
import io.opentracing.propagation.TextMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Rabbit mq message properties extract adapter.
 *
 * @author gudaoxuri
 */
class RabbitMqMessagePropertiesExtractAdapter implements TextMap {

    private final Map<String, String> map = new HashMap<>();

    /**
     * Instantiates a new Rabbit mq message properties extract adapter.
     *
     * @param headers the headers
     */
    RabbitMqMessagePropertiesExtractAdapter(Map<String, Object> headers) {
        headers.forEach(
                (key, value) -> {
                    if (value == null) {
                        return;
                    }
                    map.put(key, value.toString());
                });
    }

    @Override
    public Iterator<Map.Entry<String, String>> iterator() {
        return map.entrySet().iterator();
    }

    @Override
    public void put(String key, String value) {
        throw new RTUnsupportedEncodingException("Should be used only with tracer#extract()");
    }
}
