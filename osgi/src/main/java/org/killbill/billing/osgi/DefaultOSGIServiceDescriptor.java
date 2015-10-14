/*
 * Copyright 2010-2013 Ning, Inc.
 * Copyright 2014 Groupon, Inc
 * Copyright 2014 The Billing Project, LLC
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

package org.killbill.billing.osgi;

import org.killbill.billing.osgi.api.OSGIServiceDescriptor;

public class DefaultOSGIServiceDescriptor implements OSGIServiceDescriptor {

    private final String pluginSymbolicName;
    private final String pluginName;
    private final String serviceName;

    public DefaultOSGIServiceDescriptor(final String pluginSymbolicName, final String pluginName, final String serviceName) {
        this.pluginSymbolicName = pluginSymbolicName;
        this.pluginName = pluginName;
        this.serviceName = serviceName;
    }

    @Override
    public String getPluginSymbolicName() {
        return pluginSymbolicName;
    }

    @Override
    public String getPluginName() {
        return pluginName;
    }

    @Override
    public String getRegistrationName() {
        return serviceName;
    }
}
