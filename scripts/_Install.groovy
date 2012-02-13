/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import griffon.util.Metadata

/**
 * @author Andres Almiray
 */

updateMetadata('app.toolkit': 'swt')

// check to see if we already have a SwtBuilder
configText = """root.'groovy.swt.SwtBuilder'.view = '*'"""
if(!(builderConfigFile.text.contains(configText))) {
    println 'Adding groovy.swt.SwtBuilder to Builder.groovy'
    builderConfigFile.text += configText
}
