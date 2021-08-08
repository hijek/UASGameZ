package dzaki201804016.trpl.pei.gamez


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SysreqAdapter(private val listku: ArrayList<SysreqData>): RecyclerView.Adapter<SysreqAdapter.SysreqViewHolder>(){
    inner class SysreqViewHolder(viewku: View): RecyclerView.ViewHolder(viewku) {
        var tvOs: TextView = viewku.findViewById(R.id.txtos1)
        var tvProcessor: TextView = viewku.findViewById(R.id.txtpro1)
        var tvMemory: TextView = viewku.findViewById(R.id.txtmemo1)
        var tvGraphics: TextView = viewku.findViewById(R.id.txtgrap1)
        var tvDirectx: TextView = viewku.findViewById(R.id.txtdir1)
        var tvNetwork: TextView = viewku.findViewById(R.id.txtnet1)
        var tvStorage: TextView = viewku.findViewById(R.id.txtstor1)
        var tvSoundCard: TextView = viewku.findViewById(R.id.txtsc1)
        var apiIterface: ServiceInterface? = Repository.getDataAPI().create(ServiceInterface::class.java)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SysreqViewHolder {
        val viewView: View = LayoutInflater.from(parent.context).inflate(R.layout.sysreq, parent, false)
        return SysreqViewHolder(viewView)
    }

    override fun onBindViewHolder(holder: SysreqViewHolder, position: Int) {
        val dataku = listku[position]
        holder.tvOs.text = dataku.os
        holder.tvProcessor.text = dataku.processor
        holder.tvMemory.text = dataku.memory
        holder.tvGraphics.text = dataku.graphics
        holder.tvDirectx.text = dataku.directx
        holder.tvNetwork.text = dataku.network
        holder.tvStorage.text = dataku.storage
        holder.tvSoundCard.text = dataku.soundcard

    }
    //
    override fun getItemCount(): Int {
        return listku.size
    }
//
}
