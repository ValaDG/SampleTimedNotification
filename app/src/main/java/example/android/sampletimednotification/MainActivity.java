package example.android.sampletimednotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private AlarmManager alarmMgr;
  private PendingIntent alarmIntent;
  private Context mContext;
  private int milliseconds = 1000;
  private int times = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mContext = getApplicationContext();

    alarmMgr = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(mContext, AlarmReceiver.class);
    alarmIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0);

    alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
        SystemClock.elapsedRealtime() +
            times * milliseconds, alarmIntent);

  }
}
