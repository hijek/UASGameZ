package dzaki201804016.trpl.pei.gamez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvdata: RecyclerView
    lateinit var apiService: ServiceInterface
    private var ambilData: ArrayList<GameData> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.utama)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
        apiService.getGame().enqueue(object : Callback<List<GameData>> {
            override fun onResponse(
                call: retrofit2.Call<List<GameData>>,
                response: Response<List<GameData>>
            ) {
                if (response.isSuccessful){
                    val res = response.body()
                    ambilData.addAll(res!!)
                    rvdata = findViewById(R.id.rv_views)
                    rvdata.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvdata.adapter = GameAdapter(ambilData)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<GameData>>, t: Throwable) {
            }
        })
    }
}