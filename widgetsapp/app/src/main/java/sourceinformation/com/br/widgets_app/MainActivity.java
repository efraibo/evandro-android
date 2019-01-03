package sourceinformation.com.br.widgets_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "br.com.sourceinformation.widgets_app";

    private ShareActionProvider shareAction;

    //private EditText vNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //vNome = (EditText)  findViewById(R.id.edtNome);
    }

    public void sendMenssage(View view) {
        //Toast.makeText(getApplicationContext(), vNome.getText().toString(), Toast.LENGTH_SHORT).show();
        //vNome.getText().clear();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.edtNome);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void callProgress(View view) {
        Intent intent = new Intent(this, ProgressBarActivity.class);
        startActivity(intent);
    }

    public void callView(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

    public void callImageView(View view) {
        Intent intent = new Intent(this, ImageViewActivity.class);
        startActivity(intent);
    }

    public void callSeekBar(View view) {
        Intent intent = new Intent(this, SeekBarActivity.class);
        startActivity(intent);
    }

    public void callRatingBar(View view) {
        Intent intent = new Intent(this, RatingBarActivity.class);
        startActivity(intent);
    }

    public void callSearch(View view) {
        Intent intent = new Intent(this, SearchViewActivity.class);
        startActivity(intent);
    }

    public void callWebView(View view) {
        Intent intent = new Intent(this, WebViewActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.mShare);
        shareAction = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mShare:
                Intent i = new Intent(
                        Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(
                        android.content.Intent.EXTRA_TEXT, "teste");
                startActivity(Intent.createChooser(
                        i,
                        "Share via"));
                break;
        }

        Toast.makeText(getApplicationContext(), "Click no menu para compartilhar", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);

    }
}
