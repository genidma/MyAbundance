package college.invisible.myabundance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MainActivity mainActivity = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, InputActivity.class);
                startActivity(intent);

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                */
            }
        });
        RelativeLayout rl = (RelativeLayout) this.findViewById(R.id.relative_view);
        Context context = rl.getContext();
        List<String> storyLines = Arrays.asList(
                "A droid has information that will help those working on creating a world of abundance ",
                "The droid, releases this information like a manna machine. Bringing comfort to the people and providing knowledge. Educating them.",
                "A great world of abundance is in the making. Technology will make it happen. Food, water, housing, security, love, empathy and knowledge. One common destiny for all forms of consciousness!"
        );
        final HashMap<Integer, String> map = new HashMap<>();
        int prevId = R.id.hello_view;
        /*
            StoryTeller st = new StoryTeller(rl, context, storyLines, R.id.hello_view);
            st.setOnClickListener(tv);
            */
        List<TextView> tvs = new ArrayList<>();
        for (int i = 0; i < storyLines.size(); i++) {
            final TextView story_view = new TextView(this);
            int currId = prevId + 1;
            story_view.setId(currId);
            //story_view.setText(storyLines.get(i));
            story_view.setTextColor(Color.BLUE);
            RelativeLayout.LayoutParams params1 =
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params1.addRule(RelativeLayout.BELOW, prevId);
            prevId = currId;
            rl.addView(story_view, params1);
            tvs.add(story_view);
        }
        tvs.get(0).setText(storyLines.get(0));
        for (int i = 0; i < tvs.size() - 1; i++) {
            TextView current_view = tvs.get(i);
            final TextView next_view = tvs.get(i + 1);
            final String nextStoryLine = storyLines.get(i + 1);
            current_view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    next_view.setText(nextStoryLine);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}