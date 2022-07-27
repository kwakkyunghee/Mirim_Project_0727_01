package kr.hs.emirims2117.mirim_project_0727_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCheck;
    String[] itemsArr = {"Italy", "France", "Spain"};
    boolean[] checkArr = {false, false, false}; //초기상태
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck = findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(btnCheckListener);
    }
    View.OnClickListener btnCheckListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("체크목록대화상자");
            dlg.setIcon(R.drawable.dkdlzhs);
            dlg.setMultiChoiceItems(itemsArr, checkArr, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    //i(체크번호/ 첫 번째 체크박스가 선택되어있으면 0, 두 번째 체크박스가 선택되어있으면 1) b(체크되어있는지 안되어있는지/ 체크되어있으면 true 안되어있으면 false)
                    checkArr[i] = b;
                    btnCheck.setText("");
                    for(int j=0; j < checkArr.length; j++){
                        if(checkArr[j]){
                            btnCheck.append(itemsArr[j]);
                        }
                    }
                }
            });

            dlg.setNegativeButton("닫기", null);
            dlg.show();


        }
    };

}