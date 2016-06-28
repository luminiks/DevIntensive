package com.softdesign.devintensive.ui.activities;

import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.ConstantManager;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = ConstantManager.TAG_PREFIX + "Main Activity";
    private ImageView mCallImg;
    private CoordinatorLayout mCoordinatorLayout;




    /**
     * Метод вызывыется при создании активити (после изменения конфигурации/возврата к тукущкй
     * активности после его уничтожения).
     *
     *в данном методе инициализируется/произволится :
     * - UI ользовательский интерфейс (статика)
     * - инициализациястатических данных активити
     * - связь данных по спискам (инициализация адапторов)
     *
     * Не запускать длительные операции по работе с данными в onCreate() !!!
     *
     * @param savedInstanceState - бъект со значениями в Bundle - состояние UI
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        mCallImg = (ImageView)findViewById(R.id.call_img);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator_container);

        mCallImg.setOnClickListener(this);

        if (savedInstanceState == null){
            // активити запускатеся впевые
            showSnacbar("Активити запускается впервые");

        } else {
            // активити уже создавалось
            showSnacbar("Активити уже создано");


        }

    }

    /**
     * Метод вызывается при старте активити перед моментом того как UI станет доступен пользователю
     * как правило в данном методе происходит регистрация подписки на события остановка которых была
     * произведена в onStop()
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    /**
     * Метод вызывается когда активити становится доступна пользователю для взаимодействия
     * в данном методе как правило происходит запуск анимации/аудио/видео/запуск BroadCastReceiver
     * необходимых для реализации UI логики/запуск выполнения потоков и т.д.
     * методдолжен быть максимально легковесным или максимальной отзывчивости UI
      */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    /**
     * Метод вызывается когда текущая активация теряет фокус но остается видимой(всплытие
     * диалогового окна/частичное перекрытие другой активити/ и т.д.)
     * в данно методе реализуют сохранение легковесных UI анных/анимации/аудио/видео и т.д.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    /**
     * Метод вызываетя когда активити становится невидимым для пользователя.
     * в данном методе проиходит отписка от событий, остановка сложных анимаций, сложные операции по
     * сохранению данных/прерывание запущенных потоков/и т.д.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    /**
     * Метод вызывается при окончании работы активити (когда это происходит системно или после вызова
     * метода finish() )
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * Метод вызывается при рестарте активити/возобновлении работы после вызова метода onStop()
     * в данном методе реализуется специфическая бизнес логика которая должна быть реализована именно
     * при рестарте активности - например запрос к серверу которые необходимо вызывать при возвращении
     * из другой активности (обновление данных, подписка на определённое событие проинициализированное
     * на другом экране/специфическая бизнес логика завязанная именно на перезапуске активити)
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.call_img:
                /*showProgress();
                runWithDelay();*/
                break;

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    private void showSnacbar(String message){
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }
}
