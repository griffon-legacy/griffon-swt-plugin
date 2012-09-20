/*
 * Copyright 2010-2012 the original author or authors.
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

package griffon.swt.editors;

import griffon.core.resources.editors.AbstractPropertyEditor;
import griffon.swt.SWTApplication;
import griffon.util.ApplicationHolder;
import org.eclipse.swt.graphics.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author Andres Almiray
 */
public class ImagePropertyEditor extends AbstractPropertyEditor {
    public void setAsText(String value) throws IllegalArgumentException {
        setValue(value);
    }

    public void setValue(Object value) {
        if (null == value) return;
        if (value instanceof CharSequence) {
            handleAsString(String.valueOf(value));
        } else if (value instanceof File) {
            handleAsFile((File) value);
        } else if (value instanceof URL) {
            handleAsURL((URL) value);
        } else if (value instanceof URI) {
            handleAsURI((URI) value);
        } else if (value instanceof InputStream) {
            handleAsInputStream((InputStream) value);
        } else {
            throw illegalValue(value, Image.class);
        }
    }

    private void handleAsString(String str) {
        handleAsURL(getClass().getClassLoader().getResource(str));
    }

    private void handleAsFile(File file) {
        try {
            super.setValue(newImage(new FileInputStream(file)));
        } catch (IOException e) {
            throw illegalValue(file, URL.class);
        }
    }

    private void handleAsURL(URL url) {
        try {
            super.setValue(newImage(url.openStream()));
        } catch (IOException e) {
            throw illegalValue(url, URL.class);
        }
    }

    private void handleAsURI(URI uri) {
        try {
            handleAsURL(uri.toURL());
        } catch (MalformedURLException e) {
            throw illegalValue(uri, URL.class);
        }
    }

    private void handleAsInputStream(InputStream stream) {
        super.setValue(newImage(stream));
    }

    private Image newImage(InputStream stream) {
        return new Image(application().getDisplay(), stream);
    }

    private SWTApplication application() {
        return (SWTApplication) ApplicationHolder.getApplication();
    }
}
