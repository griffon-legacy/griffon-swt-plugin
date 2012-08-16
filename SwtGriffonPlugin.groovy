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
    String version = '1.0.0'
    String griffonVersion = '1.0.0 > *'
    Map dependsOn = [:]
    List pluginIncludes = []
    String license = 'Apache Software License 2.0'
    List toolkits = ['swt']
    List platforms = []
    String documentation = ''
    String source = 'https://github.com/griffon/griffon-swt-plugin'

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
-----
This plugin applies some changes to the runtime configuration when the application is run for the first time. It's possible that
this configuration is not honored the first time the application is started resulting in a frozen application. If so, then simply
quit and restart. The problem will not appear again.


The following nodes will become available on a View script upon installing this plugin

| *Node*    | *Type*                           |
| --------- | -------------------------------- |
| migLayout | `net.miginfocom.swt.MigLayout` |

This node supports the following properties

 * **layoutConstraints** - defines general constraints
 * **columnConstraints** - defines constraints applicable to columns only
 * **rowConstraints** - defines constraints applicable to rows only


Configuration
-------------
There's no special configuration for this plugin.

[1]: http://groovy.codehaus.org/GroovySWT
'''
}
