package hr.fabolicodi.firebasevjezba

import android.content.Context
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ValueEventListener
import hr.fabolicodi.firebasevjezba.databinding.TextItemBinding

class TextAdapter(
    private val list: ArrayList<vatrenabaze>,
    private val th:Context,
    private val  listener: (Int)->Unit
):
    RecyclerView.Adapter<TextAdapter.ViewHolder>()


{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.ViewHolder {
    val v=TextItemBinding.inflate(LayoutInflater.from(th),parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position],th)
        holder.itemView.setOnClickListener{
            listener(position) }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(private var itemBinding: TextItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(Text:vatrenabaze,th: Context){
            itemBinding.tv1.text=Text.id.toString()
            itemBinding.tv2.text=Text.texst
            itemBinding.disc.text=Text.disc
        }

    }
}