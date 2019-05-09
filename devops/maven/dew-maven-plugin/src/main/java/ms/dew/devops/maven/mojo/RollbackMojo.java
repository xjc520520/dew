/*
 * Copyright 2019. the original author or authors.
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

package ms.dew.devops.maven.mojo;

import io.kubernetes.client.ApiException;
import ms.dew.devops.kernel.flow.rollback.DefaultRollbackFlow;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.IOException;

/**
 * Rollback mojo.
 *
 * @author gudaoxuri
 */
@Mojo(name = "rollback")
@Execute(phase = LifecyclePhase.VALIDATE, goal = "init")
public class RollbackMojo extends BasicMojo {

    @Override
    protected boolean executeInternal() throws IOException, ApiException {
        return new DefaultRollbackFlow().exec(mavenProject.getId(), getMojoName());
    }

}
