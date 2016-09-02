/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.nagios.springboot;

import org.apache.camel.component.nagios.NagiosConfiguration;
import org.apache.camel.component.nagios.NagiosEncryptionMethod;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * To send passive checks to Nagios using JSendNSCA.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.nagios")
public class NagiosComponentConfiguration {

    /**
     * To use a shared configuraiton. Properties of the shared configuration can
     * also be set individually.
     */
    private NagiosConfiguration configuration;
    /**
     * This is the address of the Nagios host where checks should be send.
     */
    private String host;
    /**
     * The port number of the host.
     */
    private Integer port;
    /**
     * Connection timeout in millis.
     */
    private Integer connectionTimeout;
    /**
     * Sending timeout in millis.
     */
    private Integer timeout;
    /**
     * Password to be authenticated when sending checks to Nagios.
     */
    private String password;
    /**
     * To specify an encryption method.
     */
    private NagiosEncryptionMethod encryptionMethod;

    public NagiosConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(NagiosConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NagiosEncryptionMethod getEncryptionMethod() {
        return encryptionMethod;
    }

    public void setEncryptionMethod(NagiosEncryptionMethod encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }
}