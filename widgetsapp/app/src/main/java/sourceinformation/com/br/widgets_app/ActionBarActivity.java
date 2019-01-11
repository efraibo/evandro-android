package sourceinformation.com.br.widgets_app;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.Toolbar;

public class ActionBarActivity extends Activity {

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    private void setSupportActionBar(Toolbar myToolbar) {
    }

}
