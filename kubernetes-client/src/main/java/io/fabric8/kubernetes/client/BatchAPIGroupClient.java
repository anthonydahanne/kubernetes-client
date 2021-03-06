/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.batch.CronJob;
import io.fabric8.kubernetes.api.model.batch.DoneableJob;
import io.fabric8.kubernetes.api.model.batch.Job;
import io.fabric8.kubernetes.api.model.batch.JobList;
import io.fabric8.kubernetes.api.model.batch.CronJobList;
import io.fabric8.kubernetes.api.model.batch.DoneableCronJob;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.internal.CronJobOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.JobOperationsImpl;
import okhttp3.OkHttpClient;

public class BatchAPIGroupClient extends BaseClient implements BatchAPIGroupDSL {

  public BatchAPIGroupClient() throws KubernetesClientException {
    super();
  }

  public BatchAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Job, JobList, DoneableJob, ScalableResource<Job, DoneableJob>> jobs() {
    return new JobOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  @Override
  public MixedOperation<CronJob, CronJobList, DoneableCronJob, Resource<CronJob, DoneableCronJob>> cronjobs() {
    return new CronJobOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }
}
