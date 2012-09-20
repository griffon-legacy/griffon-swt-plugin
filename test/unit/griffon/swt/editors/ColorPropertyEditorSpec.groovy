package griffon.swt.editors

import org.eclipse.swt.graphics.Color
import org.eclipse.swt.widgets.Display
import spock.lang.Specification
import spock.lang.Unroll

import java.beans.PropertyEditor

@Unroll
class ColorPropertyEditorSpec extends Specification {
    void "Color format '#format' should be equal to #color"() {
        setup:

        PropertyEditor editor = new ColorPropertyEditor()

        when:
        editor.value = format

        then:

        color == editor.value

        where:
        color                   | format
        newColor(255, 0, 0)     | '#F00'
        newColor(255, 0, 0)     | '#FF0000'
        newColor(255, 0, 0)     | ['FF', '00', '00']
        newColor(255, 0, 0)     | [255, 0, 0]
        newColor(255, 0, 0)     | ['FF', 0, 0]
        newColor(255, 255, 255) | 255
        newColor(255, 0, 0)     | [red: 255]
        newColor(255, 0, 0)     | [red: 'FF']
        newColor(255, 0, 0)     | [red: 'FF', green: 0, blue: 0]
        newColor(255, 0, 0)     | [r: 255]
        newColor(255, 0, 0)     | [r: 'FF']
        newColor(255, 0, 0)     | [r: 'FF', g: '00', b: '00']
        new Color(16, 32, 48)   | '#102030'
        new Color(16, 32, 48)   | [16, 32, 48]
        new Color(16, 32, 48)   | [r: 16, g: 32, b: 48]
        new Color(16, 32, 48)   | ['10', '20', '30']
        new Color(16, 32, 48)   | [r: '10', g: '20', b: '30']
    }

    private Color newColor(int r, int g, int b) {
        new Color(Display.default, r, g, b)
    }

    void "Invalid color format '#format'"() {
        setup:

        PropertyEditor editor = new ColorPropertyEditor()

        when:
        editor.value = format

        then:

        thrown(IllegalArgumentException)

        where:
        format << [
                '',
                '   ',
                'garbage',
                [],
                [1],
                [1, 2],
                [1, 2, 3, 4, 5],
                'F00',
                '#F0',
                '#FF0000FF00',
                ['HH', 'FF', '00'],
                new Object()
        ]
    }
}
