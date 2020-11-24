/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.config.server.environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.config.server.config.ConfigServerProperties;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AwsS3EnvironmentRepositoryFactory
		implements EnvironmentRepositoryFactory<AwsS3EnvironmentRepository, AwsS3EnvironmentProperties> {
	private static Logger logger = LoggerFactory.getLogger(AwsS3EnvironmentRepositoryFactory.class);
	final private ConfigServerProperties server;

	public AwsS3EnvironmentRepositoryFactory(ConfigServerProperties server) {
		this.server = server;
	}

	@Override
	public AwsS3EnvironmentRepository build(AwsS3EnvironmentProperties environmentProperties) {
		final AmazonS3ClientBuilder clientBuilder = AmazonS3ClientBuilder.standard();
		if (environmentProperties.getRegion() != null) {
			clientBuilder.withRegion(environmentProperties.getRegion());
		}
		final AmazonS3 client = clientBuilder.build();
		if (environmentProperties.getEndpoint() != null) {
			client.setEndpoint(environmentProperties.getEndpoint());
		}
		logger.debug("environmentProperties.getSearchPaths() : "+environmentProperties.getSearchPaths());
		logger.debug("environmentProperties.getBucket() : "+environmentProperties.getBucket());
		AwsS3EnvironmentRepository repository = new AwsS3EnvironmentRepository(client,
				environmentProperties.getBucket(), server,environmentProperties.getSearchPaths());
		return repository;
	}

}
