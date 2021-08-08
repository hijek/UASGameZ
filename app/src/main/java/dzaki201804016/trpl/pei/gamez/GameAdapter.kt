package dzaki201804016.trpl.pei.gamez


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameAdapter(private val listku: ArrayList<GameData>): RecyclerView.Adapter<GameAdapter.GameViewHolder>(){
    inner class GameViewHolder(viewku: View): RecyclerView.ViewHolder(viewku) {
        var tvNama: TextView = viewku.findViewById(R.id.tv_nama)
        var tvGenre: TextView = viewku.findViewById(R.id.tv_genre)
        var btninfo: Button = viewku.findViewById(R.id.btn_info)
        var apiIterface: ServiceInterface? = Repository.getDataAPI().create(ServiceInterface::class.java)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val viewView: View = LayoutInflater.from(parent.context).inflate(R.layout.utama_item, parent, false)
        return GameViewHolder(viewView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val dataku = listku[position]
        holder.tvNama.text = dataku.nama
        holder.tvGenre.text = dataku.genre
        holder.btninfo.setOnClickListener {
            val bundle= Bundle()
            val pindah = Intent(holder.itemView.context, SysreqActivity::class.java)
            bundle.putString("nama", dataku.nama.toString())
            bundle.putString("genre", dataku.genre.toString())
            bundle.putString("id", dataku.id.toString())

            pindah.putExtras(bundle)
            holder.itemView.context.startActivity(pindah)

        }

    }

    override fun getItemCount(): Int {
        return listku.size
    }

}
