/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class SwtGriffonPlugin {
    String version = '0.9.5-SNAPSHOT'
    String griffonVersion = '0.9.5-SNAPSHOT > *'
    Map dependsOn = [:]
    List pluginIncludes = []
    String license = 'Apache Software License 2.0'
    List toolkits = ['swt']
    List platforms = []

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Enables SWT support'
    String description = '''
Enables the usage of SWT based components in Views.

Usage
----
TBD

Configuration
-------------
There's no special configuration for this plugin.

[1]: http://groovy.codehaus.org/GroovySWT
'''

    // URL to the plugin's documentation
    def documentation = 'http://griffon.codehaus.org/Swt+Plugin'
}
