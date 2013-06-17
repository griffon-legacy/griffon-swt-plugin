
Enables SWT support
-------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/swt](http://artifacts.griffon-framework.org/plugin/swt)


Enables the usage of SWT based components in Views.

Usage
-----
This plugin applies some changes to the runtime configuration when the application is run for the first time. It's possible that
this configuration is not honored the first time the application is started resulting in a frozen application. If so, then simply
quit and restart. The problem will not appear again.


The following nodes will become available on a View script upon installing this plugin

| *Node*    | *Type*                           |
| --------- | -------------------------------- |
| migLayout | `net.miginfocom.swt.MigLayout`   |

This node supports the following properties

 * **layoutConstraints** - defines general constraints
 * **columnConstraints** - defines constraints applicable to columns only
 * **rowConstraints** - defines constraints applicable to rows only


Configuration
-------------
There's no special configuration for this plugin.

[1]: http://groovy.codehaus.org/GroovySWT

