/*
 * Copyright 2010-2014 Ning, Inc.
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.osgi.pluginconf;

import java.util.HashMap;
import java.util.Map;

import org.killbill.billing.osgi.api.config.PluginConfigServiceApi;
import org.killbill.billing.osgi.api.config.PluginJavaConfig;
import org.killbill.billing.osgi.api.config.PluginRubyConfig;

public class DefaultPluginConfigServiceApi implements PluginConfigServiceApi {

    private final Map<Long, PluginJavaConfig> javaConfigMappings = new HashMap<Long, PluginJavaConfig>();
    private final Map<Long, PluginRubyConfig> rubyConfigMappings = new HashMap<Long, PluginRubyConfig>();

    @Override
    public PluginJavaConfig getPluginJavaConfig(final long bundleId) {
        synchronized (javaConfigMappings) {
            return javaConfigMappings.get(bundleId);
        }
    }

    @Override
    public PluginRubyConfig getPluginRubyConfig(final long bundleId) {
        synchronized (rubyConfigMappings) {
            return rubyConfigMappings.get(bundleId);
        }
    }

    public void registerBundle(final Long bundleId, final PluginJavaConfig javaConfig) {
        synchronized (javaConfigMappings) {
            javaConfigMappings.put(bundleId, javaConfig);
        }
    }

    public void registerBundle(final Long bundleId, final PluginRubyConfig rubyConfig) {
        synchronized (rubyConfigMappings) {
            rubyConfigMappings.put(bundleId, rubyConfig);
        }
    }
}
