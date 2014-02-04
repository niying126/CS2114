package sofia.demo.temp;
import android.widget.Button;
import android.widget.EditText;
import sofia.app.Screen;
public class Temp extends Screen
{
    private EditText fBox;
    private EditText cBox;
    private Button clear;

    public void initialize()
    {
        fBox.setText("32");
        cBox.setText("10");
    }
    public void clearClicked()
    {
        cBox.setText("");
        fBox.setText("");
    }
    public void fBoxEditingDone()
    {
        double degreesF =
            Double.parseDouble(fBox.getText().toString());
        double degreesC = (degreesF - 32) * 5 / 9;
        cBox.setText(Double.toString(degreesC));
    }
    public void cBoxEditingDone()
    {
        double degreesC =
            Double.parseDouble(cBox.getText().toString());
        double degreesF = degreesC * 9 / 5 + 32;
        fBox.setText(Double.toString(degreesF));
    }
}
