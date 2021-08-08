package dzaki201804016.trpl.pei.gamez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SysreqActivityZZ : AppCompatActivity() {
    //lateinit var btnCancel:Button
    lateinit var etOs1: TextView
    lateinit var etPro1: TextView
    lateinit var etMemo1: TextView
    lateinit var etGrap1: TextView
    lateinit var etDir1: TextView
    lateinit var etNet1: TextView
    lateinit var etStor1: TextView
    lateinit var etSc1: TextView
    lateinit var etNama: TextView
    lateinit var etGenre: TextView
    lateinit var valName: String
    lateinit var valGenre: String
    lateinit var valOs1: String

    lateinit var apiService: ServiceInterface
    private var ambilData: ArrayList<GameData> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sysreq)
        getMyData()
        declaration()
        myfunction()

    }
    fun declaration(){
        //btnCancel = findViewById(R.id.btn_up_cancel)
        etOs1 = findViewById(R.id.txtos1)
        etPro1 = findViewById(R.id.txtpro1)
        etMemo1 = findViewById(R.id.txtmemo1)
        etGrap1 = findViewById(R.id.txtgrap1)
        etDir1 = findViewById(R.id.txtdir1)
        etNet1 = findViewById(R.id.txtnet1)
        etStor1 = findViewById(R.id.txtstor1)
        etSc1 = findViewById(R.id.txtsc1)
        etNama = findViewById(R.id.tv_nama)
        etGenre = findViewById(R.id.tv_genre)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
    }
    fun getMyData(){
        val myValue = intent.extras
        if (myValue!=null){
            valName = myValue.getString("nama").toString()
            valGenre = myValue.getString("genre").toString()
            valOs1 =  myValue.getString("os").toString()
        }
    }
    fun myfunction(){
        etNama.setText(valName)
        etGenre.setText(valGenre)
        etOs1.setText(valOs1)
//        val pindah = Intent(this, MainActivity::class.java)
//
//        btnCancel.setOnClickListener {
//            startActivity(pindah)
  //      }
    }
}