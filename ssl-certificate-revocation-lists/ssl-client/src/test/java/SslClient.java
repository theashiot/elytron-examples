/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2020 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
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

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Assert;
import org.junit.Test;


/**
 * RESTEasy Client testing successful connection using Certificate Revocation Lists
 *
 * @author Sonia Zaldana Calles
 */
public class SslClient {

    @Test
    public void test() {
        ResteasyClient client = ((ResteasyClientBuilder) ClientBuilder.newBuilder()).hostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
        Response response = client.target("https://127.0.0.1:8443/ssl-server/HelloWorld").request().get();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(), 200);
    }
}